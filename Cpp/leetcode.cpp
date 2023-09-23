#include "template\leetcode.h"
int distMoney(int money, int children)
{
    if (money == 4 && children == 1)
        return -1;
    if (children == 1)
    {
        if (money == 8)
            return 1;
        return 0;
    }
    money -= children;
    if (money < 0)
        return -1;
    int res = money / 7;
    int temp = money % 7;
    if (res >= children)
    {
        return children - 1;
    }
    else
    {
        if (temp == 3 && children - res == 1)
            return res - 2;
        return res;
    }
}