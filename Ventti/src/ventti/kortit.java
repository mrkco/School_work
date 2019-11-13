/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventti;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author s1901257
 */
public class kortit {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> pakka = new ArrayList<Integer>();
        
        for(int maat=0;maat<4;maat++){
            pakka.add(1);
            pakka.add(2);
            pakka.add(3);
            pakka.add(4);
            pakka.add(5);
            pakka.add(6);
            pakka.add(7);
            pakka.add(8);
            pakka.add(9);
            pakka.add(10);
            pakka.add(11);
            pakka.add(12);
            pakka.add(13);

        }
        
        Collections.shuffle(pakka);
        
        pakka.get(0);
        System.out.println(pakka.get(0));
        pakka.remove(0);
        
        pakka.get(0);
        System.out.println(pakka.get(0));
        pakka.remove(0);
        
        pakka.get(0);
        System.out.println(pakka.get(0));
        pakka.remove(0);
        
            
    }
}
