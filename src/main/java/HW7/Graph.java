package HW7;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, Integer value);

    int getSize();

    void display();

    public String findShortestWay(String startVertex, String endVertex);

//    /**
//     * англ. Depth-first search, DFS
//     */
//    void dfs(String startLabel);
//
//    /**
//     * англ. breadth-first search, BFS
//     */
//    void bfs(String startLabel);

}
