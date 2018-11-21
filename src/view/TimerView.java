package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Shape;
import javax.swing.JPanel;

import javax.swing.Timer;
public class TimerView extends JPanel {
    public TimerView(Timer clock){
        System.out.println("");

    }
    // public void draw(Graphics g) {
    //     Graphics2D g2d = (Graphics2D) g;
    //     Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, 100, 100);

    //     g2d.setColor(Color.GRAY);
    //     g2d.fill(circle);
    // }
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, 100, 100);

        g2d.setColor(Color.ORANGE);
        g2d.fill(circle);
    }
    
}