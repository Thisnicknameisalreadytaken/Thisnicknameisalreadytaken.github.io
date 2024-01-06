from ast import List
import math
from pyparsing import Optional
from text import ListNode
 
             
class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        a=[0]*26
        for i in magazine:
            a[ord(i)-ord('a')]+=1
        for i in ransomNote:
            a[ord(i)-ord('a')]-=1
            if a[ord(i)-ord('a')]<0:
                return False
        return True