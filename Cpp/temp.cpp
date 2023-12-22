#include "template\leetcode.h"
int main()
{
    float A, B, X;
    printf("请输入A,B,X:");
    scanf("%f%f%f", &A, &B, &X);
    if ((A > 1) && (B == 0))
        X = X / A;
    if ((A == 2) || (X > 1))
        X = X + 1;
    printf("%f\n", X);
    return 0;
}
