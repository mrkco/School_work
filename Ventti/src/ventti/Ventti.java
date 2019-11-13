/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ventti {

    public static void main(String[] args) {
        ArrayList<Integer> pakka = new ArrayList<>();
        Scanner lukija = new Scanner(System.in);

        System.out.println("Tervetuloa pelaamaan Venttiä! Luen ensin säännöt(Hyväksy painamalla enter).");
        String kasky = lukija.nextLine();
        System.out.println(
                "Pelissä käytetään normaalia pakkaa: 52 korttia, ei jokereita."
                + "\nPelaaja saa valita onko ässä arvoltaan 1 vaiko 14."
                + "\nEmännällä ässä on aina arvoltaan 1. Pelaaja pelaa kätensä ensin valmiiksi ja"
                + "\npelin voittaa se, jonka käsi on lähempänä arvoa 21 mutta ei yli."
                + "\nPelaa saa päättää ottaako uuden kortin."
                + "\nEmäntä voittaa tasatilanteessa."
                + "\nPelaajana näkee emännän käden kun emäntä pelaa."
                + "\nEmäntä voittaa myös, jos käden arvo on 20, vaikka pelaajalla olisi ventti."
                + "\nPelaajan käsi on ventti, jos siinä on viisi korttia vaikka arvo on alle 21.");

        System.out.println("\nHaluatko aloittaa?");
        kasky = lukija.nextLine();

        System.out.println("\n*Pelaajan vuoro*");

        for (int maat = 0; maat < 4; maat++) {
            for (int kortit = 1; kortit < 13; kortit++) {
                pakka.add(kortit);
            }
        }

        Collections.shuffle(pakka);

        int pelaajanSumma = 0;
        int luku = 0;
        int kortti = 0;
        while (kortti <= 4 || pelaajanSumma <= 21) {

            pakka.get(0);
            System.out.println("Pelaajan kortti on: " + pakka.get(0));
            kortti++;

            if (pakka.get(0) == 1) {
                System.out.println("Haluatko, että kortti: " + pakka.get(0) + " on arvoltaan 1 vai 14?");
                luku = Integer.valueOf(lukija.nextLine());
                if (luku == 1) {
                    pelaajanSumma = pelaajanSumma + 1;
                    System.out.println("Pelaajan summa on: " + pelaajanSumma);
                } else if (luku == 14) {
                    pelaajanSumma = pelaajanSumma + 14;
                    System.out.println("Pelaajan summa on: " + pelaajanSumma);
                } else {
                    System.out.println("Virheellinen syöttö!");
                    break;
                }
            } else {

                pelaajanSumma = pelaajanSumma + pakka.get(0);
                System.out.println("Pelaajan summa on: " + pelaajanSumma);
            }
            pakka.remove(0);

            if (pelaajanSumma >= 21) {
                break;
            }
            if (kortti == 5) {
                break;
            }

            System.out.println("Haluatko jatkaa? ");
            kasky = lukija.nextLine();

            if (kasky.equals("")) {
                continue;
            } else {
                break;
            }
        }
        if (pelaajanSumma > 21) {
            System.out.println("Pelaajan käsi meni yli. Emäntä voitti!!");

        }
        int emannanSumma = 0;

        if (pelaajanSumma < 21) {
            System.out.println("\n*Emännän vuoro*");
            while (emannanSumma <= pelaajanSumma && pelaajanSumma <= 21) {
                pakka.get(0);
                emannanSumma = emannanSumma + pakka.get(0);

                System.out.print("Emännän kortti on: " + pakka.get(0) + "\nEmännän summa on: " + emannanSumma);
                System.out.println("\n");
                pakka.remove(0);
            }

            if (kortti == 5 && emannanSumma < 20) {
                System.out.println("Pelaajan summa on: " + pelaajanSumma + ". Emännän summa on: " + emannanSumma + "\nPelaaja sai ventin, koska nosti " + kortti + " korttia.");
            }
            if (emannanSumma == pelaajanSumma && (emannanSumma < 21 && pelaajanSumma < 21)) {
                System.out.println("Pelaajan summa on: " + pelaajanSumma + ". Emännän summa on: " + emannanSumma + ".\nTasapeli!! Emäntä voitti!!");
            } else if ((emannanSumma == 21 || emannanSumma == 20) && (pelaajanSumma == 21 || kortti == 5)) {
                System.out.println("Pelaajan summa on: " + pelaajanSumma + ". Emännän summa on: " + emannanSumma + ".\nEmäntä sai ventin!!!");
            } else if (emannanSumma == 21 && pelaajanSumma < 21) {
                System.out.println("Pelaajan summa on: " + pelaajanSumma + ". Emännän summa on: " + emannanSumma + ".\nEmäntä sai ventin!!!!");
            } else if (pelaajanSumma == 21 && emannanSumma < 20) {
                System.out.println("Pelaajan summa on: " + pelaajanSumma + ". Emännän summa on: " + emannanSumma + "\nPelaaja sai ventin!!!!");
            } else if (pelaajanSumma < 21 && pelaajanSumma > emannanSumma) {
                System.out.println("Pelaajan summa on: " + pelaajanSumma + ". Emännän summa on: " + emannanSumma + ".\nPelaaja voitti!!!!");
            } else if (emannanSumma > pelaajanSumma && emannanSumma < 21 && kortti != 5) {
                System.out.println("Pelaajan summa on: " + pelaajanSumma + ". Emännän summa on: " + emannanSumma + ".\nEmäntä voitti!!!");
            } else if (pelaajanSumma > 21 && emannanSumma < 21) {
                System.out.println("Pelaajan summa on: " + pelaajanSumma + ". Emännän summa on: " + emannanSumma + ".\nPelaajan käsi meni yli 21." + " Emäntä voitti!!!");
            } else if (emannanSumma > 21 && pelaajanSumma < 21) {
                System.out.println("Pelaajan summa on: " + pelaajanSumma + ". Emännän summa on: " + emannanSumma + ".\nEmännän käsi meni yli 21." + " Pelaaja voitti!!!!");
            } else if (emannanSumma > 21 && pelaajanSumma > 21) {
                System.out.println("Molemmat menivät yli 21.");
            }
        }

    }

}
