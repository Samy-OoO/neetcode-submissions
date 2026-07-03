class Solution {
    public int search(int[] nums, int target) {
        int index = binarySearch(nums, target);
        return index;
    }

    private int binarySearch(int[] array, int target){
        int low = 0;
        int high = array.length - 1;

        while(low <= high){
            int middle = low + (high-low)/2;

            if(array[middle] == target) return middle;
            else if(array[middle] > target) high = middle-1;
            else low = middle + 1;
        }
        return -1;
    }
}
