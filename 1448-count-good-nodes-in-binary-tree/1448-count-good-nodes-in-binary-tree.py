# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def DFS(self, node, mx, goodOnes):
        if node is not None:
            if node.val >= mx:
                goodOnes.append(node.val)
                mx = node.val
            #print(mx, goodOnes)
            self.DFS(node.left, mx, goodOnes)
            self.DFS(node.right, mx, goodOnes)
                
        return goodOnes
    
    
    def goodNodes(self, root: TreeNode) -> int:
        goodOnes = []
        
        if root is None:
            return 0
        
        # perform DFS while keeping track of max and depth of max
        mx = root.val
        
        self.DFS(root, mx, goodOnes)
        
        return len(goodOnes)
    
    