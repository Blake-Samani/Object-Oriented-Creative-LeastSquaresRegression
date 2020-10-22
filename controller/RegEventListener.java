package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.MenuScreen;
import view.plotDemoPanel;

public class RegEventListener implements ActionListener{

    private plotDemoPanel panel;

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
            System.out.println("CLEAR");
        }else if(source == panel.getplotButton()){
            System.out.println("PLOT");
        }

    }
    
}
