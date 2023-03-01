package com.company;

import java.io.Serializable;
import java.util.Locale;

public class Lekarstwa implements Serializable {
    private String[] nazwa;
    private double[] cena;
    private double[] refundacja;

    public Lekarstwa(String[] nazwy, double[] ceny, double[] refundacje){
        if(nazwy.length != ceny.length || nazwy.length != refundacje.length){
            throw new IllegalArgumentException("tablice musza byc rownej dlugosci");
        }

        this.nazwa = new String[nazwy.length];

        for(int i = 0; i < nazwy.length; i++){
            String nowy = nazwy[i].toLowerCase(Locale.ROOT);
            char c  = nowy.charAt(0);
            c = Character.toUpperCase(c);
            this.nazwa[i] = c + nowy.substring(1,nowy.length());
        }

        this.cena = ceny;
        this.refundacja = refundacje;
    }

    public double Cena(String lek, boolean ubezpieczony){
        for (int i = 0; i < nazwa.length; i++) {
            String n = nazwa[i];
            if(n.equalsIgnoreCase(lek)){
                if(ubezpieczony) {
                    return Math.round((cena[i] - refundacja[i] * cena[i])*100.0)/100.0;
                }
                else {
                    return cena[i];
                }
            }
        }

        System.out.println("brak leku o podanej nazwie");
        return 0;
    }

    public double kosztCalkowity(){
        double koszt = 0;

        for(double c : cena){
            koszt += c;
        }

        return Math.round(koszt*100.0)/100.0;
    }

    public void wyswietl(){
        for(int i = 0; i < nazwa.length; i++){
            double p = Math.round(refundacja[i]*100.0*100.0)/100.0;
            System.out.println(nazwa[i] + " cena: " + cena[i] + " refundacja: " + p + " %");
        }
    }

    public int ile(){
        return nazwa.length;
    }



}
