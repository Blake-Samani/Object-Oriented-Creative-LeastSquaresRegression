package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import model.shapes.Dot;
import model.shapes.IShapeDraw;
import view.MenuScreen;
import view.plotDemoPanel;
import view.plotDemoPanel.GameState;

public class RegEventListener implements ActionListener , MouseListener, MouseMotionListener{

    private plotDemoPanel panel;
    private int clicks = 0;
    // private lsRegression regs = new lsRegression(Color.green, 0);

    public RegEventListener(plotDemoPanel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object source = e.getSource();
        if (source == panel.getQuitButton()){
            JFrame window = panel.getWindow();
            window.getContentPane().removeAll();
            var menu = new MenuScreen(window);
            menu.init();
            window.pack();
            window.revalidate();
        }else if(source == panel.getClearButton()){
            panel.setGameState(GameState.READY);
            clicks = 0; //resets clicks as it is used for testing the index locations of our objects XY point arrays
            panel.getCanvas().getDots().clear(); // clear dots from screen
            panel.getCanvas().getyDots().clear();
            panel.getCanvas().getRegs().clearXY(); //clear xy points from object
            panel.getCanvas().getRegs().clearYLinePoints(); //clear our plotted line y points
            panel.getCanvas().repaint();
            panel.setEquation("");

        }else if(source == panel.getplotButton()){
            panel.setGameState(GameState.PLOTTING);
            panel.getCanvas().getRegs().calcSumX();
            panel.getCanvas().getRegs().calcSumY();
            panel.getCanvas().getRegs().calcSumXY();
            panel.getCanvas().getRegs().calcSquareSumX();
            panel.getCanvas().getRegs().computeSlope(clicks, panel.getCanvas().getRegs().getSumXY(), panel.getCanvas().getRegs().getSumX(), panel.getCanvas().getRegs().getSumY(), panel.getCanvas().getRegs().getSquareSumX());
            // above function call is long and drawn out but basically just computes the slope
            panel.getCanvas().getRegs().setN(clicks);
            panel.getCanvas().getRegs().calcYint();
            String m = "Y = " + panel.getCanvas().getRegs().getSlopebo() + "x + " + panel.getCanvas().getRegs().getYintb1();
            panel.setEquation(m);
            for(int i = 0; i <= 490; i++){
            
            panel.getCanvas().getRegs().calculateYline(i);
            IShapeDraw shape = getShape( i , (((int)panel.getCanvas().getRegs().getYLinePoint(i)- 491 )* -1), Color.RED, true);
            panel.getCanvas().getyDots().add(shape);
            panel.getCanvas().repaint();
            }

        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // System.out.println("Location: " + (e.getX() - 6) + " , " + ((e.getY() - 491 )* -1));
        panel.getCanvas().setM("( " + (e.getX() - 6) + " , " + ((e.getY() - 491 )* -1)+ " )");
        panel.getCanvas().repaint();
    }
    @Override
    public void mousePressed(MouseEvent e) {
        
    //    System.out.println("Click Location: " + (e.getX()  - 6) + " , " + ((e.getY() - 500 )* -1));
    //    dot = new Dot((e.getX() - 6), ((e.getY() - 491 )* -1), 2, Color.green, true);
       IShapeDraw shape = getShape(e.getX(), e.getY(), Color.green, true);
       panel.getCanvas().getDots().add(shape);
       panel.getCanvas().repaint();
       panel.getCanvas().getRegs().addPointsX(e.getX() - 6);
       panel.getCanvas().getRegs().addPointsY((e.getY() - 500 )* -1);
    //    System.out.println("Object X: " + panel.getCanvas().getRegs().getPointsX(clicks) + " Object Y: " + panel.getCanvas().getRegs().getPointsY(clicks) );
       clicks++;
    }

    private IShapeDraw getShape(int x, int y, Color color, boolean filled){
        return new Dot(x, y, 2, Color.green, true);
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

 
    
}
