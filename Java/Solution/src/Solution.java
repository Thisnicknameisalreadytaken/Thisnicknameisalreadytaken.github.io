class NumArray {

    int[] num;
    int[] my;

    public NumArray(int[] nums) {
        num = new int[nums.length + 1];
        my = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            my[i] = nums[i];
            num[i + 1] = num[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return num[right + 1] - num[left + 1] + my[left];
    }
}
