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
public class MyHero extends BaseHero {

    boolean fighting = false;

    public MyHero(GameBoard board, Point point) {
        super(board, point);
        location = point;
        color = "springgreen";
        hp = 50;
        gameboard.getGameSquare(location).addHero(this);
    }

    @Override
    public boolean isInBattle() {
        return fighting;
    }

    @Override
    public String enemy() {
        return "test";
    }

    @Override
    public void gameTickAction(long arg0) {
        //if (fighting) {

        //} else {
           // gameboard.getGameSquare(location).removeHero(this);
            //Move();
            gameboard.getGameSquare(location).addHero(this);
        //}
    }

    public Point getLocation() {
        return location;
    }

    public void Move() {
        boolean scanning = true;

        Point scanningPoint = new Point(location.x - 0, location.y + 0);
        while (scanning == true) {
            if (gameboard.getGameSquare(scanningPoint).heroesArePresent()) {
                MyHero[] heroesToCheck = new MyHero[gameboard.getGameSquare(scanningPoint).getHeroesPresent().size()];
                //Checks 2 squares in every direction around the hero (5x5 grid)
                for (int i = 0; i < heroesToCheck.length; i++) {

                    //if a hero within that 2x2 grid isn't in battle
                    if (!heroesToCheck[i].isInBattle()) {

                        //if their x and y are within 1 tile of this hero, fight them
                        if (Math.abs(heroesToCheck[i].location.x - this.location.x) == 1 && Math.abs(heroesToCheck[i].location.y - this.location.y) == 1);
                        Fight fight = new Fight(this, heroesToCheck[i]);
                        scanning = false;
                        //if they are too far away to fight (2 away in x or y)    
                    } else {
                        //if they are further away in the x than in the y
                        if (Math.abs(heroesToCheck[i].location.x - this.location.x) >= Math.abs(heroesToCheck[i].location.y - this.location.y)) {

                            //if the hero not fighting is further to the right
                            if (heroesToCheck[i].location.x - this.location.x > 0) {
                                //move a tile to the right
                                location.x++;
                            } //if the hero not fighting is further to the left
                            else {
                                //move a tile to the left
                                location.x--;
                            }
                        };
                    }
                }

            }
            //if the scanner hasn't reached the end of the line going from x-1 to x+1 centered around the hero
            if (scanningPoint.x < location.x + 1) {
                //move the scanner right
                scanningPoint.x++;

                //if the scanner has reached the end of the line going from y-1 to y+1 centered around the hero
            } else if (scanningPoint.y < location.y + 1) {
                //move from all the way to the left
                scanningPoint.x = location.x - 1;
                //move down a row
                scanningPoint.y++;

                //if the whole area has been scanned and no heroes are avalable to move towards    
            } else {
                location.x++;
            }
        };
    }

    public void Move(int leftOffset, int rightOffset, int topOffset, int bottomOffset) {
        boolean scanning = true;

        Point scanningPoint = new Point(location.x - leftOffset, location.y - topOffset);
        while (scanning == true) {
            if (gameboard.getGameSquare(scanningPoint).heroesArePresent()) {
                MyHero[] heroesToCheck = new MyHero[gameboard.getGameSquare(scanningPoint).getHeroesPresent().size()];
                //Checks 2 squares in every direction around the hero (5x5 grid)
                for (int i = 0; i < heroesToCheck.length; i++) {

                    //if a hero within that 2x2 grid isn't in battle
                    if (!heroesToCheck[i].isInBattle()) {

                        //if their x and y are within 1 tile of this hero, fight them
                        if (Math.abs(heroesToCheck[i].location.x - this.location.x) == 1 && Math.abs(heroesToCheck[i].location.y - this.location.y) == 1);
                        Fight fight = new Fight(this, heroesToCheck[i]);
                        scanning = false;
                        //if they are too far away to fight (2 away in x or y)    
                    } else {
                        //if they are further away in the x than in the y
                        if (Math.abs(heroesToCheck[i].location.x - this.location.x) >= Math.abs(heroesToCheck[i].location.y - this.location.y)) {

                            //if the hero not fighting is further to the right
                            if (heroesToCheck[i].location.x - this.location.x > 0) {
                                //move a tile to the right
                                location.x++;
                            } //if the hero not fighting is further to the left
                            else {
                                //move a tile to the left
                                location.x--;
                            }
                        };
                    }
                }

            }
            //if the scanner hasn't reached the end of the line going from x-leftOffset to x+rightOffset centered around the hero
            if (scanningPoint.x < location.x + rightOffset) {
                //move the scanner right
                scanningPoint.x++;

                //if the scanner has reached the end of the line going from y-1 to y+1 centered around the hero
            } else if (scanningPoint.y < location.y + bottomOffset) {
                //move from all the way to the left
                scanningPoint.x = location.x - leftOffset;
                //move down a row
                scanningPoint.y++;

                //if the whole area has been scanned and no heroes are avalable to move towards    
            } else {
                location.x++;
            }
        };
    }

    @Override
    protected void die() {
    }

    @Override
    public boolean isDead() {
        if (hp == 0) {
            return true;
        }else{            
        return false;
        }

    }
}
