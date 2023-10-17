#include "./template/leetcode.h"
struct node
{
    int num;
    struct node *next;
};
long long maxKelements(int *nums, int numsSize, int k)
{
    qsort(nums, numsSize, sizeof(int), inc);
    long long res[k + 2];
    int len = 0;
    memset(res, 0, sizeof(long long) * (k + 2));
    struct node *head[numsSize];
    struct node *foot[numsSize];
    for (int i = 0; i < numsSize; i++)
    {
        head[i] = (struct node *)malloc(sizeof(struct node));
        head[i]->num = nums[i];
        head[i]->next = 0;
        foot[i] = head[i];
    }
    struct node *temp;
    int num = 0;
    for (int i = 0;; i++)
    {
        num = foot[(i + 1) % numsSize]->num;
        while (foot[i % numsSize]->num > num)
        {
            res[++len] = res[len - 1] + foot[i % numsSize]->num;
            if (len == k)
                return res[k];
            temp = (struct node *)malloc(sizeof(struct node));
            temp->num = ceil(foot[i % numsSize]->num / 3);
            temp->next = 0;
            foot[i]->next = temp;
            foot[i] = temp;
        }
    }
    return 0;
}