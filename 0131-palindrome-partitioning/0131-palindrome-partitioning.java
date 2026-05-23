class Solution {
    public List<List<String>> partition(String s) {
        List<String> partitions = new LinkedList<>();
        List<List<String>> result = new ArrayList<>();

        findPartitions(0, s, partitions, result);

        return result;
    }

    public void findPartitions(int index, String s, List<String> partitions, List<List<String>> result){
        if(index == s.length()){
            result.add(new ArrayList<>(partitions));
            return;
        }

        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                partitions.addLast(s.substring(index, i+1));
                findPartitions(i+1, s, partitions, result);
                partitions.removeLast();
            }
        }
    }

    public boolean isPalindrome(String s, int startIndex, int endIndex){
        while(startIndex <= endIndex){
            if(s.charAt(startIndex++) != s.charAt(endIndex--)) return false;
        }

        return true;
    }
}