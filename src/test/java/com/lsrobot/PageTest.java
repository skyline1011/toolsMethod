package com.lsrobot;

/**
 * 分页算法
 */
public class PageTest {
    public static void main(String[] args) {
        int rows = 256;
        int pageSize = 20;
        int totalPages;

        if(rows%pageSize==0){
            totalPages = rows/pageSize;
        }else {
            totalPages = rows/pageSize + 1;
        }

        System.out.println(">>>>>>>>>>>>>>" + totalPages);
    }
}
