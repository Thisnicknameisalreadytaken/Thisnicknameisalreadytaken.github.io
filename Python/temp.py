from ast import List
import math

class Solution:
    def minOperationsMaxProfit(self, customers: List, boardingCost: int, runningCost: int) -> int:
        ans = -1
        margin,time,max,sum=0,0,0,0
        for i in customers: # type: ignore
            margin+=i
            time+=1
            if margin>=4:
                sum+=4*boardingCost-runningCost
                margin-=4
            else:
                sum+=boardingCost*margin-runningCost
                margin=0
            if sum>max:
                max=sum
                ans=time
        while margin>0:
            time+=1
            if margin>=4:
                sum+=4*boardingCost-runningCost
                margin-=4
            else:
                sum+=boardingCost*margin-runningCost
                margin=0
            if sum>max:
                max=sum
                ans=time
        if max==0: 
            return -1
        else:
            return ans