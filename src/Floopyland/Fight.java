/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floopyland;

/**
 *
 * @author Gabl
 */
public class Fight {

    private MyHero fighter1;
    private MyHero fighter2;

    public Fight(MyHero a, MyHero b) {
        fighter1 = a;
        fighter2 = b;
        a.fighting = true;
        b.fighting = true;
        a.fight=this;
        b.fight=this;
    }

    public MyHero getOpponent(MyHero a) {
        if (fighter1.equals(a)) {
            return fighter2;
        } else {
            return fighter1;
        }
    }

    public void end() {
        fighter1.fighting = false;
        fighter2.fighting = false;
    }
}
