import java.util.*;


public class ProjectCode {
    int[] distancebetweenNode;
    private Set<Integer> tld;
    private PriorityQueue<Node> pq;

    // Tổng số lượng các đỉnh (Node)
    private int totalNodesOfGraph;
    List <List<Node>> adjacentNode;

    // Constructor
    public ProjectCode (int totalNodesOfGraph) {
        this.totalNodesOfGraph = totalNodesOfGraph;
        distancebetweenNode = new int[totalNodesOfGraph];
        tld = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(totalNodesOfGraph, new Node());
    }

    public void ShortestPathNode(List<List<Node> > adjacentNode, int dis) {
        this.adjacentNode = adjacentNode;

        for (int i = 0; i < totalNodesOfGraph; i++) {
            // Khởi tạo khoảng cách của mọi Node đến vô cùng
            distancebetweenNode[i] = Integer.MAX_VALUE;
        }

        // Thêm Node nguồn là 0 vào PQ
        pq.add(new Node(dis, 0));

        // Khoảng cách của Node nguồn = 0
        distancebetweenNode[dis] = 0;

        while (tld.size() != totalNodesOfGraph) {
        // Kiểm tra điều kiện kết thúc khi
        // hàng đợi ưu tiên không chứa phần tử nào, trả về
            if (pq.isEmpty()) {
                return;
            }

            // Xóa Node có khoảng cách tối thiểu khỏi hàng đợi ưu tiên
            int node = pq.remove().node;


            // Thêm nút có khoảng cách đã xác định
            if (tld.contains(node)) {
                continue;
            }

            tld.add(node);
            NodeAnDistanceNeighbours(node);
        }
    }

    private void NodeAnDistanceNeighbours(int node) {

        int edgeDist = -1;
        int newDist = -1;

        for (int i = 0; i < adjacentNode.get(node).size(); i++) {
            Node dis = adjacentNode.get(node).get(i);

            if (!tld.contains(dis.node)) {
                edgeDist = dis.value;
                newDist = distancebetweenNode[node] + edgeDist;

                // Nếu khoảng cách mới thì chi phí thấp hơn
                if (newDist < distancebetweenNode[dis.node]) {
                    distancebetweenNode[dis.node] = newDist;
                }

                // Thêm nút hiện tại vào hàng đợi ưu tiên
                pq.add(new Node(dis.node, distancebetweenNode[dis.node]));
            }
        }
    }
}

class Node implements Comparator<Node> {
    public int node;
    public int value;

    public Node() {}

    public Node(int node, int value) {
        this.node = node;
        this.value = value;
    }

    @Override
    public int compare(Node node1, Node node2) {

        if (node1.value < node2.value) {
            return -1;
        }

        if (node1.value > node2.value) {
            return 1;
        }
        return 0;
    }
}