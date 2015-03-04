import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Problem1{
    long startTime = System.nanoTime();
    // I/O source:http://stackoverflow.com/questions/2864117/read-data-from-a-text-file-using-java
    //source for running times: http://www.tutorialspoint.com/java/lang/system_nanotime.htm
    public static void main(String[] args) {
        System.out.println("initialize");
        ArrayList a=new ArrayList();
        try {
            File file = new File("input.txt");
            Scanner in = new Scanner(file);
            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                if(in.hasNextLine()){
                    a.add(Integer.parseInt(in.next()));
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList b=new ArrayList();
        Problem1 program=new Problem1();
        if(program.twoPart(b, a, a.size()-1)){
            System.out.println("Problem solvable with groups above");
        }
        else
            System.out.println("not solvable");
        System.out.println("the running time was:" +program.getEstimatedTime());
    }
    public boolean twoPart(ArrayList arr1,ArrayList arr2,int n){
        if(sum(arr1)==sum(arr2)){
            System.out.println("Group A:"+arr1);
            System.out.println("Group B:"+arr2);
            return true;
        }
        if(n==0 && sum(arr1)!=sum(arr2))
            return false;

        arr1.add(arr2.get(n));
        arr2.remove(n);
        if(check(arr1,arr2)>-1){
            int index = check(arr1,arr2);
            arr1.add(arr2.get(index));
            arr2.remove(index);
        }
        return twoPart(arr1,arr2,n-1);

    }
    public int sum(ArrayList a){
        int s=0;
        for (int i = 0; i <a.size() ; i++) {
            s=s+(Integer)a.get(i);
        }
        return s;
    }
    public int check(ArrayList arr1,ArrayList arr2){
        for (int i = 0; i <arr2.size() ; i++) {
            if(sum(arr1)+(Integer)arr2.get(i)==sum(arr2)-(Integer)arr2.get(i)){
                return i;
            }
        }
        return -1;
    }
    long estimatedTime = System.nanoTime() - startTime;

    public long getEstimatedTime() {
        return estimatedTime;
    }
}
