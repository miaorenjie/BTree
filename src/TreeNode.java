import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int keyNum;
    public ArrayList<Integer> keys=new ArrayList<>();
    public TreeNode parent;
    public ArrayList<TreeNode>child=new ArrayList<>();

    public void output(){
        for(int i=0;i<keyNum;i++)
            printf(keys.get(i));
    }
    public int getChildSize(){
        return child.size();
    }

    public void addChild(List<TreeNode> child){
        for (TreeNode treeNode:child){
            treeNode.parent=this;
        }
        child.sort(new Comparator<TreeNode>() {
            @Override
                public int compare(TreeNode o1, TreeNode o2) {

                return o1.keys.get(0)-o2.keys.get(0);
            }
        });
        child.addAll(child);
    }

    public static void printf(Object o){
        System.out.println(o);
    }
}
