package tcs;

import java.util.*;
public class march26 {
    public static void main(String[] args) {
//        int[]arr={1,10,1,5};
        int[]arr={3,90,5,7,2,50,66,78};
        Arrays.sort(arr);
        int n=arr.length;
        int[]arr1=new int[n];
        for(int i=0;i<n;i++){
            if(i==0||i==n-1&&(arr[i]-arr[i+1]>0)) {
                arr1[i] = arr[i];
            }
            else if  (arr[i]-arr[i+1]>0 )
            {
             arr1[i]=arr[i]-1;
            }
        }
        for(int i:arr1) System.out.println(i+" ");
    }

}
