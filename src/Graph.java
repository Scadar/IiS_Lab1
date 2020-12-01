import java.util.*;

public class Graph {

    List<Node> nodeList;

    public Graph() {
        this.nodeList = new ArrayList<>();
    }

    public void addPath(String parentName, String childName){
        Node parent = createNode(parentName);
        Node child = createNode(childName);
        parent.addChildren(child);
        child.setParent(parent);
    }

    private Node createNode(String name){
        for(Node node : nodeList){
            if(node.getName().equals(name)){
                return node;
            }
        }
        Node newNode = new Node(name);
        nodeList.add(newNode);
        return newNode;
    }

    public void DFS(String startNode, String endNode){
        Node start = getNode(startNode);
        Node end = getNode(endNode);
        showShortPath(start, end);
        ArrayDeque<Node> queue = new ArrayDeque<>();
        List<Node> path = new ArrayList<>();
        queue.addFirst(start);
        while (!queue.isEmpty()){
            Node node = queue.pollFirst();
            path.add(node);
            if(node.getName().equalsIgnoreCase(end.getName())){
                showPath(path);
                return;
            }
            Node[] reverse = node.getChildren().toArray(new Node[0]);
            for(int i = reverse.length - 1; i >= 0; --i){
                queue.addFirst(reverse[i]);
            }
        }
    }

    public void DFSRecursion(String startNode, String endNode){
        Node start = getNode(startNode);
        Node end = getNode(endNode);
        showShortPath(start, end);
        List<Node> path = new ArrayList<>();
        DFSRecursion(start, end, path);
    }

    private void DFSRecursion(Node current, Node end, List<Node> path){
        path.add(current);
        if(current.getName().equalsIgnoreCase(end.getName())){
            showPath(path);
            return;
        }
        for(Node node : current.getChildren()){
            DFSRecursion(node, end, path);
        }
    }

    private void showShortPath(Node start, Node end){
        Node current = end;
        int i = 0;
        System.out.print("Кратчайший путь: ");
        while (current != null && !current.getName().equalsIgnoreCase(start.getName())){
            if(i != 0){
                System.out.print("->");
            }
            System.out.print(current.getName());
            current = current.getParent();
            i++;
        }
        if(current != null && current.getName().equalsIgnoreCase(start.getName())){
            System.out.print("->" + current.getName());
        }
        System.out.println(" ");
    }

    private void showPath(List<Node> nodes){
        System.out.print("Весь путь: ");
        int index = 0;
        for(Node node : nodes){
            if(index != 0){
                System.out.print(" -> ");
            }
            System.out.print(node.getName());
            index++;
        }
        System.out.println(" ");
    }

    public void BFS(String startNode, String endNode){
        Node start = getNode(startNode);
        Node end = getNode(endNode);
        ArrayDeque<Node> queue = new ArrayDeque<>();
        List<Node> path = new ArrayList<>();
        showShortPath(start, end);
        queue.add(start);
        while (!queue.isEmpty()){
            Node node = queue.pop();
            path.add(node);
            if(node.getName().equalsIgnoreCase(end.getName())){
                showPath(path);
                return;
            }
            queue.addAll(node.getChildren());
        }

    }

    private Node getNode(String name){
        for(Node node : nodeList){
            if(node.getName().equals(name)){
                return node;
            }
        }
        throw new RuntimeException("Такой ноды нет");
    }

}
