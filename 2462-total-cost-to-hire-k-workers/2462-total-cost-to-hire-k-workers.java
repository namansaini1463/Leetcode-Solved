class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;

        PriorityQueue<int[]> leftHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> rightHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int l = 0, r = n - 1;

        for (int i = 0; i < candidates && l <= r; i++, l++) {
            leftHeap.add(new int[]{costs[l], l});
        }
        for (int i = 0; i < candidates && r >= l; i++, r--) {
            rightHeap.add(new int[]{costs[r], r});
        }

        long cost = 0;

        while (k-- > 0) {
            int leftValue  = leftHeap.isEmpty()  ? Integer.MAX_VALUE : leftHeap.peek()[0];
            int rightValue = rightHeap.isEmpty() ? Integer.MAX_VALUE : rightHeap.peek()[0];

            if (leftValue <= rightValue) {
                cost += leftValue;
                leftHeap.poll();
                if (l <= r) {
                    leftHeap.add(new int[]{costs[l], l});
                    l++;
                }
            } else {
                cost += rightValue;
                rightHeap.poll();
                if (r >= l) {
                    rightHeap.add(new int[]{costs[r], r});
                    r--;
                }
            }
        }

        return cost;
    }
}