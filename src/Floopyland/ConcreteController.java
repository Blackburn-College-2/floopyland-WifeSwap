/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floopyland;

import com.pauliankline.floopyconnector.BaseHero;
import com.pauliankline.floopyconnector.GameBoard;
import com.pauliankline.floopyconnector.GameController;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author jonathan.gabl
 */
public class ConcreteController extends GameController{

    @Override
    public ArrayList<BaseHero> createHeroes(GameBoard board, int numHeros) {
        ArrayList<BaseHero> toReturn = new ArrayList();
        for(int i = 0; i < numHeros; i++){
            toReturn.add(mkHero(board));
            toReturn.get(i).name=("hero"+i);
    }
        return toReturn;
    }
    
    private BaseHero mkHero(GameBoard board){
        return new MyHero(board,new Point((int)(Math.random()*board.getWidth()),(int)(Math.random()*board.getHeight())));
    }
    

    @Override
    public GameBoard mkGameBoard() {
        return new GameBoard();
    }
    
}
