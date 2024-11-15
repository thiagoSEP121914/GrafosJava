package org.example;

import java.util.*;

public class Grafo<T> {

    private ArrayList<Vertice<T>> vertice;
    private ArrayList<Aresta<T>> aresta;

    public Grafo() {

        this.vertice = new ArrayList<Vertice<T>>();
        this.aresta = new ArrayList<Aresta<T>>();
    }

    public void adicionarVertice(T elemento) {

        Vertice<T> novoVertice = new Vertice<>(elemento);
        this.vertice.add(novoVertice);
    }

    public void adiconarAresta(Double peso, T dadoInicio, T dadoFim) {

        Vertice<T> inicio = buscarVertice(dadoInicio);
        Vertice<T> fim = buscarVertice(dadoFim);
        Aresta<T> aresta = new Aresta<>(peso, inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.aresta.add(aresta);

    }

    public Vertice<T> buscarVertice(T elemento) {

        for (int i = 0; i < this.vertice.size(); i++) {
            if (vertice.get(i).getElemento().equals(elemento)) {
                return vertice.get(i);
            }
        }
        return null;
    }

    public void buscaLargura() {

        ArrayList<Vertice<T>> marcados = new ArrayList<>();
        ArrayList<Vertice<T>> fila = new ArrayList<>();
        Vertice<T> atual = this.vertice.get(0);
        marcados.add(atual);
        fila.add(atual);
        System.out.println(atual.getElemento());

        while (fila.size() > 0) {
            Vertice<T> visitado = fila.get(0);
            for (int i = 0; i < visitado.getArestaSaida().size(); i++) {
                Vertice<T> proximo = visitado.getArestaSaida().get(i).getFim();
                if (!marcados.contains(proximo)) {
                    marcados.add(proximo);
                    fila.add(proximo);
                    System.out.println(proximo.getElemento());
                }
            }
            fila.remove(0);
        }
    }

    // Algoritmo de Dijkstra para encontrar os predecessores
    private Map<Vertice<T>, Vertice<T>> dijkstra(T origem, T destino) {
        Map<Vertice<T>, Double> menorDistancia = new HashMap<>();
        Map<Vertice<T>, Vertice<T>> predecessores = new HashMap<>();
        PriorityQueue<Vertice<T>> fila = new PriorityQueue<>(Comparator.comparingDouble(menorDistancia::get)); // organiza os vertices em ordem crescente de distancia

        // Inicializa distâncias e predecessores com valores maximos
        for (Vertice<T> vertice : this.vertice) {
            menorDistancia.put(vertice, Double.POSITIVE_INFINITY);
            predecessores.put(vertice, null); // inicializa o mapa predecessores com valores nulos
        }

        Vertice<T> origemVertice = buscarVertice(origem);
        menorDistancia.put(origemVertice, 0.0);
        fila.add(origemVertice);

        while (!fila.isEmpty()) {
            Vertice<T> atual = fila.poll();

            // Processa os vizinhos do vértice atual
            for (Aresta<T> aresta : atual.getArestaSaida()) {
                Vertice<T> vizinho = aresta.getFim();
                double novaDistancia = menorDistancia.get(atual) + aresta.getPeso();

                if (novaDistancia < menorDistancia.get(vizinho)) {
                    menorDistancia.put(vizinho, novaDistancia);
                    predecessores.put(vizinho, atual);
                    fila.remove(vizinho);
                    fila.add(vizinho);
                }
            }
        }

        return predecessores;
    }

    private List<Vertice<T>> reconstruirCaminho(Vertice<T> destinoVertice, Map<Vertice<T>, Vertice<T>> predecessores) {
        List<Vertice<T>> caminho = new ArrayList<>();
        for (Vertice<T> v = destinoVertice; v != null; v = predecessores.get(v)) {
            caminho.add(v);
        }
        Collections.reverse(caminho);
        return caminho;
    }

    public String imprimirCaminho(T origem, T destino) {
        Map<Vertice<T>, Vertice<T>> predecessores = dijkstra(origem, destino);
        Vertice<T> destinoVertice = buscarVertice(destino);

        // Reconstruir o caminho
        List<Vertice<T>> caminho = reconstruirCaminho(destinoVertice, predecessores);

        // Criar string do caminho
        StringBuilder sb = new StringBuilder();
        double distanciaTotal = 0;
        for (int i = 0; i < caminho.size(); i++) {
            sb.append(caminho.get(i).getElemento());
            if (i < caminho.size() - 1) {
                sb.append(" -> ");
            }

            // Calcular a distância total até o destino
            if (i > 0) {
                Vertice<T> anterior = caminho.get(i - 1);
                Vertice<T> atual = caminho.get(i);
                for (Aresta<T> aresta : anterior.getArestaSaida()) {
                    if (aresta.getFim().equals(atual)) {
                        distanciaTotal += aresta.getPeso();
                        break;
                    }
                }
            }
        }
        sb.append(" | Distância total: ").append(distanciaTotal);
        return sb.toString();
    }

}

