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
public class Healer extends MyHero {

    static int population;

    public Healer(GameBoard board, Point point) {
        super(board, point);
        inventorySize = 3;
        hp = 1000;
        maxHp = 1000;
        color = "LEMONCHIFFON";
        population++;
        super.name = "Healer" + population;
    }

    @Override
    public void attack(MyHero defender) {
        if (defender.hasTome()) {
            int damageToHeal = defender.recieveDamage((int)(this.dealDamage()*.9/4));
            if (damageToHeal + hp <= maxHp) {
                hp = hp + damageToHeal;
            } else {
                hp = maxHp;
            }            
        } else {
            int damageToHeal = defender.recieveDamage(this.dealDamage()) / 4;
            if (damageToHeal + hp <= maxHp) {
                hp = hp + damageToHeal;
            } else {
                hp = maxHp;
            }
        }
    }

}
