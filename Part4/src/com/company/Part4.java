package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class Part4 {
    int maxi;
    int count;
    int fin[]=new int[5];
    public static void main(String[] args) {
        System.out.println("intialized");
        int arr[]=new int[Integer.parseInt(args[0])+1];
        try {
            File file = new File("input.txt");
            Scanner in = new Scanner(file);
            for (int i = 0; i < arr.length; i++) {
                if(in.hasNextLine()){
                    arr[i]=Integer.parseInt(in.next());
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int k=Integer.parseInt(args[1]);
        Part4 n=new Part4();
        System.out.println(n.number(arr, arr.length-1 , k));
    }
    public int number(int arr[],int n, int k) {

        if(n<0)
            return sum(fin);
        int l=0;
        while(count<5){
            fin[l]=arr[n];
            n=n-1;
            l=l+1;
            count++;
        }
        maxi=maxdiff(fin,k);
        if(diff(arr[n],k)<diff(fin[maxi],k)){
            fin[maxi]=arr[n];
        }
        System.out.println(Arrays.toString(fin));
        return number(arr,n-1,k);
    }
    public int sum(int a[]){
        int tmp=0;
        for (int i = 0; i < a.length ; i++) {
           tmp=tmp+a[i];
        }
        return tmp;
    }
    public int diff(int a,int b){
        if(a-b>=0)
            return a-b;
        else
            return b-a;

    }
    public int maxdiff(int a[],int k){
        int max=0;
        int index=-1;
        for (int i = 0; i <a.length ; i++) {
            if(diff(a[i],k)>max){
                index=i;
                max=diff(a[i],k);
            }
        }
        return index;
    }
}
