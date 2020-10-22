package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class MenuScreen {
    
    private JFrame window;

    public MenuScreen(JFrame window){
        this.window = window;
    }

    public void init(){
        Container cp = window.getContentPane();

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400,200));
        panel.setLayout(new GridLayout(1,1));

        JButton plotButton = new JButton("Plot Demo");
        panel.add(plotButton);

        cp.add(BorderLayout.CENTER, panel);

        plotButton.addActionListener(event ->{
            window.getContentPane().removeAll();
            var plotMenu = new plotDemoPanel(window);
            plotMenu.init();
            
            window.pack();
            window.revalidate();
        });
    }
}
