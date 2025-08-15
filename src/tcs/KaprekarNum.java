package tcs;

import java.util.Arrays;
import java.util.Comparator;

public class KaprekarNum {
    public static void main(String[] args) {
        int num=45;
        num*=num;
        int a=num%100;
        num/=100;
        System.out.println(kapreticNum(3524));

    }
    static boolean kapreticNum(int num){

        while(num!=6274) {
            int asc = sort(num, true);
            int des = sort(num, false);
            num=des-asc;
        }
        return true;
    }
    static int sort(int num,boolean order){
        int[] arr =new int[4];
        int temp=num;
        int i=0;
        while(num!=0){
            arr[i++]=num%10;
            num/=10;
        }
        if(order) Arrays.sort(arr);
        else arr=Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int value=0;
        for (int j = 0; j <4 ; j++) {
            value=value*10+arr[j];
        }
        return value;
    }
}
