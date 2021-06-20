/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import conveyorBelt.ConveyorBelt;
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import mainPackage.FactorySimulatorGUI;

/**
 *
 * @author ranul
 */
public class Machine implements Runnable {

    public static int MIN_PRODUCTION_TIME;
    public static int MIN_CONSUMPTION_TIME;
    public static int MAX_CONSUMPTION_TIME;
    public static int MAX_PRODUCTION;
    public boolean requestStop;
    public ConveyorBelt belt[];
    Graphics g;
    int x;

    public Machine(Graphics g) {
        this.requestStop = true;
        this.belt = new ConveyorBelt[5];
        for (int i = 0; i < this.belt.length; i++) {
            this.belt[i] = new ConveyorBelt();
        }
        this.g = g;
        this.x = 120;
    }

    @Override
    public void run() {

        while (requestStop) {

            if (!(belt[0].isFull())) {
                belt[0].connectedMachine(this);
            }

            if (!(belt[1].isFull()) && belt[0].isFull()) {
                belt[1].connectedMachine(this);
            }

            if (!(belt[2].isFull()) && belt[1].isFull() && belt[0].isFull()) {
                belt[2].connectedMachine(this);
            }
            if (!(belt[3].isFull()) && belt[2].isFull() && belt[1].isFull() && belt[0].isFull()) {
                belt[3].connectedMachine(this);
            }
            if (!(belt[4].isFull()) && belt[3].isFull() && belt[2].isFull() && belt[1].isFull() && belt[0].isFull()) {
                belt[4].connectedMachine(this);
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Machine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
