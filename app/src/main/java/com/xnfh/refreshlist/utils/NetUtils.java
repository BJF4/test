package com.xnfh.refreshlist.utils;

import android.annotation.TargetApi;

import java.util.Base64;

/**
 * Created by wangxuewei on 2017/10/16.
 */
public class NetUtils {
    public static String sKey = "4639F23A227ED732DECD17E06857C504";
    /// <summary>
    /// 解密
    /// </summary>
    /// <param name="pToDecrypt">要解密的以Base64</param>
    /// <param name="sKey">密钥，且必须为8位</param>
    /// <returns>已解密的字符串</returns>
    public static String DesDecrypt(String pToDecrypt)
    {
        //转义特殊字符
        pToDecrypt = pToDecrypt.replace("-", "+");
        pToDecrypt = pToDecrypt.replace("_", "/");
        pToDecrypt = pToDecrypt.replace("~", "=");
        return "";
    }

}
