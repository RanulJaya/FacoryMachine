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
    private ConveyorBelt belt[];
    Graphics g;
    int x;

    public Machine(Graphics g) {
        this.requestStop = true;
        this.belt = new ConveyorBelt[5];
        this.belt[FactorySimulatorGUI.machineNumbers - 1] = new ConveyorBelt();
        this.g = g;
        this.x = 40;
    }

    @Override
    public void run() {

        while (requestStop) {

            for (int i = 0; i < belt.length; i++) {
                if (FactorySimulatorGUI.machineNumbers == 1 && belt[0] != null) {
                    belt[0].connectedMachine(this);
                    belt[0].drawBelt(g, x, 40, 80, 80);
                    x += 80;
                }
                if (FactorySimulatorGUI.machineNumbers == 2 && belt[1] != null) {
                    belt[1].connectedMachine(this);
                    belt[1].drawBelt(g, x, 130, 80, 80);
                    x += 80;
                }

                if (FactorySimulatorGUI.machineNumbers == 3 && belt[2] != null) {
                    belt[2].connectedMachine(this);
                    belt[2].drawBelt(g, x, 220, 80, 80);
                    x += 80;
                }
                if (FactorySimulatorGUI.machineNumbers == 4 && belt[3] != null) {
                    belt[3].connectedMachine(this);
                    belt[3].drawBelt(g, x, 310, 80, 80);
                    x += 80;
                }
                if (FactorySimulatorGUI.machineNumbers == 5 && belt[4] != null) {
                    belt[4].connectedMachine(this);
                    belt[4].drawBelt(g, x, 400, 80, 80);
                    x += 80;
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Machine.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
