/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * AMADO GARCIA 181469
 * LISP INTERPRETER - PROJECT 1 DATA STRUCTURES
 * ING. DOUGLAS BARRIOS
 * ALL THE CODE OF THIS CLASS HAS BEEN OBTAINED FROM THE E-BOOK OF THIS COURSE AND ALSO WITH THIS TUTORIAL: https://www.youtube.com/watch?v=M6lYob8STMI
 */
public class BinaryTree {

    /**
     * Nested class used
     */
    public class Node{
        private int key;
        private String value;

        private Node leftChild;
        private Node rightChild;

        Node(int key, String value){
            this.key = key;
            this.value = value;
        }

        public String toString(){
            return value + " has a key " + key;
        }
    }

    private Node root;
    public void addNode(int key, String value){
        Node newNode = new Node(key, value);

        if(root == null){
            root = newNode;
        }else{
            Node focusNode = root;
            Node parent;

            while (true){
                parent = focusNode;
                if(key < focusNode.key){
                    focusNode = focusNode.leftChild;

                    if(focusNode == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }else{
                    focusNode = focusNode.rightChild;
                    if(focusNode == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }
}

