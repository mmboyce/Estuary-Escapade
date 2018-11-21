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
    public void setTime(int time){
        this.time=time;
    }
    @Override
    public void paint(Graphics g) {
        System.out.println(time);
        Graphics2D g2d = (Graphics2D) g;
        Arc2D arc=new Arc2D.Float(Arc2D.PIE);
        arc.setAngleStart(50);
        arc.setAngleExtent(time*(360/500));
        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, 100, 100);

        g2d.setColor(Color.ORANGE);
        //g2d.drawArc(0,0,100,100,1,time*(360/100));
        g2d.fillArc(0,0,100,100,1,time*(360/100));
        // g2d.setColor(Color.black);
        // g2d.draw(circle); 
        // g2d.rotate(Math.toRadians(90));
        // g2d.setFont(new Font("Arial", Font.BOLD, 14));
        // g2d.drawString(time+" %", -10 ,10);
    }
    
}