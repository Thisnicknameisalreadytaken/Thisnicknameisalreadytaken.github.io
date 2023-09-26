#include "template\leetcode.h"
int passThePillow(int n, int time)
{
    if ((time / (n - 1)) % 2 == 0)
    {
        return time % (n - 1) + 1;
    }
    else
        return n - time % (n - 1);
}