package tcs;

public class StringOperation {
    public static void main(String[] args) {
        String str="MUTTU";
        System.out.println(reverse(str));
    }
    static String reverse(String str){
        StringBuilder st=new StringBuilder();
        for (int i = str.length()-1; i>=0 ; i--) {
            st.append(str.charAt(i));
        }
        return st.toString();
    }
}
