from ast import List

from pyparsing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        def dfs(root: Optional[TreeNode]) -> (int, int):
            if root is None:
                return 0, 0
            ly, ln = dfs(root.left)
            ry, rn = dfs(root.right)
            return root.val+ln+rn, max(ly, ln)+max(ry, rn)
        return max(dfs(root))
