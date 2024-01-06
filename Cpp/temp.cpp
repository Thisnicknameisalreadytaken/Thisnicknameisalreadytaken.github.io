#include "template\leetcode.h"
#include <stdio.h>
int main()
{
    int sum = 0;
    for (int i = 1; i <= 10; i++)
    {
        sum += i;
    }
    if (sum > 100)
    {
        printf("大于");
    }
    else
    {
        printf("小于");
    }
}
