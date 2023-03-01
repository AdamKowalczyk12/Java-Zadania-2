package com.company;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class Macierz implements Serializable {
    private int wiersze;
    private int kolumny;
    private int min;
    private int max;
    private int[][] matrix;

    public int getWiersze() {
        return wiersze;
    }

    public int getKolumny() {
        return kolumny;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public Macierz(int liczbaWierszy, int liczbaKolumn, int min, int max){
        this.wiersze = liczbaWierszy;
        this.kolumny = liczbaKolumn;
        this.min = min;
        this.max = max;
        this.matrix = new int[liczbaWierszy][liczbaKolumn];

        for(int i = 0; i < this.wiersze; i++){
            for (int j = 0; j < this.kolumny; j++){
                matrix[i][j] = ThreadLocalRandom.current().nextInt(this.min,this.max + 1);
            }
        }
    }

    public Macierz(int min, int max){
        this(10,10,min,max);
    }

    public Macierz(int...dim){
        this(dim[0],dim[1],0,10);
    }


    public void wyswietl(){
        for(int i = 0; i < this.wiersze; i++){
            for (int j = 0; j < this.kolumny; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int podajElement(int w, int k){
        if(w < 0 || w >= wiersze || k < 0 || k >= kolumny){
            System.out.println("element z poza zakresu");
            return -1;
        }

        return matrix[w][k];
    }

    public void zmienElement(int w, int k, int el){
        if(w < 0 || w >= wiersze || k < 0 || k >= kolumny){
            return;
        }

        matrix[w][k] = el;
    }

    public void zerujPrzekatne(){
        if(wiersze != kolumny){
            System.out.println("Nie da się wyzerowac przekatnych!");
        }
        else {
            for(int i = 0; i < wiersze; i++){
                matrix[i][i] = 0;
                matrix[i][wiersze - i - 1] = 0;
            }
        }
    }
}
