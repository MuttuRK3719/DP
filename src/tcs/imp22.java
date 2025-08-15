package tcs;

import java.util.*;

public class imp22 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("ENter the n");
        int n=sc.nextInt();
        StringBuilder sb=new StringBuilder();
//        sb.dele;
        int [][]arr=new int[n][];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the size for row "+(i+1)+" :");
            int m=sc.nextInt();
            arr[i]=new int[m];
            for (int j = 0; j <m; j++) {
            arr[i][j]=sc.nextInt();
        }
    }
//        for(int []i:arr) System.out.println(Arrays.toString(i));
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
}}
