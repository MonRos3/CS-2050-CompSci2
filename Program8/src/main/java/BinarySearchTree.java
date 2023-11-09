public class BinarySearchTree {
    Node root;

    public BinarySearchTree(){
        root = null;
    }

    public void insert(String word){
        if(word == null){
            return;
        }

        word = word.replaceAll("[^a-zA-Z]","").toLowerCase();
        if(word.isEmpty() || word.matches(".*\\d+.*")){
            return;
        }

        root = insertRecursive(root, word);
    }

    private Node insertRecursive(Node root, String word){
        if(root == null) {
            return new Node(word);
        }
        int compareResult = word.compareTo(root.key);

        if (compareResult < 0) {
            root.left = insertRecursive(root.left, word);
        } else if (compareResult > 0){
            root.right = insertRecursive(root.right, word);
        }
        return root;
    }

    public void order(){
        orderRecursive(root);
    }

    private void orderRecursive(Node root){
        if (root != null) {
            orderRecursive(root.left);
            System.out.print(root.key + " ");
            orderRecursive(root.right);
        }
    }

    public int countNodes(){
        return nodesRecursive(root);
    }

    private int nodesRecursive(Node root){
        if (root == null) {
            return 0;
        }
        return 1 + nodesRecursive(root.left) + nodesRecursive(root.right);
    }

    public int getHeight() {
        return heightRecursive(root);
    }

    private int heightRecursive(Node root){
        if (root == null){
            return 0;
        }
        int leftHeight = heightRecursive(root.left);
        int rightHeight = heightRecursive(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
