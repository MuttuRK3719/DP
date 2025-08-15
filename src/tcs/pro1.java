package tcs;

import java.util.Arrays;

public class pro1 {
    public static void main(String[] args) {
        int []arr={1,1,1,2,2,3};
        System.out.println(a(arr)+" "+ Arrays.toString(arr));
    }
    public static int a(int []arr){
        int left=0;
        boolean b=false;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]==arr[left]&&!b){
                arr[++left]=arr[i];
                b=true;
            }
            else if(arr[i]!=arr[left]){
                arr[++left]=arr[i];
                b=false;
            }
        }
        return left;
    }
}
