import java.util.LinkedList;

public class BTree {
    public TreeNode root;
    public int defaultTree=2;
    private boolean FIRST_INSERT=false;

    public void put(int num)
    {

       if(root==null)
           root=new TreeNode();
        TreeNode node=root;
        while (root!=null)
        {
            if (node.child.size()==0)
            {
                node.keys.add(num);
                if (node.keys.size()<=defaultTree)
                    break;
                else
                {
                    splitnode(node);
                    break;
                }
            }
            else
            {
                if (num<node.keys.get(0))
                {
                    node=node.child.get(0);
                    continue;
                }
                if (num>node.keys.get(node.keys.size()-1))
                {
                    node=node.child.get(node.keys.size()-1);
                    continue;
                }
                for (int i=1;i<node.keys.size()-2;i++)
                {
                    if (num<node.keys.get(i))
                    {
                        node=node.child.get(i);
                        break;
                    }
                }
            }

        }
    }

    private void splitnode(TreeNode node) {
//        System.out.println("1");
        int splitIndex=node.keys.size()/2;
        int splitValue=node.keys.get(splitIndex);
        TreeNode left=new TreeNode();

        for (int i=0;i<splitIndex;i++)
            left.keys.add(node.keys.get(i));

        if(node.child.size()>0)
            left.addChild(node.child.subList(0,splitIndex+1));

        TreeNode right=new TreeNode();
        for (int i=splitIndex+1;i<splitIndex;i++)
            right.keys.add(node.keys.get(i));

        if(node.child.size()>0)
            right.addChild(node.child.subList(splitIndex+1,node.getChildSize()-1));

        if(node.parent!=null){
            int i=0;
            for( i=0;i<node.parent.keys.size();i++)
                if(splitValue>node.parent.keys.get(i))
                    break;
            node.parent.child.remove(node);
            node.parent.keys.add(i,splitValue);
            node.child.add(i,left);
            node.child.add(i+1,right);
            if(node.parent.keys.size()>defaultTree)
                splitnode(node.parent);
        }else {
            TreeNode newRoot = new TreeNode();
            newRoot.keys.add(splitValue);
            newRoot.child.add(left);
            newRoot.child.add(right);
            root=newRoot;

        }

    }

    public void insert(int num,TreeNode root){

        int i=0;
        while(i<root.keyNum&&i<root.keys.get(i))
            i++;
        if(i==root.keyNum&&root.keyNum==defaultTree) {
            TreeNode treeNode=root.child.get(i-1);
            insert(num,treeNode);
            TreeNode.printf("1");
        } else if(root==this.root) {
            root.child.add(new TreeNode());
            insert(num,root.child.get(i-1));
            TreeNode.printf("2");
        }else {
            root.keys.add(num);
            root.keyNum++;
            TreeNode.printf("3");
        }
    }
}
