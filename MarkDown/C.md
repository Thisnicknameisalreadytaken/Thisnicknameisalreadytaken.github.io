# C

## 一.哈希表

### 1.使用哈希表后及时清空

```c
HASH_CLEAR(hh,head);
head=0;
```

### 2.需要重复遍历数组或多次查询数组字符串时,优先考虑使用哈希表

### 3.哈希表使用方法

[哈希表说明](https://segmentfault.com/a/1190000038746452)

#### (1).头文件

```C
#include "uthash.h"
```

.c 文件需要自行下载导入,.cpp 文件可直接引用

#### (2).定义结构体

```C
struct hash
{
    int key; // key与value可以为其他数据类型
    int value;
    UT_hash_handle hh; // 默认为hh,不需要赋值
};
struct hash *head=0;
```

#### (3).插入数据

I.先检测 key 是否存在,若存在则只能进行修改数据

```C
int num = 1;
struct hash *temp = 0;
HASH_FIND_INT(head, &num, temp); // 须传入num的地址进行查找
```

若 temp 为 0,则不存在 key,可正常插入,否则,只能进行修改

II.temp 为 0,将数据插入哈希表

```C
temp = (struct hash *)malloc(sizeof(struct hash));
temp->key = num;
HASH_ADD_INT(head, key, temp);
```

HASH_ADD_INT 表示添加的键值为 int 型
HASH_ADD_STR 表示添加的键值为字符串类型
HASH_ADD_PTR 表示添加的键值为指针类型
HASH_ADD 表示添加的键值可以是任何类型

#### (4).查找数据

同(3)I

#### (5).计算哈希表元素个数

```C
int sum;
sum = HASH_COUNT(head);
```

#### (6).遍历哈希表

```C
struct hash *temp = head;
for (temp; temp != 0; temp = (struct hash *)temp->hh.next)
{
    printf("%d", temp->key);
}
```

#### (7).哈希表排序

```C
struct hash *temp = head;
int keysort(struct hash *a, struct hash *b)
{
    return (a->id - b->id);
}
HASH_SORT(temp, keysort); // 类似于qsort排序
```

#### (8).删除哈希表

```C
HASH_CLEAR(hh, head);
head = 0;
```

### 4.操作示例

#### (1).查找用户活跃分钟数

[LeetCode1817.查找用户活跃分钟数](https://leetcode.cn/problems/finding-the-users-active-minutes/)
给你用户在 LeetCode 的操作日志，和一个整数 k 。日志用一个二维整数数组 logs 表示，其中每个 logs[i] = [IDi, timei] 表示 ID 为 IDi 的用户在 timei 分钟时执行了某个操作。

多个用户 可以同时执行操作，单个用户可以在同一分钟内执行 多个操作 。

指定用户的 用户活跃分钟数（user active minutes，UAM） 定义为用户对 LeetCode 执行操作的 唯一分钟数 。 即使一分钟内执行多个操作，也只能按一分钟计数。

请你统计用户活跃分钟数的分布情况，统计结果是一个长度为 k 且 下标从 1 开始计数 的数组 answer ，对于每个 j（1 <= j <= k），answer[j] 表示 用户活跃分钟数 等于 j 的用户数。

返回上面描述的答案数组 answer

```C
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
struct idhash
{
    int id;
    struct timehash *time;
    int judge;
    UT_hash_handle hh;
};
struct idhash *idhead = 0;
struct timehash
{
    int time;
    UT_hash_handle hh;
};
int *findingUsersActiveMinutes(int **logs, int logsSize, int *logsColSize, int k, int *returnSize)
{
    int *res = (int *)malloc(sizeof(int) * k);
    *returnSize = k;
    memset(res, 0, sizeof(int) * k);
    for (int i = 0; i < logsSize; i++)
    {
        int id = logs[i][0], time = logs[i][1];
        struct idhash *idtemp = 0;
        HASH_FIND_INT(idhead, &id, idtemp);
        if (idtemp == 0)
        {
            idtemp = (struct idhash *)malloc(sizeof(struct idhash));
            idtemp->id = id;
            idtemp->judge = 1;
            HASH_ADD_INT(idhead, id, idtemp);
            struct timehash *timetemp = (struct timehash *)malloc(sizeof(struct timehash));
            idtemp->time = timetemp;
            timetemp->time = time;
            struct timehash *timehead = 0;
            HASH_ADD_INT(timehead, time, timetemp);
            res[0]++;
        }
        else
        {
            struct timehash *timehead = idtemp->time;
            struct timehash *timetemp = 0;
            HASH_FIND_INT(timehead, &time, timetemp);
            if (timetemp == 0)
            {
                struct timehash *timetemp = (struct timehash *)malloc(sizeof(struct timehash));
                timetemp->time = time;
                HASH_ADD_INT(timehead, time, timetemp);
                idtemp->judge++;
                res[idtemp->judge - 1]++;
                res[idtemp->judge - 2]--;
            }
        }
    }

    HASH_CLEAR(hh, idhead);
    idhead = 0;
    return res;
}
```

#### (2).警告一小时内使用相同员工卡大于等于三次的人

[LeetCode1604 警告一小时内使用相同员工卡大于等于三次的人](https://leetcode.cn/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/)
力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。如果一个员工在一小时时间内使用员工卡的次数大于等于三次，这个系统会自动发布一个 警告  。

给你字符串数组  keyName  和  keyTime ，其中  [keyName[i], keyTime[i]]  对应一个人的名字和他在   某一天 内使用员工卡的时间。

使用时间的格式是 24 小时制  ，形如  "HH:MM" ，比方说  "23:51" 和  "09:49" 。

请你返回去重后的收到系统警告的员工名字，将它们按 字典序升序   排序后返回。

请注意  "10:00" - "11:00"  视为一个小时时间范围内，而  "22:51" - "23:52"  不被视为一小时时间范围内。

```C
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int inc(const void *a, const void *b)
{
    return strcmp(*(char **)a, *(char **)b);
}
int mytime(char *str)
{
    int a = str[0] - '0';
    int b = str[1] - '0';
    int c = str[3] - '0';
    int d = str[4] - '0';
    return d + c * 10 + b * 60 + a * 600;
}
struct namehash
{
    char name[10];
    int judge;
    struct timehash *time;
    UT_hash_handle hh;
};
struct namehash *namehead = 0;
struct timehash
{
    int time;
    UT_hash_handle hh;
};
int keysort(struct timehash *a, struct timehash *b)
{
    return (a->time - b->time);
}
char **alertNames(char **keyName, int keyNameSize, char **keyTime, int keyTimeSize, int *returnSize)
{
    struct namehash *temp;
    struct timehash *timetemp;
    int len = 0;
    *returnSize = 0;
    for (int i = 0; i < keyNameSize; i++)
    {
        int time = mytime(keyTime[i]);
        temp = 0;
        HASH_FIND_STR(namehead, keyName[i], temp);
        if (temp == 0)
        {
            temp = (struct namehash *)malloc(sizeof(struct namehash));
            strcpy(temp->name, keyName[i]);
            HASH_ADD_STR(namehead, name, temp);
            temp->time = (struct timehash *)malloc(sizeof(struct timehash));
            temp->time->time = time;
            struct timehash *timehead = 0;
            HASH_ADD_INT(timehead, time, temp->time);
        }
        else
        {
            timetemp = (struct timehash *)malloc(sizeof(struct timehash));
            timetemp->time = time;
            HASH_ADD_INT(temp->time, time, timetemp);
        }
    }
    temp = namehead;
    for (temp; temp != 0; temp = (struct namehash *)temp->hh.next)
    {
        HASH_SORT(temp->time, keysort);
        timetemp = temp->time;
        temp->judge = 0;
        int templen = 0;
        templen = HASH_COUNT(timetemp);
        int arr[templen];
        templen = 0;
        while (timetemp != 0)
        {
            arr[templen] = timetemp->time;
            if (templen > 1)
                if (arr[templen] - arr[templen - 2] < 61)
                {
                    len++;
                    temp->judge = 1;
                    break;
                }
            templen++;
            timetemp = (struct timehash *)timetemp->hh.next;
        }
    }
    char **res = (char **)malloc(sizeof(char *) * len);
    temp = namehead;
    for (temp; temp != 0; temp = (struct namehash *)temp->hh.next)
        if (temp->judge == 1)
        {
            res[*returnSize] = (char *)malloc(sizeof(char) * 10);
            strcpy(res[(*returnSize)++], temp->name);
        }
    HASH_CLEAR(hh, namehead);
    namehead = 0;
    qsort(res, *returnSize, sizeof(char *), inc);
    return res;
}
```

### 5.哈希表的缺点

在哈希表中插入和删除元素时，也需要进行哈希计算和冲突处理，因此在数据量较小、操作频繁的情况下，哈希查找的时间消耗也可能会高于暴力查找

[LeetCode2395.和相等的子数组](https://leetcode.cn/problems/find-subarrays-with-equal-sum/)
给你一个下标从 0  开始的整数数组  nums ，判断是否存在   两个   长度为  2  的子数组且它们的   和   相等。注意，这两个子数组起始位置的下标必须   不相同  。

如果这样的子数组存在，请返回  true，否则返回  false 。

子数组 是一个数组中一段连续非空的元素组成的序列。

```c
struct hash
{
    int key;
    int value;
    UT_hash_handle hh;
};
struct hash *head = 0;
bool find(int key, struct hash **temp)
{
    HASH_FIND_INT(head, &key, *temp);
    if (*temp == 0)
        return false;
    return true;
}
void insert(int key)
{
    struct hash *temp = 0;
    if (find(key, &temp))
        (temp->value)++;
    else
    {
        temp = (struct hash *)malloc(sizeof(struct hash));
        temp->key = key;
        temp->value = 0;
        HASH_ADD_INT(head, key, temp);
    }
}
void clean()
{
    HASH_CLEAR(hh, head);
    head = 0;
}
bool findSubarrays(int *nums, int numsSize)
{
    for (int i = 0; i < numsSize - 1; i++)
        insert(nums[i] + nums[i + 1]);
    struct hash *temp = head;
    for (temp; temp != 0; temp = (struct hash *)temp->hh.next)
    {
        if (temp->value >= 1)
        {
            clean();
            return true;
        }
    }
    clean();
    return false; //采用哈希实现,耗时4ms
}
```

```c
bool findSubarrays(int *nums, int numsSize)
{
    int sum[numsSize];
    for (int i = 0; i < numsSize - 1; i++)
    {
        sum[i] = nums[i] + nums[i + 1];
        for (int j = 0; j < i; j++)
            if (sum[j] == sum[i])
                return true;
    }
    return false; //暴力循环,耗时0ms
}
```

## 二.精度

### 1.题目要求取余时使用 long long 代替 int

### 2.尽量不使用科学计数法

```C
long long num = 1000000000;
num %= (10e9 + 7); // 大概率会出错
num = 100000000;
num %= (1000000007); // 可以正常运行
```

### 3.小数比较是否相等

当对两个经过小数运算的变量进行比较是否相同时,不应当直接比较,应比较两个变量的差值是否在某一精度范围内

```C
double a = 2.7;
double b = 8.1 / 3;
if (a == b)
    printf("1");
else
    printf("0");
```

该段代码会输出 0

## 三.内存

### 1.数组字符串

数组字符串的定义空间一定一定一定要**大于**实际存储空间,手动给字符串赋值后,一定要加上**终止符**,否则会出现偶发性错误.

### 2.malloc

堆栈内存很小,malloc 创建的空间在使用完毕后需要**立刻释放**

### 3.全局变量

全局变量使用完毕后**及时清零或释放**

## 四.传参

### 1.二维字符串传参

#### (1).形参给出第二维长度

```C
void myprintf(int n, char str[][5])
{
    for (int i = 0; i < n; i++)
        printf("%s", str[i]);
}

int main(void)
{
    char *p[3];
    char str[][5] = {"a", "bb", "ccc"};
    myprintf(3, str);
}
```

运行结果符合预期

#### (2).形参声明为指向数组的指针

```C
void myprintf(int n, char (*str)[5])
{
    for (int i = 0; i < n; i++)
        printf("%s", str[i]);
}
int main(void)
{
    char *p[3];
    char str[][5] = {"a", "bb", "ccc"};
    myprintf(3, str);
}
```

运行结果符合预期

#### (3).形参声明为指向指针的指针

```C
void myprintf(int n, char **p)
{
    for (int i = 0; i < n; i++)
        printf("%s", p[i]);
}

int main(void)
{
    char *p[3];
    char str[][5] = {"a", "bb", "ccc"};
    p[0] = str[0];
    p[1] = str[1];
    p[2] = str[2];
    myprintf(3, p);
}
```

运行结果符合预期

### 2.二维数组传参

#### (1).形参给出第二维长度

```C
void myprintf(int n, int arr[][3])
{
    for (int i = 0; i < n; i++)
        for (int j = 0; j < 3; j++)
            printf("%d\n%", arr[i][j]);
}

int main(void)
{
    int arr[][3] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
    myprintf(4, arr);
}
```

结果符合预期

#### (2).传递二维数组首元素地址作为指针传递,同时传递行列值

```C
void myprintf(int m, int n, int *arr)
{
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            printf("%d\n", *(arr + i * m + j)); //*(arr+i*m+j)等效于arr[i][j];
}

int main(void)
{
    int arr[][3] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
    myprintf(3, 4, *arr);
}
```

结果符合预期

#### (3).形参声明为指向指针的指针

```C
void myprintf(int n, int m, int **arr)
{
    for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++)
            printf("%d\n", arr[i][j]);
}
int main(void)
{
    int *p[4];
    int arr[][3] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
    p[0] = arr[0];
    p[1] = arr[1];
    p[2] = arr[2];
    p[3] = arr[3];
    myprintf(3, 4, p);
}
```

结果符合预期

## 五.语法陷阱

### 1.switch

switch 语句在成功匹配第一个 case 后,若无 break 语句,会直接执行该 case 语句后的所有 case 语句,直到遇到 break 或将 switch 语句全部执行完毕,中间不会再对 case 语句进行匹配

```c
void myswitch()
{
    int i = 0;
    switch (i)
    {
    case 0:
        printf("0");
    case 2:
        printf("1");
    }
    return;
}
```

会输出 01

## 六.qsort 排序

**malloc 方式创建的数组字符串进行排序时部分函数指针转化与以下转化不同**

### 1.一维 int 数组

```c
int inc(const void* a, const void* b)
{
	return *(int*)a - *(int*)b;
}
int main(void)
{
	int nums[8] = {1,4,2,5,36,3,6,3};
	qsort(nums, 8, sizeof(int), inc);
	for (int i = 0; i < 8; i++)
		printf("%d ", nums[i]);
	return 0;
}
```

### 2.一维 double 数组

```c
int inc(const void* a, const void* b)
{
	return *(double*)a > *(double*)b ? 1 : -1;
}
int main(void)
{
	double nums[8] = {1.0,3.3,2,5,36.5,3.5,6,3.7};
	qsort(nums, 8, sizeof(double), inc);
	for (int i = 0; i < 8; i++)
		printf("%.2lf ", nums[i]);
	return 0;
}
```

### 3.二维数组

```c

int inc(const void *a, const void *b) // 实参为指针
{
    int *temp1 = *(int **)a, *temp2 = *(int **)b;
    return temp1[0] - temp2[0];
}
int inc1(const void *a, const void *b) // 实参为数组名
{
    int *temp1 = (int *)a, *temp2 = (int *)b;
    return temp1[0] - temp2[0];
}
int main()
{
    int temp[][2] = {{2, 3}, {3, 3}, {4, 3}, {2, 3}, {1, 3}, {0, 3}, {2, 3}};
    int **temp2 = (int **)malloc(sizeof(int *) * 7);
    for (int i = 0; i < 7; i++)
        temp2[i] = temp[i];
    qsort(temp2, 7, sizeof(temp2[0]), inc);
    for (int i = 0; i < 7; i++)
        printf("%d %d\n", temp2[i][0], temp2[i][1]);
    qsort(temp, 7, sizeof(temp[0]), inc1);
    for (int i = 0; i < 7; i++)
        printf("%d %d\n", temp[i][0], temp[i][1]);
    return 0;
}
```

### 4.字符排序

```c
int inc(const void* a, const void* b)
{
	return *(char*)a > *(char*)b;
}
int main(void)
{
	char strs[8] = {'c','d','f','t','w','i','q','t'};
	qsort(strs, 8, sizeof(char), inc);
	for (int i = 0; i < 8; i++)
		printf("%c  ", strs[i]);
	return 0;
}
```

### 5.字符串排序

#### (1).以首字母排序

```c
int inc(const void* a, const void* b)
{
	return *(char*)a > *(char*)b;
}
int main(void)
{
	char strs[][6] = { "hi","boys","and","grils" };
	qsort(strs, 4, sizeof(char) * 6, inc);
	for (int i = 0; i < 4; i++)
		printf("%s  ", strs[i]);
	return 0;
}
```

#### (2).以字符串长度排序

```c
int inc(const void* a, const void* b)
{
	return strlen((char*)a) > strlen((char*)b) ? 1 : -1;
}
int main(void)
{
	char strs[][6] = { "hi","boys","and","grils" };
	qsort(strs, 4, sizeof(char) * 6, inc);
	for (int i = 0; i < 4; i++)
		printf("%s  ", strs[i]);
	return 0;
}
```

#### (3).字典排序

```c
int inc(const void* a, const void* b)
{
	return (strcmp((char*)a, (char*)b));
}
int main(void)
{
	char strs[][6] = { "hi","boys","and","grils" };
	qsort(strs, 4, sizeof(char) * 6, inc);
	for (int i = 0; i < 4; i++)
		printf("%s  ", strs[i]);
	return 0;
}
```

### 6.结构体排序

#### (1).一级排序

```c
int inc(const void* a, const void* b)
{
	return (*(node*)a).one > (*(node*)b).one ? 1 : -1;
}
```

#### (2).二级排序

```c
int inc(const void* a, const void* b)
{
	if ((*(node*)a).one != (*(node*)b).one)
		return (*(node*)a).one > (*(node*)b).one ? 1 : -1;
	else return (*(node*)a).two - (*(node*)b).two;
}
```

## 七.指针

### 1.一维指针

当函数形参为 int 型指针,实参为 int 型变量的地址时,最好不要对形参进行自增自减,可以最后直接赋值
