package com.company;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static int silnia(int n){
        /*
        if(n <= 1){
            return 1;
        }
        else {
            return n * silnia(n-1);
        }
         */

        int s = 1;

        for(int i = 1; i <= n; i++){
            s *= i;
        }

        return s;
    }

    public static int dwumian(int n, int k){
        return silnia(n)/(silnia(k) * silnia(n-k));
    }

    public static void main(String[] args) throws IOException {
	    Mapa m1 = new Mapa(-5,"A,b");

        System.out.println(m1);

        m1.ustawKlucz(7);
        m1.ustawPole("bbc");

        System.out.println(m1);

        m1.ustawPole(",,,");
        m1.ustawKlucz(1000);

        System.out.println(m1.wyswietlKlucz() + " " + m1.wyswietlPole());

        Mapa m2 = new Mapa(6, "ghj");

        Mapa m3 = Mapa.Sklej(m1,m2);

        System.out.println(m3);

        Mapa.UtworzPlik("dane.txt");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj wysokosc: ");

        int w = scanner.nextInt();
        int s = 1;
        int t = (w + 5)/2;

        for(int i = 0; i <= w; i++){

            for(int k = 0; k < t; k++){
                System.out.print(" ");
            }
            t--;

            if(i == 0){
                System.out.println(1);
            }
            else {
                System.out.print("1 ");
                for (int j = 1; j <= s; j++) {
                    int el = dwumian(i, j);
                    System.out.print(el + " ");
                }
                System.out.println();

                s++;
            }
        }

    }
}
