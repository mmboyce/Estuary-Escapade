package view;

import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Arc2D;

import javax.swing.JPanel;

import javax.swing.Timer;
public class TimerImage extends JPanel {
    public int time=0;//current time 
    public double numPoints=1;//number of points around full circle when drawing arc
    public double fullCircle=360.0;//degrees of a full circle
    
    public int frameWidth;
    public void update(int time){
        this.time=time;
    }
    public TimerImage(int cycles, int width){
        numPoints=fullCircle/cycles;
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