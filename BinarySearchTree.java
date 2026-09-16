//Name - Brayden Kim

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree
{
    private TreeNode root;
    private static int numLeaves=0;
    private Queue<TreeNode> tempQ=new LinkedList<>();
    private int dR=0;
    private int dL=0;
    private int nodeNum=0;
    private int checkLow = Integer.MAX_VALUE;
    private int checkHigh = Integer.MIN_VALUE;
    private boolean searchB =false;
    private TreeNode tempL;
    private TreeNode tempP;
    private Queue<TreeNode> q = new LinkedList<>();
    private ArrayList<Integer> res = new ArrayList<>();
    private ArrayList list=new ArrayList<>();
    public BinarySearchTree(TreeNode root)
    {
        this.root=root;
    }
    public BinarySearchTree()
    {
        root = null;
    }

    public void add(Comparable val)
    {
        root = add(val, root);
    }

    private TreeNode add(Comparable val, TreeNode tree)
    {
        if(tree == null)
            tree = new TreeNode(val);
        else if (val.compareTo(tree.getValue()) < 0 )
            tree.setLeft(add(val, tree.getLeft()));
        else if (val.compareTo(tree.getValue()) > 0 )
            tree.setRight(add(val, tree.getRight()));
        return tree;
    }

    public void inOrder()
    {
        System.out.println("IN ORDER");
        inOrder(root);
        System.out.println("\n\n");
    }

    private void inOrder(TreeNode tree)
    {
        if (tree != null){
            inOrder(tree.getLeft());
            System.out.print(tree.getValue() + " ");
            inOrder(tree.getRight());
        }
    }

    public void preOrder()
    {
        System.out.println("PRE ORDER");
        preOrder(root);
        System.out.println("\n\n");
    }
    private void preOrder(TreeNode tree)
    {
        if (tree != null){
            System.out.print(tree.getValue() + " ");
            preOrder(tree.getLeft());
            preOrder(tree.getRight());
        }
    }

    public void postOrder()
    {
        System.out.println("POST ORDER");
        postOrder(root);
        System.out.println("\n\n");
    }

    private void postOrder(TreeNode tree)
    {
        if (tree != null){
            postOrder(tree.getLeft());
            postOrder(tree.getRight());
            System.out.print(tree.getValue() + " ");
        }
    }

    public void revOrder()
    {
        System.out.println("REV ORDER");
        revOrder(root);
        System.out.println("\n\n");
    }

    private void revOrder(TreeNode tree)
    {
        if (tree != null){
            revOrder(tree.getRight());
            System.out.print(tree.getValue() + " ");
            revOrder(tree.getLeft());
        }
    }



    public int getNumLevels()
    {
        return getNumLevels(root);
    }

    private int getNumLevels(TreeNode tree)
    {
        //complete the num levels method
        int left=0;
        int right=0;
        root=tree;
        while (tree != null)
        {
            tree = tree.getLeft();
            left++;
        }
        tree=root;
        while (tree != null)
        {
            tree = tree.getRight();
            right++;
        }
        return Math.max(left,right);
    }

    public void getNumLeaves()
    {
        getNumLeaves(root);
        System.out.println("Number of leaves is "+numLeaves);
    }

    private void getNumLeaves(TreeNode tree)
    {
        if(tree!=null && tree.getLeft()==null && tree.getRight()==null)
        {
            numLeaves+=1;
        }
        else if(tree!=null)
        {
            getNumLeaves(tree.getRight());
            getNumLeaves(tree.getLeft());
        }
    }

    public void getDiameter()
    {
        int left=getDiameterL(root);
        int right=getDiameterR(root);
        System.out.println("Tree diameter is "+(left+right));
    }

    private int getDiameterL(TreeNode tree)
    {
        if(tree!=null)
        {
            dL++;
            getDiameterL(tree.getLeft());
        }
        return dL-1;
    }

    private int getDiameterR(TreeNode tree)
    {
        if(tree!=null)
        {
            dR++;
            getDiameterR(tree.getRight());
        }
        return dR-1;
    }

    public void getWidth()
    {
        tempQ.add(root);
        System.out.println("Tree width is "+getWidth(root));
    }

    private Object getWidth(TreeNode tree)
    {
        int width= tempQ.size();
        ArrayList widthList=new ArrayList();
        for(int z=0;z<getNumLevels();z++)
        {
            for(int i=0;i<width;i++)
            {
                TreeNode treeTemp = tempQ.poll();
                if(treeTemp.getLeft()!=null)
                    tempQ.add(treeTemp.getLeft());
                if(treeTemp.getRight()!=null)
                    tempQ.add(treeTemp.getRight());
            }
            width= tempQ.size();
            widthList.add(width);
        }
        widthList.sort(Comparator.comparingInt(Integer::intValue));
        return (widthList.getLast());

    }

    public void getHeight()
    {
        System.out.println("Tree height is "+getHeight(root));
    }

    private int getHeight(TreeNode tree)
    {

        int left=0;
        int right=0;
        root=tree;
        while (tree != null)
        {
            tree = tree.getLeft();
            left++;
        }
        tree=root;
        while (tree != null)
        {
            tree = tree.getRight();
            right++;
        }
        return Math.max(left,right)-1;
    }

    public void getNumNodes()
    {
        System.out.println("Number of nodes is "+getNumNodes(root));
    }

    private int getNumNodes(TreeNode tree)
    {
        if (tree != null){
            getNumNodes(tree.getLeft());
            nodeNum++;
            getNumNodes(tree.getRight());
        }
        return nodeNum;
    }

    public void isFull()
    {
        if(isFull(root)==true)
            System.out.println("Tree is full");
        else
            System.out.println("Tree is not full");
    }

    private boolean isFull(TreeNode tree)
    {
        if (tree != null){
            if(tree.getLeft()==null && tree.getRight()==null)
                if(tree.getLeft()!=null&&tree.getRight()!=null)
                    return false;
            isFull(tree.getLeft());
            isFull(tree.getRight());
        }
        return true;
    }

    public void search(int x)
    {
        searchB=false;
        search(root, x);
        if(searchB) {
            System.out.println("Tree contains " + x + "!");
        }
        else
            System.out.println("Tree does not contain "+x+"!");
    }

    private void search(TreeNode tree, int x)
    {
        if (tree != null){
            if((int)tree.getValue()==x) {
                searchB = true;
            }
            search(tree.getLeft(),x);
            search(tree.getRight(),x);
        }
    }

    public void getLargest()
    {
        getLargest(root);
        System.out.println("Largets tree node is "+checkHigh);
        checkHigh=Integer.MIN_VALUE;
    }

    private void getLargest(TreeNode tree)
    {
        if (tree != null){
            if((int)tree.getValue()>checkHigh)
                checkHigh=(int)tree.getValue();
            getLargest(tree.getLeft());
            getLargest(tree.getRight());
        }
    }

    public void getSmallest()
    {
        getSmallest(root);
        System.out.println("Smallest tree node is "+checkLow);
        checkLow=Integer.MAX_VALUE;
    }

    private void getSmallest(TreeNode tree)
    {
        if (tree != null){
            if((int)tree.getValue()<checkLow)
                checkLow=(int)tree.getValue();
            getSmallest(tree.getLeft());
            getSmallest(tree.getRight());
        }
    }

    public void remove(int x)
    {
        remove(root,x);
        System.out.println("Tree after removing "+x+".\n"+setList());
        if(root.getValue()==null)
            root=null;
    }

    private void remove(TreeNode tree, int x)
    {
        if (tree != null){
            if((int)tree.getValue()==x) {
                findParent(root, tree);
                if(root==tree)
                {
                    if (tree.getLeft() == null && tree.getRight() == null)
                        root.setValue(null);
                    else if ((tree.getLeft() != null && tree.getRight() == null) || (tree.getRight() != null && tree.getLeft() == null)) {
                        if (tree.getRight() != null)
                            root=tree.getRight();
                        else
                            root=tree.getLeft();
                    }
                    else
                    {
                        leftMost(tree.getRight());
                        if (tempL.getRight() != null) {
                            findParent(root, tempL);
                            tree.setValue(tempL.getValue());
                            tempP.setRight(tempL.getRight());
                        } else {
                            tree.setValue(tempL.getValue());
                            findParent(root, tempL);
                            tempP.setLeft(null);
                        }
                    }
                }
                else
                {
                    if (tree.getLeft() == null && tree.getRight() == null)
                        if (tempP.getLeft() != null && (int) tempP.getLeft().getValue() == x)
                            tempP.setLeft(null);
                        else
                            tempP.setRight(null);
                    else if ((tree.getLeft() != null && tree.getRight() == null) || (tree.getRight() != null && tree.getLeft() == null)) {
                        if ((int) tree.getLeft().getValue() == x)
                            if (tree.getLeft() != null)
                                tempP.setLeft(tree.getLeft());
                            else
                                tempP.setLeft(tree.getLeft());
                        else if (tree.getRight() != null)
                            tempP.setRight(tree.getRight());
                        else
                            tempP.setRight(tree.getLeft());
                    }
                    else
                    {
                        leftMost(tree.getRight());
                        if (tempL.getRight() != null) {
                            tree.setValue(tempL.getValue());
                            findParent(root, tempL);
                            tempP.setLeft(tempL.getRight());
                        } else {
                            tree.setValue(tempL.getValue());
                            findParent(root, tempL);
                            tempP.setLeft(null);
                        }
                    }
                }
            }
            remove(tree.getLeft(),x);
            remove(tree.getRight(),x);
        }
    }

    private void findParent(TreeNode tree, TreeNode find)
    {
        if (tree != null){
            if((tree.getLeft()!=null&&tree.getLeft().getValue()==find.getValue())||(tree.getRight()!=null&&tree.getRight().getValue()==find.getValue())) {
                tempP = tree;
                return;
            }
            findParent(tree.getLeft(),find);
            findParent(tree.getRight(),find);
        }
    }

    private void leftMost(TreeNode tree)
    {
        if(tree.getLeft()!=null)
            leftMost(tree.getLeft());
        else
            tempL=tree;
    }

    public ArrayList setList()
    {

        res=new ArrayList<>();
        list=new ArrayList<>();
        if(root.getValue()==null)
        {
            return res;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                // Add front of queue and remove it from
                // queue
                TreeNode node = q.poll();
                res.add((int)node.getValue());

                // Enqueue left child
                if (node.getLeft() != null)
                    q.offer(node.getLeft());

                // Enqueue right child
                if (node.getRight() != null)
                    q.offer(node.getRight());
            }
            for (int i: res) {
                list.add(i);
            }
        }
        return res;
    }

    public String toString()
    {
        return "";
    }

}