public class Main {
    public static void main(String[] args) {
            BTree bTree=new BTree();
            bTree.put(1);
            bTree.put(2);
            bTree.put(3);
            bTree.put(4);
            bTree.put(5);

        TreeNode.printf(bTree.root.child.size()+"-"+bTree.root.keys.get(0));

    }
}
