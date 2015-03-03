import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
//expect 2 command line arguements, N(number of items to be read from input.txt) and K(used to find congruence to 0 mod k)
// I/O source http://stackoverflow.com/questions/2864117/read-data-from-a-text-file-using-java
//bug sum is not looked for only numbers who % k==0?
public class Part3 {
    ArrayList end= new ArrayList();
    int count;
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
        Part3 a=new Part3();
        int k=Integer.parseInt(args[1]);
        //should contain 4 values whose sum % k ==0
       ArrayList value= a.congrutent(arr,k,arr.length-1);
        if(a.getCount()<4){
            System.out.println("no result");
        }
        else
            System.out.println("The 4 values whose sum is congruent to 0 mod "+k+" "+ value);

    }
    public  ArrayList congrutent(int arr[],int k, int n){
        if(count==4 || n==0){
            return end;
        }

        if(modk(arr[n],k)==true && addToList(arr[n])==true){
        }
        return congrutent(arr,k,n-1);


    }

    boolean addToList(int a){
        if(count==4)
            return false;

        end.add(a);
        count++;
        return true;
    }

    //determines if a value mod k ==0
    public boolean modk(int a,int k)
   {
        if(a%k==0)
            return true;
        else
            return false;
    }
    public  int getCount(){
        return count;
    }

}
