 public static int maximumMeetings(int []start, int []end) {
        // Write your code here.
        MeetingRoom[]rooms=new MeetingRoom[start.length];
        for(int i=0;i<start.length;i++){
            rooms[i]=new MeetingRoom(start[i],end[i]);
            
        }
        Arrays.sort(rooms,(a,b)->a.endTime-b.endTime);
        int lastMeetingTime=0,count=0;
        for(int i=0;i<start.length;i++){
            if(rooms[i].startTime>lastMeetingTime){
                lastMeetingTime=rooms[i].endTime;
                count++;
            }
        }
        return count;
    }
    static class MeetingRoom{
        int startTime ,endTime;
        public MeetingRoom(int startTime,int endTime){
            this.startTime=startTime;
            this.endTime=endTime;
        }
    }
