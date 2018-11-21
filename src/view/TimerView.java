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
    public void setTime(int time){
        this.time=time;
    }
    public void setNumPoints(int cycles){
        numPoints=360.0/cycles;
    }
    @Override
    public void paint(Graphics g) {
        System.out.println(time);
        Graphics2D g2d = (Graphics2D) g;
        Arc2D arc=new Arc2D.Float(Arc2D.PIE);
        arc.setFrameFromCenter(new Point(100,100), new Point(180,180));
        arc.setAngleStart(360);
        arc.setAngleExtent(-time*numPoints);      //  360/100=3.6
        g2d.setColor(Color.ORANGE);
        g2d.fill(arc);
    }
    
}