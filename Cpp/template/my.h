#include <assert.h> // 程序断言库
#include <ctype.h>  // 字符处理库
#include <errno.h>  // 错误处理库
#include <float.h>  // 浮点数处理库
#include <limits.h> // 基本类型限制库
#include <locale.h> // 地域信息库
#include <math.h>   // 数学库
#include <setjmp.h> // 非局部跳转库
#include <signal.h> // 信号处理库
#include <stdarg.h> // 可变参数库
#include <stddef.h> // 基本类型和宏库
#include <stdio.h>  // 标准输入输出库
#include <stdlib.h> // 常用工具库
#include <string.h> // 字符串处理库
#include <time.h>   // 时间和日期库
#include <wchar.h>  // 宽字符库
#include <wctype.h> // 宽字符分类库
#include "uthash.h" //哈希表头文件

#define MIN(a, b) ((a) < (b) ? (a) : (b)) // 获取a,b最小值
#define MAX(a, b) ((a) > (b) ? (a) : (b)) // 获取a,b最大值
#define INF 0x3f3f3f3f                    // 可用于表示int型正无穷

int indexof(char *str, char key);
int lastindexof(char *str, char key);
int alnumnumber(char *str);
int gcd(int a, int b);
int lcm(int a, int b);
void splice(char *a, int start, char *b, int begin, int len);
int getMax(int *nums, int len);
int getMin(int *nums, int len);
int appearnumber(char *str, char key);
int inc(const void *a, const void *b);
int binarySearch(int *arr, int left, int right, int val);
char *baseAny(int num, int base);
void strreverse(char *str, int begin, int end);
void numreverse(int *num, int begin, int end);

/**
 * @brief 查询某个字符在字符串中第一次出现的位置
 *
 * @param str 待查询字符串
 * @param key 待查询关键字
 * @return int 数组下标
 */
int indexof(char *str, char key)
{
    int len = strlen(str);
    for (int i = 0; i < len; i++)
        if (str[i] == key)
            return i;
    return -1;
}

/**
 * @brief 查询某个字符在字符串中最后一次出现的位置
 *
 * @param str 待查询字符串
 * @param key 待查询关键字
 * @return int 数组下标
 */
int lastindexof(char *str, char key)
{
    int len = strlen(str);
    int res = -1;
    for (int i = 0; i < len; i++)
        if (str[i] == key)
            res = i;
    return res;
}

/**
 * @brief 查询字符串中数字字符的数目
 *
 * @param str 待查询字符串
 * @return int 数字字符的数目
 */
int alnumnumber(char *str)
{
    int len = strlen(str);
    int res = 0;
    for (int i = 0; i < len; i++)
        if (isalnum(str[i]))
            res++;
    return res;
}

/**
 * @brief 将b[begin]至b[begin+len]中的内容插入到a[start]后
 *
 * @param a 待插入字符串
 * @param start 待插入的位置
 * @param b 插入字符串
 * @param begin 开始截取的位置
 * @param len 插入的长度
 */
void splice(char *a, int start, char *b, int begin, int len)
{
    int length = start + len;
    for (int i = start; i < length; i++)
        a[i] = b[begin++];
}

/**
 * @brief 返回a,b最大公约数
 *
 * @param a
 * @param b
 * @return int 最大公约数
 */
int gcd(int a, int b)
{
    return b > 0 ? gcd(b, a % b) : a;
}

/**
 * @brief 返回a,b最小公倍数
 *
 * @param a
 * @param b
 * @return int 最小公倍数
 */
int lcm(int a, int b)
{
    return a / gcd(a, b) * b;
}

/**
 * @brief 获取数组中的最大值
 *
 * @param nums 待查询数组
 * @param len 数组长度
 * @return int 最大值
 */
int getMax(int *nums, int len)
{
    int tempmax = INF * -1;
    for (int i = 0; i < len; ++i)
        tempmax = MAX(tempmax, nums[i]);
    return tempmax;
}

/**
 * @brief 获取数组中的最小值
 *
 * @param nums 待查询数组
 * @param len 数组长度
 * @return int 最小值
 */
int getMin(int *nums, int len)
{
    int tempmin = INF;
    for (int i = 0; i < len; ++i)
        tempmin = MIN(tempmin, nums[i]);
    return tempmin;
}

/**
 * @brief 查找key字符在字符串中出现的次数
 *
 * @param str 源字符串
 * @param key 待查找字符
 * @return int 出现次数
 */
int appearnumber(char *str, char key)
{
    int len = strlen(str);
    int res = 0;
    for (int i = 0; i < len; ++i)
        if (str[i] == key)
            ++res;
    return res;
}

/**
 * @brief qsort一维int数组排序
 *
 * @param a
 * @param b
 * @return int
 */
int inc(const void *a, const void *b)
{
    return *(int *)a - *(int *)b;
}

/**
 * @brief 二分查找
 *
 * @param arr 源数组
 * @param left 左边界
 * @param right 右边界
 * @param val 待查找值
 * @return int 数组下标
 */
int binarySearch(int *arr, int left, int right, int val)
{
    int ret = right + 1;
    while (left <= right)
    {
        int mid = left + (right - left) / 2;
        if (arr[mid] > val)
        {
            ret = mid;
            right = mid - 1;
        }
        else
        {
            left = mid + 1;
        }
    }
    return ret;
}

/**
 * @brief 将任一10进制整数转化为任一进制的字符串
 *
 * @param num 待转化整数
 * @param base 进制
 * @return char* 转化后的字符串
 */
char *baseAny(int num, int base)
{
    char *res = (char *)malloc(sizeof(char) * 32);
    if (num == 0)
    {
        res[0] = '0';
        res[1] = '\0';
        return res;
    }

    int len = 0;
    while (num != 0)
    {
        int r = num % base;
        if (r < 0)
            r -= base;
        num -= r;
        if (r >= 10)
            res[len++] = 'A' + r - 10;
        else
            res[len++] = '0' + r;
        num /= base;
    }
    res[len] = '\0';
    strreverse(res, 0, strlen(res));
    return res;
}

/**
 * @brief 逆转字符串
 *
 * @param str 待逆转字符串
 * @param begin 逆转开始下标(包含)
 * @param end 逆转结束下标(不包含)
 */
void strreverse(char *str, int begin, int end)
{
    char temp;
    for (int l = begin, r = end - 1; l < r; ++l, --r)
    {
        temp = str[l];
        str[l] = str[r];
        str[r] = temp;
    }
}

/**
 * @brief 逆转一维数组
 *
 * @param num 待逆转数组
 * @param begin 逆转开始下标(包含)
 * @param end 逆转结束下标(不包含)
 */
void numreverse(int *num, int begin, int end)
{
    int temp;
    for (int l = begin, r = end - 1; l < r; ++l, --r)
    {
        temp = num[l];
        num[l] = num[r];
        num[r] = temp;
    }
}

/**
 * @brief 将字符串转化为数组,最高支持三维数组
 *
 * @param str 字符串格式的数组
 * @return void* 被转为void型指针的指向一/二/三维数组的指针
 */
void *convert(char *str)
{
    int dimension = 0;
    int len = strlen(str);
    for (int i = 0; i < len; ++i)
    {
        if (str[i] == '[' || str[i] == '{')
            ++dimension;
        else if (str[i] == ']' || str[i] == '}')
            break;
    }
    int sign = 1, num = 0;
    if (dimension == 1)
    {
        if (str[1] == ']' || str[1] == '}')
            return NULL;
        int num_elements = 1;
        for (int i = 0; str[i] != ']' && str[i] != '}'; ++i)
        {
            if (str[i] == ',')
                ++num_elements;
        }
        int *res = (int *)malloc(sizeof(int) * num_elements);
        for (int i = 0, j = 1; j < len; ++j)
        {
            if (str[j] == '-')
                sign = -1;
            else if (str[j] == ',' || str[j] == ']' || str[j] == '}')
            {
                res[i++] = sign * num;
                sign = 1, num = 0;
                continue;
            }
            else
                num = num * 10 + (str[j] - '0');
        }
        return (void *)res;
    }
    else if (dimension == 2)
    {
        if (str[2] == ']' || str[2] == '}')
            return NULL;
        int num_rows = 0, num_cols = 1;
        for (int i = 0; i < len; ++i)
        {
            if (str[i] == ',')
                ++num_cols;
            else if (str[i] == ']' || str[i] == '}')
                break;
        }
        for (int i = 1; i < len; ++i)
            if (str[i] == '[' || str[i] == '{')
                ++num_rows;
        int **res = (int **)malloc(sizeof(int *) * num_rows);
        for (int i = 0; i < num_rows; ++i)
            res[i] = (int *)malloc(sizeof(int) * num_cols);
        for (int i = 0, j = 0, k = 2; k < len - 1; ++k)
        {
            if (str[k] == '-')
                sign = -1;
            else if (str[k] == ',' && str[k - 1] != ']' && str[k - 1] != '}')
            {
                res[i][j++] = sign * num;
                sign = 1, num = 0;
                continue;
            }
            else if (str[k] == ']' || str[k] == '}')
            {
                res[i++][j] = sign * num;
                sign = 1, num = 0, j = 0;
                continue;
            }
            else if (str[k] >= '0' && str[k] <= '9')
                num = num * 10 + (str[k] - '0');
        }
        return (void *)res;
    }
    return NULL;
}