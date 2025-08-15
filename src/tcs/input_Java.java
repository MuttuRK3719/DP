package tcs;

import java.util.*;

public class input_Java {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of arr");
        int n=sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for(int i:arr)   System.out.println(i+" ");


//        ArrayListttttttttttttttttttttttttttttttttttttttttt
        {
            System.out.println("Try programiz.pro");
            int num=sc.nextInt();
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<num;i++){
                list.add(sc.nextInt());
            }
            for(int i:list)  System.out.print(i+ " ");
            for(int i=0;i<num;i++)  System.out.print(list.get(i)+ " ");
        }

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
//import java.util.ArrayList;
//import java.util.Scanner;

        String str=sc.nextLine();
        // System.out.println(str);
        String []str11=str.split(" ");
        int []arr1=new int[str11.length];
        for(int i=0;i<str11.length-1;i++)
            arr[i]=Integer.parseInt(str11[i]);
        for(int i:arr)
            System.out.println(i+" ");

    }
}
