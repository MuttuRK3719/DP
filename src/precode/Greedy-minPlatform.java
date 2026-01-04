  public int minPlatform(int arr[], int dep[]) {
        //  code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0,j=0;
        int maxCount=0,count=0;
        while(i<arr.length){
            if(arr[i]<=dep[j]){
                i++;
                count++;
            }
            else{
                j++;
                count--;
            }
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
