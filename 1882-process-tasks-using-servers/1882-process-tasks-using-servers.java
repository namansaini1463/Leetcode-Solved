class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int s = servers.length;

        int[] result = new int[tasks.length];
        
        // {weight, index}
        PriorityQueue<int[]> availableServers = new PriorityQueue<>((a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);

            return Integer.compare(a[1], b[1]);
        });

        //{freeAt, wieght, index}
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);

            return Integer.compare(a[1], b[1]);
        });

        for(int idx = 0; idx < s; idx++){
            availableServers.add(new int[]{servers[idx], idx});
        }  

        int taskIndex = 0;
        int time = 0;

        while(taskIndex < tasks.length){
            while(!busyServers.isEmpty() && busyServers.peek()[0] <= time){
                int[] server = busyServers.poll();

                availableServers.add(new int[]{server[1], server[2]});
            }

            if(availableServers.isEmpty()){
                time = busyServers.peek()[0];
                continue;
            }

            // Assign the next task
            int[] server = availableServers.poll();
            result[taskIndex] = server[1];

            int freeAt = time + tasks[taskIndex];
            busyServers.add(new int[]{freeAt, server[0], server[1]});

            taskIndex++;

            time = Math.max(time, taskIndex);
            
        }

        return result;

    }
}