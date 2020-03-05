/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floopyland;

import com.pauliankline.floopyconnector.Item;

/**
 *
 * @author Gabl
 */
public class StrengthPotion extends Item{
    public int doses=4;
    public StrengthPotion() {
        super("StrengthPotion");
        type = "StrengthPotion";
        color = "red";
    }

    
    public void consume() {
        doses--;
    }
    
}
