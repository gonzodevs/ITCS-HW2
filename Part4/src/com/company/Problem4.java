package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class Problem4 {

    int count;
    int fin[]=new int[5];
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int arr[]=new int[Integer.parseInt(args[0])];
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
        Problem4 n=new Problem4();
        System.out.println("The sum of this array="+n.number(arr, arr.length-1 , k)+" and k="+k);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("the running time was:" +estimatedTime);
    }

    public int number(int arr[],int n, int k) {
        fin[0]=arr[0];
        fin[1]=arr[1];
        fin[2]=arr[2];
        fin[3]=arr[3];
        fin[4]=arr[4];
        int finSum=arr[0]+arr[1]+arr[2]+arr[3]+arr[4];
        for (int i = 0; i <n ; i++) {
            for (int j = i+1; j <n ; j++) {
                for (int l = j+1; l <n ; l++) {
                    for (int m = l+1; m <n ; m++) {
                        for (int o = m+1; o <n ; o++) {
                            int tmpsum=arr[i]+arr[j]+arr[l]+arr[m]+arr[o];
                            if(tmpsum==k){
                                fin[0]=arr[i];
                                fin[1]=arr[j];
                                fin[2]=arr[l];
                                fin[3]=arr[m];
                                fin[4]=arr[o];
                                System.out.println("perfect match with the elements: " + Arrays.toString(fin));
                                finSum=tmpsum;
                                return finSum;
                            }
                            if(Math.abs(tmpsum-k)<=Math.abs(finSum-k)){
                                fin[0]=arr[i];
                                fin[1]=arr[j];
                                fin[2]=arr[l];
                                fin[3]=arr[m];
                                fin[4]=arr[o];
                                finSum=tmpsum;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(fin));
        return finSum;

    }



}
