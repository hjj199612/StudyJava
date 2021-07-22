package src.dataStructure;

import java.util.Stack;

public class BinaryTree {

    private Node root ;

    public BinaryTree() { //初始化为一个空树
        root = null;
    }

    // 根据给定的key值查询
    public Node find(int key){
        Node current = root; // 从root节点开始查询
        while (current.iData != key) {
            if (key < current.iData) { //向左子树查询
                current = current.leftChild;
            } else {   //向右子树查询
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    //插入
    public void insert(int id ,double dd) {

        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;
        if (root == null) {
            root = newNode;
        } else {
            Node current = root ;//从root节点开始
            Node parent ; //定义一个父节点，该父节点与current相关
            while (true) {
                parent = current;
                if (id < current.iData) { //go left
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else { //go right
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }

            }
        }
    }

    //根据key删除一个节点
    public boolean delete(int key){
        Node current = root ;
        Node parent = root ;
        boolean isLeftChild = true;

        while (current.iData != key) {
            parent = current;
            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false ;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }

        //found node to delete
        //如果没有子节点，直接删除即可
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) { //如果删除的节点为root
                root = null; //空树
            }
            else if(isLeftChild){ //如果删除左子节点
                parent.leftChild = null;
            }
            else { //如果删除右子节点
                parent.rightChild = null;
            }
        }

        //如果没有右节点，用左子树代替当前节点即可。
        else if(current.rightChild == null){
            if (current == root) {
                root = current.leftChild;
            }
            else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            }
            else {
                parent.rightChild = current.leftChild;
            }
        }

        //如果没有左节点，直接用右子树代替当前删除的节点
        else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            }
            else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            }
            else {
                parent.rightChild = current.rightChild;
            }
        }

        // 如果左右子节点均不为空，则需要寻找到节点继承者
        else {
            // 寻找继承者
            Node successor = getSuccessor(current);

            if (current == root) {
                root = successor;
            }
            else if (isLeftChild) {
                parent.leftChild = successor ;
            }
            else {
                parent.rightChild = successor;
            }

            successor.leftChild = current.leftChild; //getsuccessort里边定义了successor的右节点，此时需要定义下左节点。
        }

        return true;
    }
    private Node getSuccessor(Node delNode){
        Node successorParent = delNode; //初始化继承者的父节点
        Node successor = delNode;//初始化继承者几点
        Node current = delNode.rightChild; //从当前节点开始寻找继承者，必须从右子树里寻找继承者，
        //因为右子树比当前节点的值大

        while (current != null) {  //寻找右子树的最左节点作为继承者。保证右子树大于继承者，最左节点是最小的。
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != delNode.rightChild) { //如果继承者不是当前删除节点的右子节点。说明右子树不止一层
            successorParent.leftChild = successor.rightChild; // successort的右子树成为了父类的左子树
            successor.rightChild = delNode.rightChild; //successort的右子树指向被删除节点的右子树
        }
        return successor;
    }

    //遍历
    //前序遍历，从根节点开始遍历。
    private void preOrder(Node localRoot){
        if (localRoot != null) {
            System.out.print(localRoot.iData+"  " );
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }
    //中序
    private void inOrder(Node localRoot){
        if (localRoot !=null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData+"  ");
            inOrder(localRoot.rightChild);
        }
    }
    //后序
    private void postOrder(Node localRoot){
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData+"  ");
        }
    }

    //测试三种遍历方式打印出的结果有何不同之处
    public void traverse(int type){
        switch (type) {
            case 1:
                System.out.print("\npre order :");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nin order :");
                inOrder(root);
                break;
            case 3:
                System.out.print("\npost order :");
                postOrder(root);
                break;
            default:
                break;
        }
    }
    //打印树
    public void displayTree(){
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks =32;getClass();
        boolean isRowEmpty = false;
        System.out.println("=========================================================================");
        while(isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int  j =0;j<nBlanks;j++) {
                System.out.print(" ");
            }

            while (globalStack.isEmpty() == false) {
                Node temp = (Node)globalStack.pop();
                if (temp!=null) {
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null || temp.rightChild !=null) {
                        isRowEmpty = false;
                    }
                }
                else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0;j<nBlanks*2-2;j++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }
        System.out.println("=========================================================================");
    }
}

class Node{
    public int iData; //数据关键字，key
    public double dData; //数据的值
    public Node leftChild ;
    public Node rightChild;

    public void displayNode(){
        System.out.println("{");
        System.out.println(iData);
        System.out.println(",  ");
        System.out.println(dData);
        System.out.println("} ");
    }


}
