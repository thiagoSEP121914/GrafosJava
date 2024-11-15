package org.example;

public class Aresta<T> {

    private Double peso;
    private Vertice<T> inicio;
    private Vertice<T> fim;

    public Aresta (Double peso, Vertice<T> inicio, Vertice<T> fim) {
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Vertice<T> getInicio() {
        return inicio;
    }

    public void setInicio(Vertice<T> inicio) {
        this.inicio = inicio;
    }

    public Vertice<T> getFim() {
        return fim;
    }

    public void setFim(Vertice<T> fim) {
        this.fim = fim;
    }
}
