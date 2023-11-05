from ast import List
import math


class Solution:
    def countPoints(self, rings: str) -> int:
        color=['R','G','B']
        ans = 0
        for i in range(0,9):
            judge=0
            for j in color:
                if (str(i)+j) in rings:
                    judge=0
                else:
                    judge=1
                    break
            if judge==0:
                ans+=1
        return   ans