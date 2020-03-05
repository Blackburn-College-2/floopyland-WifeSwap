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
public class HealthPotion extends Item {
    public int doses=4;    
    public HealthPotion() {
        super("HealthPotion");
        type = "HealthPotion";
        color = "blue";
    }


    public void consume() {
        doses--;
    }
    
}
