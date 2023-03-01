package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main1 {
    public static void main(String[] args) {
        ArrayList<Integer> lineNumbers = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();
        int li = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("domy.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");

                int k = Integer.parseInt(parts[1]);
                double c = Double.parseDouble(parts[2]);

                if(k <= 1){
                    lineNumbers.add(li);
                    double nc = Math.round(0.9*c*100.0)/100.0;
                    prices.add(nc);
                }

                li++;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }


    }
}
