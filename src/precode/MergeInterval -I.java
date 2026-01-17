Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

class Solution {
    public int[][] merge(int[][] val) {
       Arrays.sort(val,new Comparator<int[]>(){
        public int compare(int[]a,int []b){
            return a[0]-b[0];
        }
       });
       int k=0;
       for(int i=1;i<val.length;i++){
        if(val[k][1]>=val[i][0]&&val[k][1]<val[i][1]){
          val[k][1]=val[i][1];
        }
        else if(val[k][1]<val[i][1]) {
            val[++k][0]=val[i][0];
            val[k][1]=val[i][1];
        }
       }
       int [][]result=new int[k+1][2];
       for(int i=0;i<=k;i++){
        result[i][0]=val[i][0];
        result[i][1]=val[i][1];
       }
       return result;
    }
}
