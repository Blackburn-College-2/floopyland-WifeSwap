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
public class GlassCannon extends MyHero{
static int population;

    public GlassCannon(GameBoard board, Point point) {
        super(board, point);
        inventorySize = 3;
        hp = 2;
        maxHp = 2;
        color = "PALETURQUOISE";
        population++;
        super.name = "GlassCannon"+ population;
    }    
    @Override
    public void attack(MyHero defender) {
        defender.recieveDamage((int)strengthModifier*this.dealDamage());
        hp = maxHp;
    }
    @Override 
    public int dealDamage(){
        return 2000;
    }
}
