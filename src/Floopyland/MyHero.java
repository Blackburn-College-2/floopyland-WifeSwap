/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floopyland;

import com.pauliankline.floopyconnector.BaseHero;
import com.pauliankline.floopyconnector.GameBoard;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author jonathan.gabl
 */
abstract class MyHero extends BaseHero {

    boolean fighting = false;
    Fight fight;

    public MyHero(GameBoard board, Point point) {
        super(board, point);
        location = new Point(point.x, point.y);
    }

    @Override
    public boolean isInBattle() {
        return fighting;
    }

    @Override
    public String enemy() {
        if(fighting){
        return fight.getOpponent(this).name;
        }else{
            return "";
        }
    }

    @Override
    public void gameTickAction(long arg0) {
        if (!isDead()) {
            if (fighting) {
                //System.out.println(name+" fighting");
                if (!fight.getOpponent(this).isDead()) {
                    this.attack(fight.getOpponent(this));
                }
            } else {
                gameboard.getGameSquare(location).removeHero(this);
                this.Move();
                gameboard.getGameSquare(location).addHero(this);
            }
        }
    }

    public Point getLocation() {
        return location;
    }

    public void attack(MyHero defender) {
        defender.recieveDamage(this.dealDamage());
    }

    int dealDamage(){
        return (int)(Math.random()*45);
    };
            
    public int recieveDamage(int damage) {
        this.hp = this.hp - damage;
        int damageTaken = damage;
        if (hp <=0) {
            die();
        }
        return damageTaken;
    }

    public void Move() {
        //if you are on the far right edge
        if (gameboard.getWidth() - location.x == 1) {
            //if you are on the bottom
            if (gameboard.getHeight() - location.y == 1) {
                lookAround(1, 0, 1, 0);
                //if you are on the top
            } else if (gameboard.getHeight() - location.y == gameboard.getHeight()) {
                lookAround(1, 0, 0, 1);
            } else {
                //if you are on neither y edge
                lookAround(1, 0, 1, 1);
            }
            //if you are on the far left edge.
        } else if (gameboard.getWidth() - location.x == gameboard.getWidth()) {
            //if you are on the bottom
            if (gameboard.getHeight() - location.y == 1) {
                lookAround(0, 1, 1, 0);
                //if you are on the top
            } else if (gameboard.getHeight() - location.y == gameboard.getHeight()) {
                lookAround(0, 1, 0, 1);
            } else {
                // if you are on neither y edge
                lookAround(0, 1, 1, 1);
            }
            //if you are on neither x edge
        } else {
            //if you are on the bottom
            if (gameboard.getHeight() - location.y == 1) {
                lookAround(1, 1, 1, 0);
                //if you are on the top
            } else if (gameboard.getHeight() - location.y == gameboard.getHeight()) {
                lookAround(1, 1, 0, 1);
            } else {
                //if you are on neither y edge
                lookAround(1, 1, 1, 1);
            }

        }
    }

    public void lookAround(int leftOffset, int rightOffset, int topOffset, int bottomOffset) {
        boolean scanning = true;

        Point scanningPoint = new Point(location.x - leftOffset, location.y - topOffset);
        while (scanning == true) {
            if (gameboard.getGameSquare(scanningPoint).heroesArePresent()) {
                ArrayList<MyHero> heroesToCheck = new ArrayList();
                for (int i = 0; i < gameboard.getGameSquare(scanningPoint).getHeroesPresent().size(); i++) {
                    if (gameboard.getGameSquare(scanningPoint).getHeroesPresent().get(i) == null) {
                    } else {
                        heroesToCheck.add((MyHero) gameboard.getGameSquare(scanningPoint).getHeroesPresent().get(i));
                    }
                }
                //Checks 1 square in every direction around the hero (3x3 grid)
                for (int i = 0; i < heroesToCheck.size(); i++) {
                    if (!heroesToCheck.get(i).equals(this)) {
                        //if a hero within that 1x1 grid isn't in battle
                        if (null == heroesToCheck.get(i) || heroesToCheck.get(i).isInBattle()) {
                        } else {

                            //if their x and y are within 1 tile of this hero, fight them
                            if (Math.abs(heroesToCheck.get(i).getLocation().getX() - this.location.x) <= 1 && Math.abs(heroesToCheck.get(i).getLocation().getY() - this.location.y) <= 1);
                            this.fight = new Fight(this, heroesToCheck.get(i));
                            scanning = false;
                            break;
                            //if they are too far away to fight (2 away in x or y)    
                        }

                        //Code below commented out but can be used if the heros can see futher away
                        //below code tells heroes to move towards people they could fight
//                    else {
//                        //if they are further away in the x than in the y
//                        if (Math.abs(heroesToCheck.get(i).location.x - this.location.x) >= Math.abs(heroesToCheck.get(i).location.y - this.location.y)) {
//
//                            //if the hero not fighting is further to the right
//                            if (heroesToCheck.get(i).location.x - this.location.x > 0) {
//                                //move a tile to the right
//                                location.x++;
//                            } //if the hero not fighting is further to the left
//                            else {
//                                //move a tile to the left
//                                location.x--;
//                            }
//                        };
//                    }
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
                moveRandomly(leftOffset,rightOffset,topOffset,bottomOffset);
                scanning = false;
            }
        }
    }

    //moves the hero towards the center of the map
    private void moveRandomly(int leftOffset, int rightOffset, int topOffset, int bottomOffset) {
        int direction = (int)(Math.random()*4);
        if(direction==0){
            location.x = location.x - leftOffset;
        }else if(direction==1){            
            location.x = location.x + rightOffset;
        }else if(direction==2){            
            location.y = location.y - topOffset;
        }else if(direction==3){            
            location.y = location.y + bottomOffset;            
        }
    }

    @Override
    protected void die() {
        this.hp = 0;
        gameboard.getGameSquare(location).removeHero(this);
        fight.end(fight.getOpponent(this));
    }

    @Override
    public boolean isDead() {
        if (hp == 0) {
            return true;
        } else {
            return false;
        }

    }
    
    public void addKill(){
        kills++;
    }

    private void moveLeft() {
        location.x--;
    }

    private void moveRight() {
        location.x++;
    }

    private void moveUp() {
        location.y--;
    }

    private void moveDown() {
        location.y++;
    }
}
