/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conveyorBelt;

import Tools.Machine;
import Tools.Dispatcher;
import com.mycompany.factorysimulator.Parcel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;
import mainPackage.FactorySimulatorGUI;

/**
 *
 * @author ranul
 */
public class ConveyorBelt {

    private int maxCapacity;
    private Machine connectedMachine;
    private Dispatcher connectedDispatcher;
    private PriorityQueue<Parcel<?>> queue;

    public ConveyorBelt(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.queue = new PriorityQueue<>();
    }

    public ConveyorBelt() {
        this.maxCapacity = 10;
        this.queue = new PriorityQueue<>();
        this.connectedMachine = null;
        this.connectedDispatcher = null;
    }

    public synchronized boolean connectedMachine(Machine machine) {

        if (!isFull()) {
            connectedMachine = machine;

            Random rb = new Random();
            char c = (char) (rb.nextInt(26) + 'a');

            Random rand = new Random();

            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            Color randomColor = new Color(r, g, b);

            Random num = new Random();

            long millisecond = System.currentTimeMillis();
            postParcel(new Parcel(c, randomColor, (int) millisecond, num.nextInt(4)), machine);

            return true;

        }

        return false;

    }

    public synchronized boolean connectedDispatcher(Dispatcher machine) {

        if (!isEmpty()) {

        }
        return false;

    }

    public boolean disconnectMachine(Machine machine) {

        return false;

    }

    public boolean disconnectDispatcher(Dispatcher machine) {
        return false;
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.size() == 0;
    }

    public boolean isFull() {
        return maxCapacity == queue.size();
    }

    public boolean postParcel(Parcel<?> p, Machine machine) {
        queue.add(p);
        
        return true;
    }

    public Parcel<?> getFirstParcel(Dispatcher dispatcher) {

        return null;

    }

    public Parcel<?> retrieveParcel(Dispatcher dispatcher) {

        return null;

    }

    public void drawBelt(Graphics g, int x, int y, int width, int height) {

        if (connectedMachine != null && !(isFull())) {
            queue.element().drawBox(g, x, y, width, height);

        }

        if (connectedMachine == null) {
            g.setColor(Color.BLACK);
            g.drawRect(x, y, width, height);

        }
    }
}
