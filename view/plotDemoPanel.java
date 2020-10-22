package view;

import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.RegEventListener;
import model.idemo.IRender;
import model.idemo.lsRegression;
import model.images.ImageStore;
import java.awt.GridLayout;

import java.awt.BorderLayout;
import java.awt.Color;

public class plotDemoPanel {

    public enum GameState{
        READY, PLOTTING;
    }

    private JFrame window;
    private JButton quitButton = new JButton("Quit");
    private JButton clearButton = new JButton("Clear");
    private JButton plotButton = new JButton("Calculate");
    private JTextArea equation = new JTextArea();
    private GameState gameState = GameState.READY;

    private plotDemoCanvas canvas;

    public plotDemoPanel(JFrame window) {
        this.window = window;
        window.setTitle("Least Squares Regression");
    }

    public void init() {
        Container cp = window.getContentPane();

        canvas = new plotDemoCanvas(this);

        JPanel southPanel = new JPanel();
        southPanel.add(quitButton);
        southPanel.add(clearButton);
        southPanel.add(plotButton);
        southPanel.add(equation);
        southPanel.setLayout(new GridLayout(2,4));

        // title border

        cp.add(BorderLayout.CENTER, canvas);
        cp.add(BorderLayout.SOUTH, southPanel);


        populatePicture(); // call to draw graph image

        RegEventListener listener = new RegEventListener(this);
        quitButton.addActionListener(listener);
        clearButton.addActionListener(listener);
        plotButton.addActionListener(listener);
         // mouse event listener
        canvas.addMouseListener(listener);
        canvas.addMouseMotionListener(listener);
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

    public plotDemoCanvas getCanvas() {
        return canvas;
    }

    public JTextArea getEquation() {
        return equation;
    }
    public void setEquation(String m){
        equation.setText(m);
    }

    public GameState getGameState(){
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}

