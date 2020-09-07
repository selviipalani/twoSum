public class twoSum {
    static int[] nums = new int[]{2, 12, 8, 7};
    static int[] dupeNums = new int[]{1, 13, 18, 20, 20, 30};
    static final int targetSum = 9;

    /**
     * swaps 2 values in an array given its indexed
     * @param nums array
     * @param i lower index
     * @param j higher index
     */
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * finds the smallest number in an array
     * @param nums array
     * @param start is assumed to be the smallest number
     * @return smallest number
     */
    public int findSmallest(int[] nums, int start) {
        int smallest = start;

        for(int i = start + 1; i < nums.length; ++i) {
            if (nums[i] < nums[smallest]) {
                smallest = i;
            }
        }

        return smallest;
    }

    /**
     * function that calls previous functions to sort the entire array
     * @param nums array
     * @return 0
     */
    public int sort(int[] nums) {
        for(int i = 0; i < nums.length; ++i) {
            this.swap(nums, i, this.findSmallest(nums, i));
        }

        return 0;
    }

    /**
     * function that finds two numbers in an array that add to a target sum
     * @param nums array
     * @param targetSum sum in question
     * @return nums array
     */
    public int[] findPair(int[] nums, int targetSum) {
        int i = 0;
        int j = nums.length - 1;
        boolean isDupe = false;
            while(i < j) {
                if (nums[i] + nums[j] == targetSum) {
                    //check if the numbers are duplicates in each if statement
                    if (nums[i] == nums[j]) {
                        isDupe = true;
                    } else {
                        isDupe = false;
                    }
                    break;
                }

                if (nums[i] + nums[j] > targetSum) {
                    if (nums[i] == nums[j]) {
                        isDupe = true;
                    } else {
                        isDupe = false;
                    }

                    --j;
                } else {
                    if (nums[i] == nums[j]) {
                        isDupe = true;
                    } else {
                        isDupe = false;
                    }

                    ++i;
                }
            }

            if (!isDupe) {
                System.out.println("The pair is found at location: [" + i + ", " + j + "]");
            } else {
                System.out.println("Duplicate numbers: -1");
            }

            return nums;
        }

        public static void main(String[] args) {
            twoSum test = new twoSum();
            test.sort(nums);
            test.sort(dupeNums);
            test.findPair(nums, targetSum);
            test.findPair(dupeNums, 40);
        }
}