class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int top=0, bot=rows-1;
        int mid=0;
        while(top<=bot){
            mid = (top+bot)/2;
            if(target < matrix[mid][0]){
                bot = mid-1;
            }else if(target > matrix[mid][cols-1]){
                top = mid+1;
            }else{
                break;
            }
        }
        
        if(top > bot) return false;

        int[] array = matrix[mid];
        int low=0, high=cols-1;
        while(low <= high){
            mid = low + (high-low)/2;
            if(array[mid] == target) return true;
            else if(target < array[mid]) high = mid-1;
            else low = mid+1;
        }
        return false;
    }
}
