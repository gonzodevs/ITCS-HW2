package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class Part4 {
    long startTime = System.nanoTime();
    int maxi;
    int count;
    int fin[]=new int[5];
    public static void main(String[] args) {
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
        System.out.println("the running time was:" +n.getEstimatedTime());
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
        //recurrence is O(n) as it will decrease n by 1 every run and when n==0 simply return the sum of fin which is O(n)
        return number(arr,n-1,k);
    }
    //O(n) however based on number() algorithm this will always be constant time as the size of (a) does not change)
    public int sum(int a[]){
        int tmp=0;
        for (int i = 0; i < a.length ; i++) {
           tmp=tmp+a[i];
        }
        return tmp;
    }
    //O(1) it takes constant time for this operations.
    public int diff(int a,int b){
        if(a-b>=0)
            return a-b;
        else
            return b-a;

    }
    //O(n)however based on number() algorithm this will always be constant time as the size of (a) does not change)
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
    long estimatedTime = System.nanoTime() - startTime;
    public long getEstimatedTime() {
        return estimatedTime;
    }
}
