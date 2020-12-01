import java.util.ArrayList;
import java.util.List;

public class Node {
    private Node parent;
    private final String name;
    private final List<Node> children;

    public Node(String name){
        this.name = name;
        children = new ArrayList<>();
    }

    public void addChildren(Node node){
        children.add(node);
    }

    public String getName() {
        return name;
    }

    public List<Node> getChildren() {
        return children;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
