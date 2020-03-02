/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emptyjavaproject;

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
    
    public GameBoard board;
    public ConcreteController(){
        board = mkGameBoard();
    }

    @Override
    public ArrayList<BaseHero> createHeroes(GameBoard board, int numHeros) {
        ArrayList<BaseHero> toReturn = new ArrayList();
        for(int i = 0; i < numHeros; i++){
            toReturn.add(mkHero());
    }
        return toReturn;
    }
    
    private BaseHero mkHero(){
        return new MyHero(board,new Point((int)(Math.random()*(board.getWidth()-1)),(int)(Math.random()*(board.getHeight()-1))));
    }
    

    @Override
    public GameBoard mkGameBoard() {
        return new GameBoard();
    }
    
}
