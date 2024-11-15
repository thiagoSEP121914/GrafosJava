package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Grafo<String> grafo = new Grafo<>();

        // Adicionando vértices
        grafo.adicionarVertice("A");
        grafo.adicionarVertice("B");
        grafo.adicionarVertice("C");
        grafo.adicionarVertice("D");
        grafo.adicionarVertice("E");
        grafo.adicionarVertice("F");
        grafo.adicionarVertice("G");
        grafo.adicionarVertice("H");
        grafo.adicionarVertice("I");
        grafo.adicionarVertice("J");
        grafo.adicionarVertice("K");
        grafo.adicionarVertice("L");
        grafo.adicionarVertice("M");
        grafo.adicionarVertice("N");
        grafo.adicionarVertice("O");
        grafo.adicionarVertice("P");
        grafo.adicionarVertice("Q");
        grafo.adicionarVertice("R");
        grafo.adicionarVertice("S");
        grafo.adicionarVertice("T");
        grafo.adicionarVertice("U");
        grafo.adicionarVertice("V");
        grafo.adicionarVertice("X");
        grafo.adicionarVertice("Y");

        // Adicionando arestas com pesos
        grafo.adiconarAresta(370.0, "A", "X");
        grafo.adiconarAresta(317.0, "A", "U");
        grafo.adiconarAresta(300.0, "A", "B");
        grafo.adiconarAresta(47.0, "B", "C");
        grafo.adiconarAresta(62.0, "C", "D");
        grafo.adiconarAresta(13.0, "D", "E");
        grafo.adiconarAresta(8.0, "E", "H");
        grafo.adiconarAresta(141.0, "C", "H");
        grafo.adiconarAresta(138.0, "H", "Y");
        grafo.adiconarAresta(153.0, "Y", "J");
        grafo.adiconarAresta(230.0, "G", "J");
        grafo.adiconarAresta(512.0, "J", "K");
        grafo.adiconarAresta(135.0, "K", "L");
        grafo.adiconarAresta(187.0, "N", "L");
        grafo.adiconarAresta(108.0, "N", "O");
        grafo.adiconarAresta(82.0, "P", "O");
        grafo.adiconarAresta(215.0, "P", "Q");
        grafo.adiconarAresta(243.0, "Q", "R");
        grafo.adiconarAresta(33.0, "R", "S");
        grafo.adiconarAresta(38.0, "S", "V");
        grafo.adiconarAresta(210.0, "V", "U");
        grafo.adiconarAresta(107.0, "U", "X");
        grafo.adiconarAresta(22.0, "U", "T");

        System.out.print("Digite a origem: ");
        String origem =  sc.nextLine().toUpperCase();

        System.out.print("Digite o destino: ");
        String destino = sc.nextLine().toUpperCase();

        System.out.println("Distâncias a partir de " + origem + ":");

        // Imprimindo o caminho mais curto de A para x com a distância total
        System.out.println(grafo.imprimirCaminho(origem, destino));

    }
}