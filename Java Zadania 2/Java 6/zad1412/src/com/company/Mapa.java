package com.company;

import java.io.*;
import java.util.ArrayList;

public class Mapa {
    private int klucz;
    private String pole;

    public Mapa(int klucz, String pole) {
        ustawKlucz(klucz);
        ustawPole(pole);
    }

    public int wyswietlKlucz(){
        return klucz;
    }

    public void ustawKlucz(int klucz){
        if(klucz >= 1 && klucz <= 100) {
            this.klucz = klucz;
        }
        else {
            this.klucz = 1;
        }
    }

    public String wyswietlPole(){
        return pole;
    }

    public void ustawPole(String pole){
        if(pole.length() == 3 && sprawdzLitery(pole)) {
            this.pole = pole;
        }
        else {
            this.pole = "aaa";
        }
    }

    public String toString(){
        return klucz + " " + pole;
    }


    public static Mapa Sklej(Mapa m1, Mapa m2){
        Mapa m = new Mapa(m1.klucz + m2.klucz, m1.pole);
        m.pole += m2.pole;
        return m;
    }

    public static void UtworzPlik(String plik) throws IOException {
        ArrayList<Mapa> mapy = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(plik))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] czesci = line.split(" ");
                int klucz = Integer.parseInt(czesci[0]);
                String pole = czesci[1];

                if(klucz < 50) {
                    mapy.add(new Mapa(klucz, pole));
                }
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("wyniki.txt"))) {
            for(Mapa m : mapy){
                bw.write(m + "\n");
            }
        }


    }



    private boolean sprawdzLitery(String txt){
        for (char c : txt.toCharArray()){
            int k = (int)c;

            if(k < 97 || k > 122){
                return false;
            }
        }

        return true;
    }
}
