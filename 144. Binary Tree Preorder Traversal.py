class Solution(object):
    def preorderTraversal(self, root):
        res, stack = [], []
        
        while(root!=None or stack != None):
            while(root!=None):
                stack.append(root)
                res.append(root.val)
                root = root.left
        
            if not stack:
                return res
            
            node = stack.pop()
            root = node.right
        
        return res
