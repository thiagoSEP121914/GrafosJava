package org.example;

import java.util.ArrayList;

public class Vertice<T> {

    private T elemento;
    private ArrayList<Aresta<T>> arestaEntrada;
    private ArrayList<Aresta<T>> arestaSaida;



    public Vertice (T elemento) {
        this.elemento = elemento;
        this.arestaEntrada = new ArrayList<>();
        this.arestaSaida  = new ArrayList<>();
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public ArrayList<Aresta<T>> getArestaEntrada() {
        return arestaEntrada;
    }

    public void setArestaEntrada(ArrayList<Aresta<T>> arestaEntrada) {
        this.arestaEntrada = arestaEntrada;
    }

    public ArrayList<Aresta<T>> getArestaSaida() {
        return arestaSaida;
    }

    public void setArestaSaida(ArrayList<Aresta<T>> arestaSaida) {
        this.arestaSaida = arestaSaida;
    }

    public void adicionarArestaEntrada (Aresta<T> aresta) {
        this.arestaEntrada.add(aresta);
    }

    public void adicionarArestaSaida (Aresta<T> aresta) {
        this.arestaSaida.add(aresta);
    }


}
