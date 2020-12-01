import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите вершине в формате \"PARENT CHILD\". Для завершения ввода \"exit\"");
        Scanner scanner = new Scanner(System.in);

        Graph graph = new Graph();

        String line = scanner.nextLine();
        while (!line.equals("exit")){
            String[] nodes = line.toUpperCase().split("\\s");
            graph.addPath(nodes[0], nodes[1]);
            line = scanner.nextLine();
        }
        System.out.println("Введите начальную вершину и вершину для поиска");
        String start = scanner.nextLine();
        String end = scanner.nextLine();
        System.out.println("BFS");
        graph.BFS(start, end);
        System.out.println("\nDFS");
        graph.DFS(start, end);
        System.out.println("\nDFS REC");
        graph.DFSRecursion(start, end);
    }
}
