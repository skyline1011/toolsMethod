package com.lsrobot.utils;

import java.util.Arrays;

/**
 * String常用方法
 */
public class StringUtils {

    //扩充数组算法
    public static void arrayExtension(int length){
        int [] cs = new int[5];//一定要给个数组长度
        int count =0;
        for(int i=0;i<length;i++){
            if(count>=cs.length){
                int newLen = cs.length * 3 / 2 + 1;//扩充原来数组的一半
                int newLen1 = cs.length * 2;//扩充原来数组的一倍
                //noinspection Since15
                cs = Arrays.copyOf(cs,newLen);
                System.out.println("数组长度为：" + cs.length);
            }
            cs[i] = i;
            count++;
            System.out.println(cs[i]);
        }
        System.out.println("最终的数组长度为：" + cs.length);
    }

    //字符串常用方法
    public static void strMethod(){
        String str = "adwfewfa62344234";

        System.out.println(str.replace('w','*'));//ad*fe*fa62344234
        System.out.println(str.replaceAll("[0-9]","*"));//adwfewfa********
        System.out.println(str.replaceAll("\\d","*"));//adwfewfa********

        String str1 = "abcdefg";
        System.out.println(str1.substring(0,4));//abcd

        String str2 = "abcdefg";
        System.out.println(Arrays.toString(str2.split("d")));//[abc, efg]

        String str3 = "abcdefgffd";
        System.out.println(str3.contains("g"));//true
        System.out.println(str3.indexOf("c"));//2
        System.out.println(str3.lastIndexOf("f"));//8
    }

    //字符串翻转的两个方法
    public static void strReverse(){
        String str1 = "abcdefg123adf";
        char [] c3 = str1.toCharArray();

        //字符串翻转
        for(int i=c3.length-1;i>=0;i--){
            System.out.print(c3[i]);
        }
        System.out.println();

        //字符串翻转
        StringBuilder sb = new StringBuilder(str1);
        String newStr = sb.reverse().toString();
        System.out.println(newStr);
    }

    public static void main(String[] args) {
        strReverse();
        System.out.println("----------------------------------------------------");
        strMethod();
        System.out.println("----------------------------------------------------");
        arrayExtension(100);
    }
}
