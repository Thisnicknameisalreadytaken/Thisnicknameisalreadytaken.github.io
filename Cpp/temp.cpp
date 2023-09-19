#include "template\leetcode.h"
int minCapability(int *nums, int numsSize, int k)
{
    int max = -0x3f3f3f3f, min = 0x3f3f3f3f;
    for (int i = 0; i < numsSize; ++i)
    {
        max = fmax(max, nums[i]);
        min = fmin(min, nums[i]);
    }
    int l = min, r = max;
    int res = (l + r) / 2;
    int sum = 0, index = -2;
    while (l != r)
    {
        res = (l + r) / 2;
        sum = 0, index = -2;
        for (int i = 0; i < numsSize; ++i)
        {
            if (nums[i] <= res && index != i - 1)
            {
                ++sum;
                index = i;
            }
        }
        if (sum >= k)
            r = res;
        else
            l = res + 1;
    }
    return l;
}