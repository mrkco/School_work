/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;

/**
 *
 * @author s1901257
 */
public class Blackjack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Korttipakka peli = new Korttipakka();

        peli.Sekoita();

        PelaajanKasi pelaaja = new PelaajanKasi();

        System.out.println("*Pelaajan vuoro*");
        pelaaja.otaKortti(peli.jaaKortti());
        pelaaja.otaKortti(peli.jaaKortti());
        System.out.print(pelaaja);

        System.out.println("Yhteensä: " +pelaaja.selvitaSumma());
        System.out.println(pelaaja.blackjack());

        while (pelaaja.selvitaSumma() < 21) {
            System.out.println("Haluatko kortin?");
            Scanner lukija = new Scanner(System.in);
            String vastaus = lukija.nextLine();

            if (vastaus.equals("")) {

                pelaaja.otaKortti(peli.jaaKortti());
                System.out.print(pelaaja);

                System.out.println("Yhteensä: " +pelaaja.selvitaSumma());
                System.out.println(pelaaja.blackjack());

            } else {
                break;
            }
        }
        PelaajanKasi emanta = new PelaajanKasi();
        if (pelaaja.selvitaSumma() < 21) {

            System.out.println("\n*Emännän vuoro*");
            emanta.otaKortti(peli.jaaKortti());
            emanta.otaKortti(peli.jaaKortti());
            System.out.print(emanta);

            System.out.println("Yhteensä: " +emanta.selvitaSumma());
            System.out.println(emanta.blackjack());

            while (emanta.selvitaSumma() <= 15) {

                emanta.otaKortti(peli.jaaKortti());
                System.out.print(emanta);

                System.out.println("Yhteensä: " +emanta.selvitaSumma());
                System.out.println(emanta.blackjack());
            }
        }
        if (emanta.selvitaSumma() > 21) {
            System.out.println("Emännän summa on: " + emanta.selvitaSumma());
            System.out.println("Pelaaja voitti!!");
        } else if (pelaaja.selvitaSumma() > 21) {
            System.out.println("Pelaajan summa on: " + pelaaja.selvitaSumma());
            System.out.println("Emäntä voitti!!");

        } else if (emanta.selvitaSumma() > pelaaja.selvitaSumma() && emanta.selvitaSumma() <= 21) {
            System.out.println("Emännän summa on: " + emanta.selvitaSumma());
            System.out.println("Emäntä voitti!!");
        } else if (emanta.selvitaSumma() < pelaaja.selvitaSumma() && pelaaja.selvitaSumma() <= 21) {
            System.out.println("Pelaajan summa on: " + pelaaja.selvitaSumma());
            System.out.println("Pelaaja voitti!!");
        }
        else if (emanta.selvitaSumma() == pelaaja.selvitaSumma()){
            System.out.println("Pelaajan summa on: " + pelaaja.selvitaSumma());
            System.out.println("Emännän summa on: " + emanta.selvitaSumma());
            System.out.println("Tasapeli");
        }
        

    }
}
