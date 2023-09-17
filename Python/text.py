# 猴王
n = int(input())
a = list('0')*n
index, cnt, last = 0, 0, 0
while '0' in a:
    if a[index] != '1':
        cnt = cnt+1
        if cnt >= 3:
            cnt = 0
            a[index] = '1'
            last = index
    index = (index+1) % n
print(last+1)
