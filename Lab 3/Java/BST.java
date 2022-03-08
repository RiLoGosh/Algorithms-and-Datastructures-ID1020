import java.util.Scanner;



public class BST<item extends Comparable<item>, V> {


    private class Node{
        public item key;
        public V value;
        public Node right;
        public Node left;
    }

    Node Root;


    public BST() {}

    public void insert(Node root, Node newnode){

        int comparison = newnode.key.compareTo(root.key);

        if (comparison == 0){
            root.value = newnode.value;
        }

        else if(comparison > 0){
            if (root.left == null){
                root.left = newnode;
            }
            else {
                insert(root.left, newnode);
            }

        }

        else{
            if (root.right == null){
                root.right = newnode;
            }
            else{
                insert(root.right, newnode);
            }
        }

    }

    public void put(item key, V value){

        Node newN = new Node();
        newN.value = value;
        newN.key = key;

        if (Root == null){
            Root = newN;
        }

        else{
            insert(Root, newN);
        }
    }

    public V get(item key){
        return traverse(Root, key).value;
    }

    public Node traverse(Node root, item key){

        if (root == null){
            return null;
        }

        int comparison = key.compareTo(root.key);

        if(comparison == 0){
            return root;
        }

        else if(comparison > 0){
            return traverse(root.left, key);
        }

        else {
            return traverse(root.right, key);
        }
    }


    public boolean contains(item key){

        return traverse(Root, key) != null;
    }



   public void infixRepresentation(Node root){

       if ((root.right != null)){
           infixRepresentation(root.right);
       }

        System.out.print(root.key + " ");

       if (root.left != null){
           infixRepresentation(root.left);
       }

   }




    public static void main(String[] args)
    {
        // take the number of inputs from the user in the form of
        // "{string} {integer}", split them by whitespace and add them to
        // the symbol table as key and value, respectively.
        // lastly, print out the table
        BST<String, Integer> myTree = new BST<>();

        myTree.put("W", 1);
        myTree.put("O", 5);
        myTree.put("E", 5);
        myTree.put("C", 5);
        myTree.put("A", 8);
        myTree.put("L", 8);
        myTree.put("H", 8);


       myTree.infixRepresentation(myTree.Root);




    }

}
