import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Java program to Get Level of a node in a Binary Tree
/* A tree node structure */
class Node {
    String data;
    Node left, right;

    public Node(String d)
    {
        data = d;
        left = right = null;
    }
}

class BinaryTree {

    Node root;

    /* Helper function for getLevel().
    It returns level of
    the data if data is present in tree,
    otherwise returns
    0.*/
    int getLevelUtil(Node node, String data, int level)
    {
        if (node == null)
            return 0;

        if (node.data == data)
            return level;

        int downlevel
                = getLevelUtil(node.left, data, level + 1);
        if (downlevel != 0)
            return downlevel;

        downlevel
                = getLevelUtil(node.right, data, level + 1);
        return downlevel;
    }

    /* Returns level of given data value */
    int getLevel(Node node, String data)
    {
        return getLevelUtil(node, data, 1);
    }

    static void listAllNodesInSameDepth(Node node){

        if(node.left!=null)listAllNodesInSameDepth(listNodesInSameDepth(node.left));
        if(node.right!=null)listAllNodesInSameDepth(listNodesInSameDepth(node.right));

    }

    static Node listNodesInSameDepth(Node node){

        System.out.println("Listing Level : "+node.data.toUpperCase());
        return node;

    }

    static List<String> listNodesWithSameDepth(BinaryTree tree, int level){


        List<String> results = new ArrayList<String>();

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(tree.root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            int currentLevel = tree.getLevel(tree.root,node.data );

            if(currentLevel == level){
                results.add(node.data);
            }

                if (node.left != null) {
                    nodes.add(node.left);
                }

                if (node.right != null) {
                    nodes.add(node.right);
                }

        }
        return results;
    }

    /* Driver code */
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();

        /* Constructing tree given in the above figure */
        tree.root = new Node("DOG");
        tree.root.left = new Node("DUCK");
        tree.root.right = new Node("CAT");
        tree.root.left.left = new Node("DEER");
        tree.root.left.right = new Node("COW");
        tree.root.left.right.left = new Node("TIGER");
        tree.root.left.right.right = new Node("RAT");

        for(int i=1;i<=5;i++){
            System.out.println("Level "+i+"="+listNodesWithSameDepth(tree, i));
        }

    }
}

