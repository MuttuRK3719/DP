package tcs;

import java.util.*;
public class TCS2 {
    public static void main(String []a){
        Scanner sc=new Scanner (System.in);
        String str=sc.next();
        int num=str.length();
        for(int i=0;i<str.length()-1;i++){
            for(int j=i+1;j<num;j++) {
                if (str.charAt(i) != str.charAt(j))
                    System.out.println(str.charAt(i));
                else System.out.println("None");
                break;
            }
        }
        for(int i=0;i<str.length()-1;i++){
            for(int j=i+1;j<num;j++) {
                if (str.charAt(i) == str.charAt(j))
                    System.out.println(str.charAt(i));
                break;
            }
        }
    }
}
