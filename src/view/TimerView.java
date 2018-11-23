package view;

import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Arc2D;

import javax.swing.JPanel;

import javax.swing.Timer;
public class TimerView extends JPanel {
    public int time=0;
    public double numPoints=1;
    
    public int frameWidth;
    public void update(int time,int width){
        this.time=time;
        this.frameWidth=width;
    }
    public TimerView(int cycles, int width){
        numPoints=360.0/cycles;
        this.frameWidth=width;
    }
    @Override
    public void paint(Graphics g) {
        //System.out.println(frameWidth);
        Graphics2D g2d = (Graphics2D) g;
        Arc2D arc=new Arc2D.Float(Arc2D.PIE);
        arc.setFrame(1440-100,100,100,100);
        arc.setAngleStart(360);
        arc.setAngleExtent(-time*numPoints);      
        g2d.setColor(Color.ORANGE);
        g2d.fill(arc);
    }
    
}