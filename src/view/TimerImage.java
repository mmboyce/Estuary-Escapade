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
    public int time; //current time 
    public double numPoints; //number of points around full circle when drawing arc
    public double fullCircle; //degrees of a full circle 
    public int frameWidth;
    public int frameHeight;

    public TimerImage(int cycles){
    	fullCircle = 360.0;
    	time = 0;
        numPoints = fullCircle/cycles;
    }
    
    /**
     *  void update
     * 
     * updates the time so that paint redraws the arc to correlate with that time on a full circle
     * 
     * @param time time current indicated by timer
     */
    public void update(int time){
        this.time = time;
    }
    
    public void setFrameSize(int width,int height) {
        this.frameWidth = width;
        this.frameHeight= height;
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Arc2D arc = new Arc2D.Float(Arc2D.PIE);
        arc.setFrame(frameWidth-(frameWidth/10),frameHeight/100,100,100);
        arc.setAngleStart(360);
        arc.setAngleExtent(-time*numPoints);      
        g2d.setColor(Color.ORANGE);
        g2d.fill(arc);
    }
    
}