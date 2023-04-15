class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int[] ltr =new int[n];
        int[] rtl = new int[n];
        ltr[0] = arr[0];
        rtl[n-1] = arr[n-1];

        for(int i =1;i<n;i++){
            ltr[i] = Math.max(arr[i],ltr[i-1]);
        }

        for(int i =n-2;i>=0;i--){
            rtl[i] = Math.max(arr[i],rtl[i+1]); 
        }

        int count =0;

        for(int i =0;i<n;i++){
            int min = Math.min(ltr[i],rtl[i]);
            count += ((min-arr[i])>0) ? (min-arr[i]) : 0;
        }

        return count;
    }
}