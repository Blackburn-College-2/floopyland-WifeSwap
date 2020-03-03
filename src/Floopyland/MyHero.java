/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floopyland;

import com.pauliankline.floopyconnector.BaseHero;
import com.pauliankline.floopyconnector.GameBoard;
import java.awt.Point;

/**
 *
 * @author jonathan.gabl
 */
public class MyHero extends BaseHero {

    boolean fighting = false;
	Fight fight;

    public MyHero(GameBoard board, Point point) {
        super(board, point);
        location = new Point(point.x, point.y);
        color = "green";
        hp = 50;
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
		if(isDead){
			
		}else{
			if (fighting) {
			this.attack(fight.getOpponent());				
        } else {
            gameboard.getGameSquare(location).removeHero(this);
            Move();
            gameboard.getGameSquare(location).addHero(this);
        }
		}
    }

    public Point getLocation() {
        return location;
    }
	
	private void attack(MyHero defender){
		defender.recieveDamage(this.dealDamage);
	}
	private abstract int dealDamage(){
		return 10;
	}
	
	public void recieveDamage(int damage){
		this.hp=this.hp-damage;
		if(hp<=0){
			die()
		}
	}
		

    private void Move() {
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

    private void lookAround(int leftOffset, int rightOffset, int topOffset, int bottomOffset) {
        boolean scanning = true;

        Point scanningPoint = new Point(location.x - leftOffset, location.y - topOffset);
        while (scanning == true) {
            if (gameboard.getGameSquare(scanningPoint).heroesArePresent()) {
                ArrayList<<MyHero>> heroesToCheck = gameboard.getGameSquare(scanningPoint).getHeroesPresent();
                //Checks 1 square in every direction around the hero (3x3 grid)
                for (int i = 0; i < heroesToCheck.size; i++) {
                    if (!heroesToCheck.get(i).equals(this)) {
                        //if a hero within that 1x1 grid isn't in battle
                        if (null == heroesToCheck.get(i) || heroesToCheck.get(i).isInBattle()) {
                        } else {

                            //if their x and y are within 1 tile of this hero, fight them
                            if (Math.abs(heroesToCheck.get(i).location.x - this.location.x) <= 1 && Math.abs(heroesToCheck.get(i).location.y - this.location.y) <= 1);
                            this.fight = new Fight(this, heroesToCheck.get(i));
                            System.out.println("Fighting");
                            scanning = false;
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
                    moveTowardsCenter();
                    scanning = false;
                }
        }
    }

    //moves the hero towards the center of the map
    private void moveTowardsCenter() {
        Point center = new Point(gameboard.getHeight() / 2, gameboard.getWidth() / 2);
        //if the hero is further away from center in the x axis than the y axis
        if (Math.abs(location.x - center.x) > Math.abs(location.y - center.y)) {
            //if the hero is right of center
            if (location.x - center.x > 0) {
                moveLeft();
            } else {
                moveRight();
            }
            //if the hero is further away  from the center in the y axis than the x axis or is tied in both directions
        } else {
            if (location.y - center.y > 0) {
                moveUp();
            } else {
                moveDown();
            }

        }
    }

    @Override
    protected void die() {
		this.hp=0
		gameboard.getGameSquare(location).removeHero(this);
    }

    @Override
    public boolean isDead() {
        if (hp == 0) {
            return true;
        } else {
            return false;
        }

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
