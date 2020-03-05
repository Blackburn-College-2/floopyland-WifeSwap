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

    public Ninja(GameBoard board, Point point) {
        super(board, point);
        hp = 1000;
        color = "DARKMAGENTA";
        super.name = "Ninja";
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
