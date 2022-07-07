/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     
    public boolean isOdd(int num) {
        return num %2 != 0;
    }
    
    public boolean isEven(int num) {
        return num % 2 == 0;
    }
    
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null || isEven(root.val))
            return false;
    
        // perform level order using q
        LinkedList<TreeNode> currentLevel = new LinkedList();
        LinkedList<TreeNode> nextLevel = new LinkedList();
        currentLevel.add(root);
        int level = 0;
        boolean isEmpty = currentLevel.isEmpty();
        
        
        while(!currentLevel.isEmpty()) {
            for(TreeNode item: currentLevel)
                System.out.print(item.val + "->");
            System.out.println("LEVEL " + level + " ITEMS " + currentLevel.size());
            
            
            // check even odd of first item in case of only 1 item in node
            if ((isEven(level) && isEven(currentLevel.get(0).val)) ||
                ( isOdd(level) &&  isOdd(currentLevel.get(0).val))) {
                return false;
            }
                
            
            
            for(int i = 1; i < currentLevel.size(); i++) {
                if (isEven(level)) { // items must be odd and strictly increasing
                    if(isEven(currentLevel.get(i).val) || currentLevel.get(i).val <= currentLevel.get(i - 1).val) {
                        return false;
                    }
                        
                } else { // items must be even and strictly decreasing
                    if(isOdd(currentLevel.get(i).val) || currentLevel.get(i).val >= currentLevel.get(i - 1).val) {
                        System.out.println("COMPARING " + currentLevel.get(i).val + " " + currentLevel.get(i - 1).val);
                        return false;
                    }
                        
                }
            }
            
            
            nextLevel.clear();
            while(!currentLevel.isEmpty()) {
                TreeNode item = currentLevel.poll();
                if(item.left != null)
                    nextLevel.add(item.left);
                if(item.right != null)
                    nextLevel.add(item.right);
            }
            
            currentLevel.addAll(nextLevel);
            level++;
        }

        
        return true;
        
    }
}