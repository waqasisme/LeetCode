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
     
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null || root.val % 2 == 0)
            return false;
    
        // perform level order using q
        LinkedList<TreeNode> currentLevel = new LinkedList();
        LinkedList<TreeNode> nextLevel = new LinkedList();
        currentLevel.add(root);
        boolean levelEven = true;
        
        while(!currentLevel.isEmpty()) {
            
            // check even odd of first item in case of only 1 item in node (and since our loop won't check)
            if ((levelEven && currentLevel.get(0).val % 2 == 0) ||
                (!levelEven &&  currentLevel.get(0).val % 2 != 0)) {
                return false;
            }
                
            for(int i = 1; i < currentLevel.size(); i++) {
                if (levelEven) { // items must be odd and strictly increasing
                    if(currentLevel.get(i).val % 2 == 0 || currentLevel.get(i).val <= currentLevel.get(i - 1).val) {
                        return false;
                    }
                        
                } else { // items must be even and strictly decreasing
                    if(currentLevel.get(i).val % 2 != 0 || currentLevel.get(i).val >= currentLevel.get(i - 1).val) {
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
            levelEven = !levelEven;
        }

        
        return true;
        
    }
}