package ppr_lab09;

import dijkstra.Dijkstra;
import dijkstra.Graph;
import dijkstra.Node;

import java.util.Random;

public class PPR_lab09 {

    public static void main(String[] args) {
        Random rand = new Random();
    
        System.out.println("123");
        System.out.println("jakas zmiana");
        System.out.println("2");
        System.out.println("3");

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");

        nodeA.addDestination(nodeB, randomWeights(rand));
        nodeA.addDestination(nodeC, randomWeights(rand));
        nodeB.addDestination(nodeD, randomWeights(rand));
        nodeB.addDestination(nodeF, randomWeights(rand));
        nodeC.addDestination(nodeE, randomWeights(rand));
        nodeD.addDestination(nodeE, randomWeights(rand));
        nodeD.addDestination(nodeF, randomWeights(rand));
        nodeF.addDestination(nodeE, randomWeights(rand));
        nodeG.addDestination(nodeE, randomWeights(rand));

        //test ugabuga

        Graph graph = new Graph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        graph.addNode(nodeG);


        while (true) {
            polaczWezly(rand, graph);
            graph.koniecPolaczenia();
        }
    }
    
     static void printShortestPath(Node node) {
        System.out.print("Najkrótsza droga do "+node.getName()+": ");
        for (Node pNode : node.getShortestPath()) {
            System.out.print(pNode.getName()+"->");
        }
        if(node.getDistance()==Integer.MAX_VALUE)
            System.out.println("Brak ścieszki");
        else
            System.out.println(node.getName()+" (dystans: "+node.getDistance()+")");
    }

     static void polaczWezly(Random rand, Graph graph) {
         int source = rand.nextInt(7)+1;
         int destination = rand.nextInt(7)+1;

         for(Node node : graph.getNodes()) {
             if (source == node.id) {
                 System.out.println("nodeSource: " + node.getName());
                 Dijkstra.calculateShortestPathFromSource(graph, node);
             }
         }
         for(Node node : graph.getNodes()) {
             if (node.id == destination) {
                 System.out.println("nodeDestination: " + node.getName());
                 printShortestPath(node);
             }
         }
         sleepRandomTime(rand);
    }

     static void sleepRandomTime(Random rand) {
        try {
            Thread.sleep((rand.nextInt(5) + 1) * 1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    static int randomWeights(Random rand) {
        return rand.nextInt(15)+1;
    }
}
