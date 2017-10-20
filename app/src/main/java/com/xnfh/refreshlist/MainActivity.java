package com.xnfh.refreshlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.xnfh.refreshlist.widget.PullRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PullRefreshLayout refreshLayout;
//    private RecyclerView recyclerView;
    private ListView listView;
    private List<String> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refreshLayout = (PullRefreshLayout) findViewById(R.id.pullRefresh);
//        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        listView = (ListView) findViewById(R.id.lv_view);
        initData();
//        MyRecycleAdapter adapter = new MyRecycleAdapter(this,dataList);
//        recyclerView.setAdapter(adapter);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataList);
        listView.setAdapter(adapter);
        refreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            for (int m=0;m<5;m++) {
                                dataList.add("添加的数据" + m);
                            }
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                refreshLayout.setRefreshing(false);
                                adapter.notifyDataSetChanged();
                            }
                        });
                    }
                }.start();
            }
        });
    }
    private void initData() {

        OkGo.<String>get("www.baidu.com").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String mess = response.message();
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);

            }
        });
        for (int i=0;i<50;i++) {
            dataList.add("data " + i);
        }
    }
}
