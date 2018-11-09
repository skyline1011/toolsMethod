package com.lsrobot.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

/**
 * MD5工具类
 */
public class MD5Utils {
    private static String savePass = "AZICOnu9cyUFFvBp3xi1AA==";//admin123的不加盐密文
    /**
     * 普通MD5加密
     */
    public static String md5(String passwd){
        byte[] secretBytes = null;
        MessageDigest md5 = null;
        //通过MD5计算摘要
        try {
            md5 = MessageDigest.getInstance("MD5");
            secretBytes = md5.digest(passwd.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        String str = Base64.getEncoder().encodeToString(secretBytes);
        return str;
    }

    /**
     * 获取随机定长字符串
     * @return
     */
    public static String getString(int length){
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int len = base.length();
        int index = 0;
        char ch;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            index = (int)(Math.random()*len);
            ch = base.charAt(index);
            sb.append(ch);
        }
        return sb.toString();
    }

    //密码加盐：加盐为16位随机字符
    public static String md5AndSalt(String  passwd){
        String salt = getString(16);
        System.out.println(salt);
        String str = md5(passwd + salt);
        System.out.println("加盐后的密码为：" +str);
        return str;
    }

    private static boolean login(String passwd){
        if(savePass.equals(md5(passwd))){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        //        String passwd = "admin123";
        String passwd;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入密码：");
        passwd = scanner.nextLine();
        boolean result = login(passwd);
        System.out.println("登录结果为：" + result);
    }
}
