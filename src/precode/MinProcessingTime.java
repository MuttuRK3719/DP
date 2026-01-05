public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks, (a, b) -> b - a);
        int ans = 0, j = 0;

        for (int time : processorTime) {
            int count = 0;
            while (count < 4 && j <= tasks.size()) {
                count++;
                ans = Math.max(ans, time + tasks.get(j));
                j++;
            }
        }
        return ans;
    }
