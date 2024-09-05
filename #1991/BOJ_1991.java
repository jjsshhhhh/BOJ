import java.io.*;
import java.util.*;

public class BOJ_1991 {

    static int N;
    static Node tree;
    static StringBuilder sb = new StringBuilder();

    static class Node {

        char alphabet;
        Node left;
        Node right;

        public Node(char alphabet, Node left, Node right) {

            this.alphabet = alphabet;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {

        init();

        preOrder(tree);
        sb.append('\n');
        inOrder(tree);
        sb.append('\n');
        postOrder(tree);

        System.out.println(sb);
    }

    static void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N= Integer.parseInt(br.readLine()); // 노드 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        char n = st.nextToken().charAt(0);
        char l = st.nextToken().charAt(0); // 왼쪽 자식 노드
        char r = st.nextToken().charAt(0); // 오른쪽 자식 노드

        Node left = (l == '.') ? null : new Node(l, null, null);
        Node right = (r == '.') ? null : new Node(r, null, null) ;
        tree = new Node(n, left, right);

        for (int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            n = st.nextToken().charAt(0);
            l = st.nextToken().charAt(0); // 왼쪽 자식 노드
            r = st.nextToken().charAt(0); // 오른쪽 자식 노드

            Node leftChild = (l == '.') ? null : new Node(l, null, null);
            Node rightChild = (r == '.') ? null : new Node(r, null, null);
            insertNode(tree, new Node(n, leftChild, rightChild));
        }
    }

    static void insertNode(Node head, Node node) {

        if (head == null) return;

        if (head.alphabet == node.alphabet) {
            head.left = node.left;
            head.right = node.right;
            return;
        }

        insertNode(head.left, node);
        insertNode(head.right, node);
    }

    // 전위
    static void preOrder(Node node) {

        if (node == null) return;

        sb.append(node.alphabet);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 중위
    static void inOrder(Node node) {

        if (node == null) return;

        inOrder(node.left);
        sb.append(node.alphabet);
        inOrder(node.right);
    }

    // 후위
    static void postOrder(Node node) {

        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.alphabet);
    }

}