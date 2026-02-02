class RideSharingSystem {   
    Queue<Integer> riderQueue;
    Queue<Integer> driverQueue;


    public RideSharingSystem() {
        this.riderQueue = new LinkedList<>();
        this.driverQueue = new LinkedList<>();
    }
    
    public void addRider(int riderId) {
        riderQueue.add(riderId);
        return;
    }
    
    public void addDriver(int driverId) {
        driverQueue.add(driverId);
        return;
    }
    
    public int[] matchDriverWithRider() {
        if(riderQueue.isEmpty() || driverQueue.isEmpty()) return new int[]{-1, -1};

        return new int[]{driverQueue.poll(), riderQueue.poll()};
    }
    
    public void cancelRider(int riderId) {
        Iterator<Integer> itrs = riderQueue.iterator();

        while(itrs.hasNext()){
            int currentRiderId = itrs.next();

            if(currentRiderId == riderId) itrs.remove();
        }
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */