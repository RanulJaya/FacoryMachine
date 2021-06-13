/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.factorysimulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ranul
 */
public class Parcel<E> implements Comparable<Parcel<?>> {

    private E element;
    private Color color;
    private int consumeTime;
    private long timestamp;
    private int priority;

    public Parcel(E element, Color color, int consumeTime, int priority) {

        this.element = element;
        this.color = color;
        this.consumeTime = consumeTime;
        this.priority = priority;
        this.timestamp = System.nanoTime();
    }

    public void consume() {
        try {
            Thread.sleep(consumeTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(Parcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String toString() {
        return element + "(" + priority + ")";
    }

    public void drawBox(Graphics g, int x, int y, int width, int height) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Cascadia Code", Font.BOLD, 14)); 
        g.drawString(toString(), x + 20, y + 20);

    }

    @Override
    public int compareTo(Parcel<?> p) {
        if (priority == p.priority) {
            if (timestamp == p.timestamp) {
                return 0;
            } else if (timestamp < p.timestamp) {
                return 1;
            } else if (timestamp > p.timestamp) {
                return -1;
            }
        } else if (priority > p.priority) {
            if (timestamp == p.timestamp) {
                return 0;
            } else if (timestamp < p.timestamp) {
                return 1;
            } else if (timestamp > p.timestamp) {
                return -1;
            }
        } else if (priority < p.priority) {
            if (timestamp == p.timestamp) {
                return 0;
            } else if (timestamp < p.timestamp) {
                return 1;
            } else if (timestamp > p.timestamp) {
                return -1;
            }
        }
        return 0;
    }

}
