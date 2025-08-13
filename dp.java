   public int frogJump(int[] heights) {
        int []dp=new int[heights.length+1];
        for(int i=0;i<dp.length;i++)dp[i]=-1;
        return frogJump(heights,dp,dp.length-1);
    }
    public int frogJump(int []h,int[]dp,int index){
        if(index==0) return 0;
        if(dp[index]!=-1) return dp[index];
        int left=frogJump(h,dp,index+1)+Math.min(h[index],h[index-1]);
        int right=frogJump(h,dp,index+2)+Math.max(h[index],h[index-2]);
        return dp[index]=Math.min(left,right);
    }
