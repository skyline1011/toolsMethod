package com.lsrobot.utils;

import java.util.Scanner;

/**
 * for循环
 * 从键盘接收一个整数N，输出N个菲波那切数列（Fibonacci）：1 1 2 3 5 8 13 21 34 55
 * 特点：第一、第二个数值为1，从第三个数开始，该数是前面两个数之和
 */
public class FibonacciTest {
    public static void method01(){
        int n1 = 1,n2 =1;//第一、第二个数值
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数（数列长度）：");
        int num = scanner.nextInt();//需要输出的Fibonacci数列的个数
        int next = 0;

        System.out.print(n1 + " " + n2 + " ");
        for(int i=0;i<num-2;i++){
            next = n1 + n2;
            System.out.print(next + " ");
            n1 = n2;
            n2 = next;
        }
        System.out.println();
    }

    public static void method02(){
        int n1 = 1,n2 =1;//第一、第二个数值
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数（数列长度）：");
        int num = scanner.nextInt();//需要输出的Fibonacci数列的个数
        int next = 0;
        int[] fibonacci = new int[num];
        fibonacci[0] = n1;
        fibonacci[1] = n2;

        for(int i=0;i<num-2;i++){
            next = n1 + n2;
            fibonacci[i+2] = next;
            n1 = n2;
            n2 = next;
        }

        for(int i =0;i<num;i++){
            System.out.print(fibonacci[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        method01();
        System.out.println("----------------------------------");
        method02();
    }
}
