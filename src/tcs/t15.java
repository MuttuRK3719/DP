package tcs;

public class t15 {
    public static void main(String[] args) {
        System.out.println(sum(2,2,2));

    }
    static int sum(int p,int q, int r){
        int steps=0;
        if(p==q&&r>p){
            while(p!=r) {
                steps++;
                p++;
                q = p;
                r--;
            }
            if(p==r)
                return steps;
        }

    else   if(p!=q)
         return -1;
    return 0;
    }
}
