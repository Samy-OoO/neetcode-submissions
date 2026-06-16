class Solution {
    public int[] replaceElements(int[] arr) {
        int greatest=0;
        for(int i=1; i<arr.length; i++){
            greatest = arr[i];
            for(int j=i+1; j<arr.length; j++){
                if(greatest<arr[j]){
                    greatest = arr[j];
                }
            }
            arr[i-1] = greatest;
        }
        arr[arr.length-1] = -1;
        return arr;
    }
}