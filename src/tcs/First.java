package tcs;

public class First {
    public static void main(String[] args) {
        System.out.println(month(40));
    }
    static int month(int n){
        int count=0;
        for (int i = 1; i <n; i+=6) {
            count++;
        }
        return count;
    }
}
