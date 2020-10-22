package view;

import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.RegEventListener;
import model.idemo.IRender;
import model.idemo.lsRegression;
import model.images.ImageStore;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class plotDemoPanel {

    private JFrame window;
    private JButton quitButton = new JButton("Quit");
    private JButton clearButton = new JButton("Clear");
    private JButton plotButton = new JButton("Plot");

    private plotDemoCanvas canvas;

    public plotDemoPanel(JFrame window) {
        this.window = window;
    }

    public void init() {
        Container cp = window.getContentPane();

        canvas = new plotDemoCanvas(this);

        JPanel southPanel = new JPanel();
        southPanel.add(quitButton);
        southPanel.add(clearButton);
        southPanel.add(plotButton);

        // title border

        cp.add(BorderLayout.CENTER, canvas);
        cp.add(BorderLayout.SOUTH, southPanel);
        final RegMouseEvent mouseEvent = new RegMouseEvent(); // mouse event listener
        canvas.addMouseListener(mouseEvent);
        canvas.addMouseMotionListener(mouseEvent);

        populatePicture(); // call to draw graph image

        RegEventListener listener = new RegEventListener(this);
        quitButton.addActionListener(listener);
        clearButton.addActionListener(listener);
        plotButton.addActionListener(listener);
    }

    private void populatePicture() {
        ArrayList<IRender> pics = canvas.getPicture();
        var c1 = new lsRegression(Color.white, 1);
        pics.add(c1);
        c1.setImage(ImageStore.plane);
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getplotButton() {
        return plotButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    public JFrame getWindow() {
        return window;
    }
}

class RegMouseEvent implements MouseListener, MouseMotionListener {

  

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseClicked(MouseEvent e) {}
    
    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("Location: " + e.getX() + " , " + ((e.getY() - 500 )* -1));

    }

}
