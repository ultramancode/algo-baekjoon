
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Node root = new Node('A');

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char rootValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            addNode(root, rootValue, leftValue, rightValue);
        }

        // 전위
        preorder(root);
        System.out.println();
        // 중위
        inorder(root);
        System.out.println();
        // 후위
        postorder(root);
        System.out.println();
    }

    static class Node {
        char value;
        Node left;
        Node right;

        Node(char value) {
            this.value = value;
        }
    }

    static void addNode(Node current, char rootValue, char leftValue, char rightValue) {
        if (current == null) return;

        if (current.value == rootValue) {
            if (leftValue != '.') current.left = new Node(leftValue);
            if (rightValue != '.') current.right = new Node(rightValue);
        } else {
            // 왼오 재귀
            if (current.left != null) addNode(current.left, rootValue, leftValue, rightValue);
            if (current.right != null) addNode(current.right, rootValue, leftValue, rightValue);
        }
    }

    // 전위: 루트-왼 - 오
    static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위: 왼- 루트 - 오
    static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    // 후위: 왼 - 오 - 루트
    static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);

    }
}
