from ast import List
import math

m,n=map(int,input().split(" "))
ans=0
for i in range(m):
    temp=input().split(" ")
    temp=[int(j) for j in temp]
    res=[[0 for j in range(n+1)] for k in range(n+1)]
    for j in range(0,n+1):
        for k in range(0,n-j):
            res[k][j+k]=max(2*(res[k+1][j+k]+temp[k]),2*(res[k][j+k-1]+temp[j+k]))
    ans+=res[0][n-1]
    print(res[0][n-1])
print(ans)