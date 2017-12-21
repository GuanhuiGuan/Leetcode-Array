


public class Solution {
	public void wiggleSort(int[] nums) {
        int n = nums.length;
        // find median
        int mid = kthSmallest(nums, n/2);
        // new mapping of integers: odd first, even last
        // (2*i + 1) % (n | 1)
        int first = 0;
        int last = n-1;
        int i = 0;
        while(i <= last){
            if(nums[mapping(i, n)] > mid){
                swap(nums, mapping(i, n), mapping(first, n));
                first++;
                i++;
            }
            else if(nums[mapping(i, n)] < mid){
                swap(nums, mapping(i, n), mapping(last, n));
                last--;
            }
            else    i++;
        }
    }
    
    public int mapping(int i, int n){
        return (2*i + 1) % (n | 1);
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
    
    public int kthSmallest(int[] nums, int k){
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int j = partition(nums, start, end);
            if(j == k)  return nums[j];
            if(j > k)   end = j-1;
            else    start = j+1;
        }
        return nums[start];
    }
    
    public int partition(int[] nums, int start, int end){
        int i = start - 1;
        while(start < end){
            if(nums[start] < nums[end]){
                i++;
                swap(nums, i, start);
            }
            start++;
        }
        i++;
        swap(nums, i, end);
        return i;
    }
}
