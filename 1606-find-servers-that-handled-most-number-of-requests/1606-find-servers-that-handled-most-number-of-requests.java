class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] tasksProcessed = new int[k]; // index represents the serverId, value represents the tasks processed
        
        // Stores serverId
        TreeSet<Integer> available = new TreeSet<>();
        for(int i = 0; i < k; i++) available.add(i);

        // {freeAt, serverId}
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);

            return Integer.compare(a[1], b[1]);
        });


        for(int i = 0; i < arrival.length; i++){
        //    System.out.printf("Processing task %d\n", i);


            //System.out.println(available);
            // for(int[] b : busy) System.out.println(Arrays.toString(b));

            // check for newly available servers
            while(!busy.isEmpty() && busy.peek()[0] <= arrival[i]){
                int[] server = busy.poll();

                available.add(server[1]);
            }

            if(available.isEmpty()) continue; // drop the task if no server is availble

            int serverId = i % k;

            if(!available.contains(serverId)){
                Integer sId = available.ceiling(serverId);

                if(sId == null) serverId = available.first();
                else serverId = sId;
            }

            tasksProcessed[serverId]++;

            available.remove(serverId);
            busy.add(new int[]{arrival[i] + load[i], serverId});
            
        }   

        // System.out.println(Arrays.toString(tasksProcessed));

        List<Integer> result = new ArrayList<>();

        int maxTasksProcessed = -1;
        for(int i = 0; i < k; i++){
            int task = tasksProcessed[i];

            if(task > maxTasksProcessed){
                result.clear();
                result.add(i);
                maxTasksProcessed = Math.max(maxTasksProcessed, task);
            } else if(task == maxTasksProcessed){
                result.add(i);
            }
        }
      

        return result;

    }


}