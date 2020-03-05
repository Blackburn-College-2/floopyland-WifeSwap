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
public class Healer extends MyHero{

    public Healer(GameBoard board, Point point) {
        super(board, point);
        hp = 1000;
        maxHp = 1000;
        color = "LEMONCHIFFON";
        super.name = "Healer";
    }
    @Override
    public void attack(MyHero defender) {
        int damageToHeal = defender.recieveDamage(this.dealDamage())/4;
        if(damageToHeal + hp <= maxHp){
            hp = hp + damageToHeal;
        }else{
            hp = maxHp;
        }
    }
    
}
