package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    String[] leki = { "lek 1", "lek 2", "lek 3", "lek 4"};
	    double[] ceny = { 33.5, 22.99,12.99,19.99 };
	    double[] ref = { 0.5, 0.1, 0, 0.23 };

	    Lekarstwa lekarstwa = new Lekarstwa(leki,ceny,ref);

        System.out.println(lekarstwa.Cena("lek 2",true));
        System.out.println(lekarstwa.Cena("lek 2",false));
        System.out.println(lekarstwa.Cena("lek 9",true));
        System.out.println(lekarstwa.Cena("lek 4",true));

        System.out.println("Koszt całkowity: " + lekarstwa.kosztCalkowity());

        lekarstwa.wyswietl();

        Lekarstwa lekarstwa1 = new Lekarstwa(new String[]{ "l1", "l2", "l3", "l4" },new double[] { 200.89, 100.60, 400.66, 450.67 }, new double[] {0.1,0.2,0.3,0.1});
        Lekarstwa lekarstwa2 = new Lekarstwa(new String[]{ "l11", "l22", "l33", "l44" },new double[] { 56.8, 122.60, 234.78, 222.67 }, new double[] {0.15,0.15,0.35,0.15});
        Lekarstwa lekarstwa3 = new Lekarstwa(new String[]{ "l111", "l222", "l333", "l444" },new double[] { 567.67, 111.78, 322.76, 121.27 }, new double[] {0.16,0.17,0.37,0.17});
        Lekarstwa lekarstwa4 = new Lekarstwa(new String[]{ "l1111", "l2222", "l3333", "l4444" },new double[] { 267.67, 111.78, 122.76, 121.27 }, new double[] {0.18,0.18,0.38,0.18});

        ArrayList<Lekarstwa> lst = new ArrayList<>();
        lst.add(lekarstwa1);
        lst.add(lekarstwa2);
        lst.add(lekarstwa3);
        lst.add(lekarstwa4);

        try (FileOutputStream fos = new FileOutputStream("lekarstwa.dat"); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(lst);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Lekarstwa> deserialized = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream("lekarstwa.dat");
             ObjectInputStream ois = new ObjectInputStream(fis);){
            deserialized = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Lekarstwa> zapis = new ArrayList<>();

        for(Lekarstwa li : deserialized){
           if(li.kosztCalkowity() <= 1000 && li.ile() < 10){
               zapis.add(li);
           }
        }


        try (FileOutputStream fos = new FileOutputStream("nowe.dat"); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(zapis);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileOutputStream fos = new FileOutputStream("ile.txt")){
            String data = Integer.toString(zapis.size());
            byte[] strToBytes = data.getBytes();
            fos.write(strToBytes);
        }catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Lekarstwa> deserializedNowe = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream("nowe.dat");
             ObjectInputStream ois = new ObjectInputStream(fis);){
            deserializedNowe = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Odczytane nowe:");

        for(Lekarstwa li : deserializedNowe) {
            li.wyswietl();
            System.out.println();
        }



    }
}
