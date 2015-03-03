package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
//bug try  5,5,5,5,4,5,5 and 4 is not replaced with 5
public class Part4 {
    int maxi;
    int maxdiff;
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
        System.out.println(n.number(arr, arr.length - 1, k));
    }
    public int number(int arr[],int n, int k) {

        if(n==0)
            return sum(fin);
        for (int i = 0; i < fin.length ; i++) {
            if(diff(arr[n],k)<=diff(fin[i],k)){
                if(count==5)
                {
                    for (int j = 0; j <5 ; j++) {
                        if(diff(fin[j],k)>=maxdiff){
                            maxdiff=diff(fin[j],k);
                            maxi=j;
                        }
                    }
                    fin[maxi]=arr[n];
                    maxdiff=0;
                    maxi=0;
                    break;
                }
                else
                {
                    fin[count]=arr[n];
                    count++;
                    break;
                }
            }


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
}
