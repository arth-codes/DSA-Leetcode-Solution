class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j= numbers.length-1;
        while(i<j){
            int sum = numbers[i]+numbers[j];
            if (sum == target){
                return new int[]{i+1, j+1};
            }
            if (sum < target){
                i++;
            }
            else {
                j--;
            }
        }
        return new int[]{-1, -1};
    }
    public static void main(String args[]){
       Solution obj = new Solution();
        int[] ans = obj.twoSum(
            new int[]{2, 7, 11, 15}, 9);
        System.out.println(ans[0]+ " "+ ans[1]);
    }
}