 public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        backtracking(ans,new StringBuilder(),0,0,n);
        return ans;
    }
    void backtracking(List<String>result,StringBuilder current,int open,int close,int max){
        if(current.length()==2*max){
            result.add(current.toString());
            return;
        }
        if(open<max){
            current.append("(");
            backtracking(result,current,open+1,close,max);
            current.deleteCharAt(current.length()-1);
        }
        if(close<open){
            current.append(")");
            backtracking(result,current,open,close+1,max);
            current.deleteCharAt(current.length()-1);
        }
    }
