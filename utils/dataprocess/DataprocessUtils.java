package com.cc.utils.dataprocess;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author changcheng
 * @version 2017/7/22
 * @description
 */
public class DataprocessUtils {
    /**
     * 执行MD5加密操作
     * @param source 源字符串
     * @return		  目标字符串
     */
    public static String md5(String source) {

        //0.对源字符串进行有效性验证
        if(source == null || source.length() == 0) {
            return null;
        }

        //1.声明字符数组
        char[] c = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        //2.声明StringBuilder
        StringBuilder builder = new StringBuilder();

        //3.获取源字符串对应的字节数组
        byte[] bytes = source.getBytes();

        try {
            //4.获取MessageDigest对象
            MessageDigest digest = MessageDigest.getInstance("md5");

            //5.执行加密
            byte[] targetBytes = digest.digest(bytes);

            //6.遍历加密得到的字节数组
            for (int i = 0; i < targetBytes.length; i++) {
                byte b = targetBytes[i];

                //7.获取当前字节数高四位和低四位的值
                int high = (b >> 4) & 15;
                int low = b & 15;

                //8.将高四位和低四位转换成十六进制字符
                char highChar = c[high];
                char lowChar = c[low];

                //9.拼装到StringBuilder中
                builder.append(highChar).append(lowChar);
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }
}
