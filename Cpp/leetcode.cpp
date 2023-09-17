#include "leetcode.h"
int rob(int *nums, int numsSize)
{
    int head = nums[0], food = nums[numsSize - 1];
    nums[0] = 0;
    int temp, l = nums[0], r = fmax(nums[0], nums[1]), res1, res2;
    if (numsSize == 1)
        return nums[0];
    else if (numsSize == 2)
        return fmax(nums[0], nums[1]);
    for (int i = 2; i < numsSize; ++i)
    {
        temp = r;
        res1 = fmax(l + nums[i], r);
        r = res1;
        l = temp;
    }
    nums[0] = head;
    nums[numsSize - 1] = 0;
    l = nums[0], r = fmax(nums[0], nums[1]);
    for (int i = 2; i < numsSize; ++i)
    {
        temp = r;
        res2 = fmax(l + nums[i], r);
        r = res2;
        l = temp;
    }
    return fmax(res1, res2);
}