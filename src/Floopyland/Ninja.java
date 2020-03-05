/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floopyland;

import com.pauliankline.floopyconnector.GameBoard;
import java.awt.Point;

/**
 *
 * @author Gabl
 */
public class Ninja extends MyHero {
static int population;

    public Ninja(GameBoard board, Point point) {
        super(board, point);
        inventorySize = 3;
        hp = 1000;
        color = "DARKMAGENTA";
        population++;
        super.name = "Ninja"+ population;
    }

    @Override
    public int recieveDamage(int damage) {
        if (Math.random()< .75) {
            this.hp = this.hp - damage;
            int damageTaken = damage;
            if (hp <= 0) {
                die();
            }
            return damageTaken;
        } else {
            this.hp = this.hp - damage/5;
            int damageTaken = damage/5;
            if (hp <= 0) {
                die();
            }
            return damageTaken;
        }
    }

}
