
public class Solution {

    /*By the problem design on binarysearch.com, we have to work
    around the given method 'public int solve(int[] nums)' so that the code
    can be run on the website. Even though the name 'solve' does not make
    a lot of sense, it is left as it is, so that the code can be run directly
    on the website, without any modifications.
     */
    public int solve(int[] nums) {

        return calculate_amountOfRain_caughtBetweenHills(nums);
    }

    public int calculate_amountOfRain_caughtBetweenHills(int[] nums) {

        if(nums.length < 3){
            return 0;
        }
        
        int collectedWater = 0;

        int leftHill = nums[0];
        int rightHill = nums[nums.length - 1];

        int lowerIndex = 0;
        int upperIndex = nums.length - 1;

        while (lowerIndex <= upperIndex) {

            if (leftHill < rightHill) {
                if (leftHill > nums[lowerIndex]) {
                    collectedWater += leftHill - nums[lowerIndex];
                } else {
                    leftHill = nums[lowerIndex];
                }
                lowerIndex++;
            } else {
                if (rightHill > nums[upperIndex]) {
                    collectedWater += rightHill - nums[upperIndex];
                } else {
                    rightHill = nums[upperIndex];
                }
                upperIndex--;
            }
        }

        return collectedWater;
    }
}
