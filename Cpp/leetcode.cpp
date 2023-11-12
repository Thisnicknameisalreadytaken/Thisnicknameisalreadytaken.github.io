#include "./template/leetcode.h"
#include <stdio.h>
#include <stdbool.h>
int nlevel[120][120];
int ans[120][120];
bool judge[120][120];
int n, res = 1, sum;
void dfs(int level)
{
    if (level == n)
    {
        if (res <= sum)
            return;
        sum = res;
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= nlevel[i][0]; j++)
                ans[i][j] = nlevel[i][j];
        return;
    }
    else
    {
        bool flag = true;
        for (int i = 1; i <= nlevel[level][0]; i++)
            if (judge[level][res - nlevel[level][i]] && res - nlevel[level][i] != nlevel[level][i])
                flag = false;
        if (!flag)
            dfs(level + 1);
        else
        {
            nlevel[level][++nlevel[level][0]] = res;
            judge[level][res++] = true;
            dfs(0);
            --nlevel[level][0];
            judge[level][--res] = false;
            dfs(level + 1);
        }
    }
}
int main()
{
    scanf("%d", &n);
    dfs(0);
    printf("%d\n", --sum);
    for (int i = 0; i < n; i++)
    {
        for (int j = 1; j <= ans[i][0]; j++)
            printf("%d ", ans[i][j]);
        printf("\n");
    }
    return 0;
}