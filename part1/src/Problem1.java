import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class Problem1{

    // I/O source:http://stackoverflow.com/questions/2864117/read-data-from-a-text-file-using-java
    //source for running times: http://www.tutorialspoint.com/java/lang/system_nanotime.htm
    //some code adaptation and some logic from http://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
    public static void main(String[] args) {
        long startTime = System.nanoTime();
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
        int mxsum=0;
        for (int i = 0; i < a.size(); i++) {
            mxsum=mxsum+(Integer)a.get(i);
        }
        if(mxsum%2==0)
            program.combinations((Integer[]) a.toArray(new Integer[a.size()]),a.size(),mxsum/2,a.size());
        else
            System.out.println("Not solvable");
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("the running time was:" +estimatedTime);
    }
    void combinations(Integer[] arr, int arrsize,int maxsum,int solsize)
    {
        int sol[] = new int[solsize];
        for (int i = 0; i < arr.length ; i++) {
            process(arr, sol, 0, arrsize - 1, 0, i, maxsum);
        }
        if(done==false){
            System.out.println("Not solvable");
        }
    }

    boolean done=false;
    void process(Integer arr[], int sol[], int start, int end, int index, int comnum,int maxsum)
    {

        ArrayList tmp=new ArrayList();

        if (index == comnum || done==true)
        {
            for (int j=0; j<comnum; j++){
                if (sol[j]!=0)
                    tmp.add(sol[j]);
            }
            int tmpsum=0;
            for (int i = 0; i < tmp.size(); i++) {
                tmpsum=tmpsum+(Integer)tmp.get(i);
            }
            if(tmpsum==maxsum && done==false){
                ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(arr));
                for (int i = 0; i <tmp.size() ; i++) {
                    arrayList.remove(tmp.get(i));
                }
                int cursum=0;
                for (int i = 0; i < arrayList.size(); i++) {
                    cursum=cursum+(Integer)arrayList.get(i);
                }
                if(cursum==tmpsum){
                System.out.println("set A: "+tmp);
                System.out.println("set B: "+arrayList);
                done=true;
                }
            }
        }

        for (int i=start; i<=end && end-i+1 >= comnum-index; i++)
        {
            if (done == true)
                break;
            sol[index] = arr[i];
            process(arr, sol, i + 1, end, index + 1, comnum, maxsum);
        }
    }

}
