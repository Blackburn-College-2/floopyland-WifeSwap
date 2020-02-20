/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emptyjavaproject;

import com.pauliankline.floopyconnector.BaseHero;
import com.pauliankline.floopyconnector.GameBoard;
import java.awt.Point;

/**
 *
 * @author jonathan.gabl
 */
public class MyHero extends BaseHero{
    
    public MyHero(GameBoard board,Point point){
        super(board,point);
        hp = 50;
    }

    @Override
    public boolean isInBattle() {
        return true;
    }

    @Override
    public String enemy() {
        return "test";
    }

    @Override
    public void gameTickAction(long arg0) {
    }

    @Override
    protected void die() {
    }

    @Override
    public boolean isDead() {
        return false;
    }
    
}
