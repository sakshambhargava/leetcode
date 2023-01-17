class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null)
            return ans;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            ans.add(current.val);
            for (int i = current.children.size() - 1; i >= 0; i--) {
                Node child = current.children.get(i);
                stack.push(child);
            }
        }
        return ans;
    }
}
