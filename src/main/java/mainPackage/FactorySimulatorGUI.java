/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import Tools.Dispatcher;
import Tools.Machine;
import com.mycompany.factorysimulator.Parcel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import conveyorBelt.ConveyorBelt;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author ranul
 */
public class FactorySimulatorGUI extends JPanel implements ActionListener {

    JPanel panel;
    JPanel panel3;
    ConveyorBelt belt;
    JButton disp, mac, removeMac, removeDisp;
    int dispatcherNumbers;
    static public int machineNumbers;
    JLabel numOfMachines;
    Machine machine;
    ArrayList<Machine> machineObj;
    ArrayList<Dispatcher> dispatcherObj;

    public FactorySimulatorGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        machine = null;
        numOfMachines = new JLabel(">>>Number of Dispatchers = " + dispatcherNumbers + ", Number of Machines = " + machineNumbers);
        numOfMachines.setFont(new Font("Cascadia Code", Font.BOLD, 13));
        setBackground(Color.white);
        this.belt = new ConveyorBelt();

        dispatcherNumbers = 0;
        machineNumbers = 0;

        machineObj = new ArrayList<Machine>();
        dispatcherObj = new ArrayList<Dispatcher>();

        panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel3 = new JPanel();

        disp = new JButton("Add Dispatcher");
        disp.setSize(100, 30);
        disp.setLocation(30, 32);

        removeDisp = new JButton("Remove Dispatcher");

        JLabel label = new JLabel("Max Consumption Time");
        JSlider consumptionTime = new JSlider(0, 10);

        mac = new JButton("Add Machine");
        removeMac = new JButton("Remove Machine");

        JLabel label2 = new JLabel("Max Production Time");
        JSlider production = new JSlider(0, 10);

        disp.addActionListener(this);
        mac.addActionListener(this);
        removeDisp.addActionListener(this);
        removeMac.addActionListener(this);

        BoxLayout box = new BoxLayout(panel1, BoxLayout.Y_AXIS);
        panel1.setLayout(box);
        panel1.add(label);
        panel1.add(consumptionTime);

        BoxLayout box1 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
        panel2.setLayout(box1);
        panel2.add(label2);
        panel2.add(production);

        panel.setPreferredSize(new Dimension(1000, 50));
        panel.add(disp);
        panel.add(removeDisp);
        panel.add(panel1);
        panel.add(mac);
        panel.add(removeMac);
        panel.add(panel2);
        panel.setVisible(true);

        BoxLayout box2 = new BoxLayout(panel3, BoxLayout.X_AXIS);
        panel3.setLayout(box2);
        panel3.add(numOfMachines);

        for (int i = 0; i < 5; i++) {
            machineObj.add(null);
        }

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        int x = 120, y = 40;

        for (int i = 0; i < 8; i++) {
            belt.drawBelt(g, x, y, 80, 80);
            x += 80;
        }

        x = 120;
        y = 130;

        for (int i = 0; i < 8; i++) {
            belt.drawBelt(g, x, y, 80, 80);
            x += 80;
        }

        x = 120;
        y = 220;

        for (int i = 0; i < 8; i++) {
            belt.drawBelt(g, x, y, 80, 80);
            x += 80;
        }

        x = 120;
        y = 310;

        for (int i = 0; i < 8; i++) {
            belt.drawBelt(g, x, y, 80, 80);
            x += 80;
        }

        x = 120;
        y = 400;

        for (int i = 0; i < 8; i++) {
            belt.drawBelt(g, x, y, 80, 80);
            x += 80;
        }

    }

    public static void main(String[] args) {
        FactorySimulatorGUI sim = new FactorySimulatorGUI();
        JFrame frame = new JFrame("Factoty Simulator");
        frame.getContentPane().add(sim, BorderLayout.CENTER);
        frame.getContentPane().add(sim.panel, BorderLayout.SOUTH);
        frame.getContentPane().add(sim.panel3, BorderLayout.NORTH);
        frame.setSize(900, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (mac == obj) {

            machineNumbers++;

            if (machineNumbers >= 6) {
                machineNumbers = 5;
                numOfMachines.setText(">>>Number of Dispatchers = " + dispatcherNumbers + ", Number of Machines = " + machineNumbers);
            } else if (machineNumbers <= 5) {
                numOfMachines.setText(">>>Number of Dispatchers = " + dispatcherNumbers + ", Number of Machines = " + machineNumbers);

                machineObj.set(machineNumbers - 1, new Machine(getGraphics()));

                Thread t1 = new Thread(machineObj.get(machineNumbers - 1));
                t1.start();
            }

        }
        
        

        if (disp == obj) {
            dispatcherNumbers++;

            if (dispatcherNumbers >= 6) {
                dispatcherNumbers = 5;
                numOfMachines.setText(">>>Number of Dispatchers = " + dispatcherNumbers + ", Number of Machines = " + machineNumbers);
            } else if (dispatcherNumbers <= 5) {

                numOfMachines.setText(">>>Number of Dispatchers = " + dispatcherNumbers + ", Number of Machines = " + machineNumbers);
                dispatcherObj.add(new Dispatcher());
            }

        }

        if (removeDisp == obj) {
            if (dispatcherNumbers <= 0) {

                dispatcherNumbers = 0;
                numOfMachines.setText(">>>Number of Dispatchers = " + dispatcherNumbers + ", Number of Machines = " + machineNumbers);

            } else {

                dispatcherNumbers--;
                dispatcherObj.remove(dispatcherNumbers);

                numOfMachines.setText(">>>Number of Dispatchers = " + dispatcherNumbers + ", Number of Machines = " + machineNumbers);
            }
        }

        if (removeMac == obj) {

            if (machineNumbers <= 0) {

                machineNumbers = 0;
                numOfMachines.setText(">>>Number of Dispatchers = " + dispatcherNumbers + ", Number of Machines = " + machineNumbers);

            } else {

                machineNumbers--;
                machineObj.get(machineNumbers).requestStop = false;
                machineObj.set(machineNumbers, null);

                numOfMachines.setText(">>>Number of Dispatchers = " + dispatcherNumbers + ", Number of Machines = " + machineNumbers);

            }
        }

        repaint();
    }

}
