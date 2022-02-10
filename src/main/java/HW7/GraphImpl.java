package HW7;

import java.util.*;

public class GraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final Integer[][] adjMatrix;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new Integer[maxVertexCount][maxVertexCount];

        for (Integer[] a: adjMatrix){
            Arrays.fill(a,-1);
        }

    }


    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, Integer value) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = value;

        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] > -1) {
                    sb.append(" -> ").append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    /**
     * Метод ищет кратчайший путь между вершинами, не предполагает развилок по пути
     * @param startVertexLabel Старотовая вершина
     * @param endVertexLabel Целевая вершина
     * @return Строку с результатами
     */
    public String findShortestWay(String startVertexLabel, String endVertexLabel) {
        int bestResult = 0; // переменная для запоминания лучшего результата
        int startIndex = indexOf(startVertexLabel);
        List<Vertex> bestResultVertexList = new ArrayList<>(); // список вершин при лучшем результате

        if (startIndex == -1 || indexOf(endVertexLabel) == -1) {
            throw new IllegalArgumentException("Неверная одна из вершин");
        }

        Deque<Vertex> stack = new LinkedList<>(); // используем ДэКью для хранения списка пройденных вершин
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peekLast());
            if (vertex != null) {
                if (!vertex.getLabel().equals(endVertexLabel)) { // если это не целевая вершина
                    visitVertex(stack, vertex);
                } else {                                        // сли нашли целевую вершину
                    int currentResult = 0; // подсчитывает текущий маршрут
                    List<Vertex> currentResultVertexList = new ArrayList<>(); // записывает вершины в текущем маршруте

                    stack.add(vertex); // добавляем искомую вершину в очередь
                    while (stack.size() > 1){
                        currentResultVertexList.add(stack.peek()); // записываем текущую вершину в текущий маршрут
                        currentResult += adjMatrix[indexOf(stack.remove().getLabel())][indexOf(stack.peek().getLabel())]; // подсчитываем результат, удаляем первую вершину из очереди
                    }
                    currentResultVertexList.add(stack.peek()); // дописываем целевую вершину в результат
                    stack.clear(); // очищаем очередь, чтобы начать сначала
                    stack.add(vertexList.get(startIndex)); // добавляем в очередь точку отправления

                    if (currentResult < bestResult || bestResult == 0){ // сравниваем и переписываем результаты
                        bestResult = currentResult;
                        bestResultVertexList = currentResultVertexList;
                    }
                }
            } else {
                stack.removeLast();
            }
        }
        return bestResultVertexList.toString() + bestResult + "км.";
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] > -1  && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }

        return null;
    }

    private void visitVertex(Queue<Vertex> stack, Vertex vertex) {
        stack.add(vertex);
        vertex.setVisited(true);
    }

}

