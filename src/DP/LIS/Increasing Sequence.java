
https://codeforces.com/problemset/problem/1817/A?utm_source=chatgpt.com
3
5
1 3 2 6 7
4
2 3 4 5
1
1
OutputCopy
8
4
2
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
        int n=sc.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(goodSequenceMinValue(arr.length,arr));
    }
    }
    static int goodSequenceMinValue(int n,int[]arr){
        int firstValue=1;
        if(arr[0]==1)firstValue++;
        for(int i=1;i<n;i++){
            if(arr[i]==firstValue+1) firstValue=arr[i]+1;
            else firstValue++;
        }
        return firstValue;
    }
}
