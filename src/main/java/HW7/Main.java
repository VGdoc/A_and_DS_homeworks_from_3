package HW7;

public class Main {

    public static void main(String[] args) {

        GraphImpl citiesGraph = new GraphImpl(10);

        citiesGraph.addVertex("Москва");
        citiesGraph.addVertex("Тула");
        citiesGraph.addVertex("Рязань");
        citiesGraph.addVertex("Калуга");
        citiesGraph.addVertex("Липецк");
        citiesGraph.addVertex("Тамбов");
        citiesGraph.addVertex("Орел");
        citiesGraph.addVertex("Саратов");
        citiesGraph.addVertex("Курск");
        citiesGraph.addVertex("Воронеж");

        /*
                Тула---------90----------------Липецк----60------
                 10-                                              -
                -                                                  -
        Москва--50----Рязань---40---Тамбов----40---Саратов---30---Воронеж
                -                                                   -
                 10-                                              -
                Калуга------40----Орел--10--Курск------60-------
         */


        citiesGraph.addEdge("Москва", "Тула", 10);
        citiesGraph.addEdge("Тула", "Липецк", 90);
        citiesGraph.addEdge("Липецк", "Воронеж", 60);

        citiesGraph.addEdge("Москва", "Рязань", 50);
        citiesGraph.addEdge("Рязань", "Тамбов", 40);
        citiesGraph.addEdge("Тамбов", "Саратов", 40);
        citiesGraph.addEdge("Саратов", "Воронеж", 30);

        citiesGraph.addEdge("Москва", "Калуга", 10);
        citiesGraph.addEdge("Калуга", "Орел", 40);
        citiesGraph.addEdge("Орел", "Курск", 10);
        citiesGraph.addEdge("Курск", "Воронеж", 60);

        System.out.println(citiesGraph.findShortestWay("Москва", "Воронеж"));


    }

}
