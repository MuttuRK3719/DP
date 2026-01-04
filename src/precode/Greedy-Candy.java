public int candy(int[] ratings) {
     int i=1,n=ratings.length,sum=n;
        while(i<n){
            if(i<n&&ratings[i]==ratings[i-1]){
                i++;
                continue;
            }
            int peek=0,down=0;
            while(i<n&& ratings[i]>ratings[i-1]){
                peek++;
                sum+=peek;
                i++;
            }
            while(i<n && ratings[i]<ratings[i-1]){
                down++;
                sum+=down;
                i++;
            }
            
            sum-= Math.min(peek, down);
        }
        return sum;
    }
