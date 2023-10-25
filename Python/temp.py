from ast import List
import math


def find(temp: str, num: int, need: int):
    if temp == "":
        return num == need
    length = len(temp)
    for i in range(1, length+1):
        judge = find(temp[i:length+1], num+int(temp[0:i]), need)
        if judge == True:
            return True
    return False


for i in range(1, 10001):
    temp = i*i
    strt = str(temp)
    if find(strt, 0, i):
        print(i)
