import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long high = 0;
        long low = 0;
        int[] arr = new int[5];
        for(int i=0; i < 5; i++){
            arr[i] = in.nextInt();
        }
        
        high = sum(arr) - highest(arr);
        low = sum(arr) - lowest(arr);
        System.out.print(high + " " + low);    
        
        
    }
    
    public static long sum(int arr[]){
        long sum = 0;
        for(int i=0; i < 5; i++){
            sum += arr[i];
        }
        return sum;
    }
    
    public static long highest(int arr[]){
        long highestNum = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (highestNum < arr[i]){
                highestNum = arr[i];
            }
        }
        return highestNum;
    }
    
    public static long lowest(int arr[]){
        long lowestNum = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (lowestNum > arr[i]){
                lowestNum = arr[i];
            }
        }
        return lowestNum;
    }
}
