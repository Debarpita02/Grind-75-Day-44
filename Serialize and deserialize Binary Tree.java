import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> tokens = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(tokens);
    }

    private TreeNode deserializeHelper(Queue<String> tokens) {
        String token = tokens.poll();
        if (token.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = deserializeHelper(tokens);
        node.right = deserializeHelper(tokens);
        return node;
    }
}
