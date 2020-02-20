/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emptyjavaproject;

import com.pauliankline.floopyconnector.Floopy;
import com.pauliankline.floopyconnector.GameBoard;

/**
 *
 * @author paul.kline
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Floopy floop = new Floopy(new ConcreteController());
//replace ConcreteController with your controller.
        floop.begin(5); //5 being the number of heroes.

    }
    
}
