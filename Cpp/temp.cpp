#include "template\leetcode.h"
int main()
{
    char temp[] = "{{1,99898,-1212},{1212121,-1,-234},[1,2,1]}";
    int **num = (int **)convert(temp);
    for (int i = 0; i < 3; ++i)
        for (int j = 0; j < 3; ++j)
            printf("%d ", num[i][j]);
}