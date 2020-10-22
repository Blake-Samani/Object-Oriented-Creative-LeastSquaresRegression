package model.shapes;

import java.awt.Graphics2D;
import java.awt.Color;

public class Dot extends Shape implements IShapeDraw {
    
  
    private int radius;
    private Color color;
    private boolean filled;

    public Dot(int x, int y, int radius, Color color, boolean filled){
        super(x, y);
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }
    @Override
    public void render(Graphics2D g2) {
        g2.drawOval(getX(), getY(), radius * 2, radius * 2);
        g2.fillOval(getX(), getY(), radius * 2, radius * 2);
       
           
        
    }
    
}
