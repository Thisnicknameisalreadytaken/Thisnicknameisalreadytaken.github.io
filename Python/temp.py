import math
from ast import List
from typing import Counter


class Solution:
    def countWords(self, words1: List[str], words2: List[str]) -> int: # type: ignore
        res=0
        fre1=Counter(words1) # type: ignore
        fre2=Counter(words2) # type: ignore
        for word in fre1:
            if fre1[word]*fre2[word]==1:
                res+=1
        return res 