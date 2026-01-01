
class Main {
    public static void main(String[] args) {
        int[]arr={1,2,3,4,5,6,9};
        System.out.println(summmerArr(arr));
    }
    static int summmerArr(int []arr){
        int evenSort=count(arr,1);
        int oddSort=count(arr,0);
        return Math.min(evenSort,oddSort);
    }
    static int count(int []arr,int parity){
    int pos=0,count=0;
    for(int i=0;i<arr.length;i++){
        if(arr[i]%2==parity){
            count+=Math.abs(pos-i);
            pos++;
        }
    }
    return count;
    }
}
