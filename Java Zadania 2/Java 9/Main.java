package com.company;


import javax.crypto.Mac;
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Macierz m1 = new Macierz(3,4,1,10);
        m1.wyswietl();

        System.out.println();

        Macierz m2 = new Macierz(10,30);
        m2.wyswietl();

        System.out.println();

        Macierz m3 = new Macierz(new int[]{ 4,5 });
        m3.wyswietl();

        Macierz m4 = new Macierz(1,10);
        Macierz m5 = new Macierz(1,10);

        ArrayList<Macierz> lista = new ArrayList<>();
        lista.add(m3);
        lista.add(m4);
        lista.add(m5);

        FileOutputStream fos = new FileOutputStream("lista.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(lista);
        oos.close();


        odczytajIZerujPrzekatne("lista.obj");

        System.out.println("Odczyt odwrotnie:");

        Macierz[] macierze = odczytajOdwrotnie("lista.obj");

        for(Macierz m : macierze){
            m.wyswietl();
            System.out.println();
        }


    }

    public static void odczytajIZerujPrzekatne(String path) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Macierz> lista = (ArrayList<Macierz>)ois.readObject();

        for(Macierz m : lista){
            m.zerujPrzekatne();
            m.wyswietl();
            System.out.println();
        }
    }

    public static Macierz[] odczytajOdwrotnie(String path) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Macierz> lista = (ArrayList<Macierz>)ois.readObject();

        Macierz[] macierze = new Macierz[lista.size()];

        for(int i = lista.size() - 1, j = 0; i >= 0; i--, j++){
            macierze[j] = lista.get(i);
        }

        return macierze;
    }


}
