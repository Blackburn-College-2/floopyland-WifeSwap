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
            toReturn.get(i).name=(toReturn.get(i).name+i);
    }
        return toReturn;
    }
    
    private BaseHero mkHero(GameBoard board){
        MyHero[] Heroes = new MyHero[]{new Healer(board,new Point((int)(Math.random()*board.getWidth()),(int)(Math.random()*board.getHeight()))), 
                new Tanker(board,new Point((int)(Math.random()*board.getWidth()),(int)(Math.random()*board.getHeight()))), 
                new Ninja(board,new Point((int)(Math.random()*board.getWidth()),(int)(Math.random()*board.getHeight()))),
                new Soldier(board,new Point((int)(Math.random()*board.getWidth()),(int)(Math.random()*board.getHeight()))),
               new GlassCannon(board,new Point((int)(Math.random()*board.getWidth()),(int)(Math.random()*board.getHeight())))};
        
        return Heroes[(int)(Math.random()*5)];
    }
    

    @Override
    public GameBoard mkGameBoard() {
        return new GameBoard(16,16);
    }
    
}
