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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<Double>();
        
        if(root == null) {
            return averages;
        }
        
        // perform level order traversal using bfs
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        // get average of each level
        while(!q.isEmpty()) {
            int size = q.size(); // at level 0 max 1 node in q, 2 in lvl 1, 4 in lvl 2 etc
            
            double sum = 0.0;
            // current nodes in q must all be from same level
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                sum += curr.val;
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
            averages.add(sum / size); // average for this level
        } 
        
        return averages;
    }
}