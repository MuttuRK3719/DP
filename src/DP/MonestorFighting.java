  public static void main(String[] args) {
        int[][]arr={{120,10},{50,5},{100,15}};
        System.out.println(removeElement(arr,100));
    }
    static int removeElement(int[][]arr,int energy){
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int count=0;
        for(int i=0;i<arr.length;i++){
            int power=arr[i][0];
            int bonus=arr[i][1];
            if(power>energy){
                return count;
            }
            energy+=bonus;
            count++;
        }
        System.out.println(Arrays.deepToString(arr));
        return count;
    }
