//Name - Brayden Kim

public class BSTreeRunner
{
    public static void main( String args[] )
    {
        //add test cases here
        BinarySearchTree test = new BinarySearchTree();
        test.add(90);
        test.add(80);
        test.add(100);
        test.add(70);
        test.add(85);
        test.add(98);
        test.add(120);
        test.inOrder();
        test.preOrder();
        test.postOrder();
        test.revOrder();
        test.getNumLevels();
        test.getNumLeaves();
        test.getWidth();
        test.getDiameter();
        test.getHeight();
        test.getNumNodes();
        test.isFull();
        test.search(120);
        test.getLargest();
        test.getSmallest();
        System.out.println("Tree before removing any nodes - using level order traversal.");
        System.out.println(test.setList());
        test.remove(90);
        test.remove(70);
        test.remove(85);
        test.remove(98);
        test.remove(80);
        test.remove(120);
        test.remove(100);

        test.add(90);
        test.add(80);
        test.add(100);
        test.add(70);
        test.add(85);
        test.add(98);
        test.add(120);
        test.inOrder();
        test.preOrder();
        test.postOrder();
        test.revOrder();
    }
}