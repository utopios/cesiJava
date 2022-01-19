package com.cesi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();

        /*a.add("toto");
        a.add("tata");*/
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner br = new Scanner(System.in);
        String s = null;
        try {
            do {
                System.out.println("Merci de saisir un element : ");
                s = br.next();
                a.add(s);
            }while(!s.equals("0"));
        }
        catch(Exception ex) {
        }

        for(int i = 0; i <  a.size(); i++) {
            System.out.println(a.get(i));
        }

        PcPortable pc = new PcPortable();
    }
}
