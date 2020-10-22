package view;

import javax.swing.JPanel;

import model.idemo.IRender;
import model.images.ImageStore;
import model.shapes.Dot;
import model.shapes.IShapeDraw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class plotDemoCanvas extends JPanel {
    
    ArrayList<IShapeDraw> dots = new ArrayList<>();
    private plotDemoPanel panel;
    private ArrayList<IRender> picture = new ArrayList<>();

    public plotDemoCanvas(plotDemoPanel panel){
        this.panel = panel;
        setPreferredSize(new Dimension(500,500));
        setBackground(Color.black);

        // testRendering();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 =(Graphics2D) g;

        for(var p: picture){
            p.render(g2);
        }
        // g2.drawImage(ImageStore.plane, null, 0, 0);
        for(var s: dots){
            s.render(g2);
        }
    }

    public ArrayList<IRender> getPicture() {
        return picture;
    }

    // private void testRendering() {
    //     // dots.add(new Dot(50, 50, 2, Color.green, true));
    //     // dots.add(new Dot(150, 150, 2, Color.green, true));
    //     // dots.add(new Dot(250, 250, 2, Color.green, true));
    // }
}