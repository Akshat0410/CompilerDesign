package com.anupam.compiler.Lab3;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ans=fib(n);
        System.out.println(ans);
    }

    private static int fib(int n) {

        if(n<=1) return n;
        return fib(n-1)+fib(n-2);
    }
}
