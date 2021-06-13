/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import conveyorBelt.ConveyorBelt;

/**
 *
 * @author ranul
 */
public class Dispatcher implements Runnable{
    
    private ConveyorBelt belt[];
    
    public Dispatcher(){
        ConveyorBelt belt1 = new ConveyorBelt();
        this.belt = new ConveyorBelt[5];
    }

    @Override
    public void run() {
        while(true){
            
        }
    }
    
}
