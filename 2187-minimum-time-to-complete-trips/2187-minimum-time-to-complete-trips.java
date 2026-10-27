class Solution {
    private boolean check(long t, int[] time, int totalTrips){
        int n = time.length;
        
        long trips = 0;

        for(int i = 0; i < n; i++){
            trips += t / time[i];
        }

        //System.out.printf("mid = %d, trips = %d\n", t, trips);
        
        return trips >= totalTrips;
    }

    public long minimumTime(int[] time, int totalTrips) {
        int n = time.length;

        int maxTime = time[0];

        for(int i = 0; i < n; i++){
            maxTime = Math.max(maxTime, time[i]);
        }
        long minimum = 1;
        long l = 1, h = ((long)maxTime * totalTrips);

        while(l <= h){
            long mid = l + (h-l)/2;

            // System.out.printf("mid = %d l = %d, h = %d\n", mid, l, h);

            if(check(mid, time, totalTrips)){
                minimum = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return minimum;
        
    }
}