/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;

/**
 *
 * @author s1901257
 */
public class PelaajanKasi {

    private ArrayList<Kortti> kortit;

    public PelaajanKasi() {
        this.kortit = new ArrayList<Kortti>();
    }

    public void otaKortti(Kortti kortti) {
        this.kortit.add(kortti);
    }

    public int selvitaSumma() {
        int summa = 0;

        for (int i = 0; i < this.kortit.size(); i++) {
            int arvo = this.kortit.get(i).getArvo();

            if (arvo >= 2 && arvo <= 10) {
                summa = summa + arvo;
            } else if (arvo > 10 && arvo < 14) {
                summa = summa + 10;
            } else if (arvo == 1) {
                summa = summa + 11;
            }
            if (arvo == 1 && summa > 21) {
                summa = summa - 10;
            }
        }
        return summa;

    }

    public String blackjack() {

        if(this.selvitaSumma() == 21 && this.kortit.size() == 2) {
            return "Blackjack!!!";
        }
        else {
        }
        return "";
        
    }

    @Override
    public String toString() {
        String kasi = "";
        for(int i = 0;i<this.kortit.size();i++){
            kasi += this.kortit.get(i).toString();
        }
        return kasi;
    }
    

}
