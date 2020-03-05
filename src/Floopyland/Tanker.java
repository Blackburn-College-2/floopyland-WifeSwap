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
public class Tanker extends MyHero{
static int population;

    public Tanker(GameBoard board, Point point) {
        super(board, point);
        inventorySize = 3;
        hp = 2000;
        maxHp=2000;
        color = "DARKOLIVEGREEN";
        population++;
        super.name = "Tanker"+ population;
    }
    
}
