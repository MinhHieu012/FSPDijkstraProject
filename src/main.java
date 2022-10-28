import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String args[]) {
        int totalNodes = 9;
        int a = 0;
        List<List<Node>> getAdjacentNode = new ArrayList<List<Node>>();

        for (int i = 0; i < totalNodes; i++) {
            List<Node> items = new ArrayList<Node>();
            getAdjacentNode.add(items);
        }

        // Node 0
        getAdjacentNode.get(0).add(new Node(1, 5));
        getAdjacentNode.get(0).add(new Node(2, 3));

        // Node 1
        getAdjacentNode.get(1).add(new Node(0, 5));
        getAdjacentNode.get(1).add(new Node(3, 4));
        getAdjacentNode.get(1).add(new Node(4, 2));
        getAdjacentNode.get(1).add(new Node(5, 6));

        // Node 2
        getAdjacentNode.get(2).add(new Node(0, 3));
        getAdjacentNode.get(2).add(new Node(4, 5));
        getAdjacentNode.get(2).add(new Node(5, 7));

        //Node 3
        getAdjacentNode.get(3).add(new Node(1, 4));
        getAdjacentNode.get(3).add(new Node(6, 8));

        // Node 4
        getAdjacentNode.get(4).add(new Node(1, 2));
        getAdjacentNode.get(4).add(new Node(2, 5));
        getAdjacentNode.get(4).add(new Node(5, 4));
        getAdjacentNode.get(4).add(new Node(7, 6));
        getAdjacentNode.get(4).add(new Node(8, 12));
        getAdjacentNode.get(4).add(new Node(6, 7));

        // Node 5
        getAdjacentNode.get(5).add(new Node(2, 7));
        getAdjacentNode.get(5).add(new Node(1, 6));
        getAdjacentNode.get(5).add(new Node(4, 4));
        getAdjacentNode.get(5).add(new Node(7, 5));

        // Node 6
        getAdjacentNode.get(6).add(new Node(3, 8));
        getAdjacentNode.get(6).add(new Node(4, 7));
        getAdjacentNode.get(6).add(new Node(7, 8));
        getAdjacentNode.get(6).add(new Node(8, 8));

        // Node 7
        getAdjacentNode.get(7).add(new Node(5, 5));
        getAdjacentNode.get(7).add(new Node(4, 6));
        getAdjacentNode.get(7).add(new Node(6, 8));
        getAdjacentNode.get(7).add(new Node(8, 7));

        // Node 8
        getAdjacentNode.get(8).add(new Node(6, 8));
        getAdjacentNode.get(8).add(new Node(4, 12));
        getAdjacentNode.get(8).add(new Node(7, 7));

        ProjectCode nodeObject = new ProjectCode(totalNodes);
        nodeObject.ShortestPathNode(getAdjacentNode, a);

        System.out.println("The shortest path from Node 0 to another Node of this Graph is:");

        for (int i = 0; i < nodeObject.distancebetweenNode.length; i++) {
            System.out.println("The shortest path from Node " + a + " -> " + i + " is " + nodeObject.distancebetweenNode[i]);
        }
    }
}