/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floopyland;

import com.pauliankline.floopyconnector.BaseHero;
import com.pauliankline.floopyconnector.GameBoard;
import com.pauliankline.floopyconnector.GameController;
import com.pauliankline.floopyconnector.Item;
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
        GameBoard board = new GameBoard(7,7);
        for(int i = 0; i < board.getHeight(); i++){
        for(int j = 0; j < board.getWidth(); j++){
            if (Math.random()<.12){
                board.getGameSquare(new Point(j,i)).addItem(mkItem());
            }
        }
    }
        return board;
    }
    private Item mkItem(){
        Item[] Items = new Item[]{new HealthPotion(), new StrengthPotion(), new TomeOfMisdirection(), new QuickRelic()};
        return Items[(int)(Math.random()*4)];
    
    }
    
}
