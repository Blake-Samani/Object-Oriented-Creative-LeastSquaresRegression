package model.idemo;
import java.awt.image.BufferedImage;

public abstract class Regression implements IRender {
    
    private float slopebo;
    private float yintb1;
    private int n;
    private BufferedImage image;
   



public Regression(int n){
    this.n = n;
    
}

public float computeSlope(float n, float sumXY, float sumX, float sumY, float squareSumX){

    slopebo = (n*sumXY -(sumX * sumY))/(n*squareSumX - (sumX * sumX));
    return slopebo;
}


public float getN() {
    return n;
}
public float getSlopebo() {
    return slopebo;
}

public float getYintb1() {
    return yintb1;
}
public void setN(int n) {
    this.n = n;
}
public void setSlopebo(float slopebo) {
    this.slopebo = slopebo;
}

public void setYintb1(float yintb1) {
    this.yintb1 = yintb1;
}
public BufferedImage getImage() {
    return image;
}
public void setImage(BufferedImage image) {
    this.image = image;
}

@Override
public String toString(){
    return "Slope: " + slopebo + "Y int:" + yintb1 + " with " + n + " values";
}



}
