/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author s1901257
 */
public class Korttipakka {
    private ArrayList<Kortti> pakka;

    public Korttipakka() {
        this.pakka = new ArrayList<Kortti>();
              
            for (int kortti = 1; kortti < 13; kortti++) {
                this.pakka.add(new Kortti(kortti,"Hertta"));
                this.pakka.add(new Kortti(kortti,"Risti"));
                this.pakka.add(new Kortti(kortti,"Ruutu"));
                this.pakka.add(new Kortti(kortti,"Pata"));
            }        
    }

    public void Sekoita() {
        Collections.shuffle(this.pakka);
    }
    
    public Kortti jaaKortti(){
        Kortti kortti = this.pakka.get(0);
        this.pakka.remove(0);
        return kortti;
        
    }
    
    
}
