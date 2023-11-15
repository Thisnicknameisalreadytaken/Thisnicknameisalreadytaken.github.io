n=int(input())
temp,res=1,0
for i in range(1,n+1):
    temp*=i
    res+=temp
print(res)