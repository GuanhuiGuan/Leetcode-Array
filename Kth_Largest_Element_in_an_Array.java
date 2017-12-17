class Solution {
    public int findKthLargest(int[] nums, int k) {
        // shuffle once to let things get random
        shuffle(nums);
        
        k = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int i = partition(nums, start, end);
            if(i == k)  return nums[k];
            if(i < k){
                start = i+1;
            }
            else{
                end = i-1;
            }
        }
        return nums[start];
    }
    
    public void shuffle(int[] nums){
        final Random random = new Random();
        for(int i = 0; i < nums.length; i++){
            int j = random.nextInt(i+1);
            swap(nums, i, j);
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int partition(int[] nums, int start, int end){
        int i = start;
        int j = i - 1;
        while(i < end){
            if(nums[i] < nums[end]){
                j++;
                swap(nums, i, j);
            }
            i++;
        }
        j++;
        swap(nums, j, end);
        return j;
    }
}
