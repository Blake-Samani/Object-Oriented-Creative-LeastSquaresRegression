package model.idemo;
import java.awt.image.BufferedImage;

public abstract class Graph {

    private int X;
    private int Y;
    private BufferedImage image;

    public Graph(int X, int Y){
        this.X = X; 
        this.Y = Y;
    }
    public BufferedImage getImage() {
        return image;
    }
    public int getX() {
        return X;
    }
    public int getY() {
        return Y;
    }
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    public void setX(int x) {
        X = x;
    }
    public void setY(int y) {
        Y = y;
    }

   @Override
   public String toString(){
       return "Point at " + X + ", " + Y;
   }
}
