package model.idemo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.util.Collections;

public class lsRegression extends Regression {

    public class Pos{ //position class for line of best fit drawing/connecting
        public int x;
        public int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    ArrayList<Float> xPoints = new ArrayList<>();
    ArrayList<Float> yPoints = new ArrayList<>();
    private Color color;
    private float sumX;
    private float sumY;
    private float sumXY;
    private float squareSumX;
    private float minX;
    private float maxY;
    private Pos[] p = new Pos[2]; //position object to hold an x and y for line connecting

    public lsRegression(Color color, int n) {
        super(n);
        this.color = color;
    }

    public void clearXY(){
        xPoints.clear();
        yPoints.clear();
    }

    public void getmin_x() { // sets minimum x value for line of best fit

        setMinX(Collections.min(xPoints));
    }

    public void getmax_y() { // sets max y value for line of best fit

        setMaxY(Collections.max(yPoints));
    }

    public void calcSumX() {
        float s = 0;
        for (int i = 0; i < xPoints.size(); i++) {
            s += xPoints.get(i);
        }
        setSumX(s);

    }

    public void calcSumY() {
        float s = 0;
        for (int i = 0; i < yPoints.size(); i++) {
            s += yPoints.get(i);
        }
        setSumY(s);
    }

    public void calcSumXY() {
        float s = 0;
        for (int i = 0; i < xPoints.size(); i++) {
            s += (xPoints.get(i) * yPoints.get(i));
        }
        setSumXY(s);
    }

    public void calcSquareSumX() {
        float s = 0;
        for (int i = 0; i < xPoints.size(); i++) {
            s += (xPoints.get(i) * xPoints.get(i));
        }
        setSquareSumX(s);
    }

    public void calcYint() {
        float s = 0;
        s = (getSumY() - (getSlopebo() * getSumX())) / getN();
        setYintb1(s);
    }

    public void addPointsX(float x) {
        xPoints.add(x);
    }

    public void addPointsY(float y) {
        yPoints.add(y);
    }

    public float getPointsY(int index){
        return yPoints.get(index);
    }

    public float getPointsX(int index){
        return xPoints.get(index);
    }

    public float getMinX(ArrayList<Float> xPoints) {
        ArrayList<Float> temp = new ArrayList<>();
        temp = xPoints;
        Collections.sort(temp);
        return temp.get(0); // returns min value
    }

    public float getMaxY(ArrayList<Float> yPoints) {
        ArrayList<Float> temp = new ArrayList<>();
        temp = yPoints;
        Collections.sort(temp);
        return temp.get(temp.size() - 1); // returns max value
    }

    public Color getColor() {
        return color;
    }

    public float getMaxY() {
        return maxY;
    }

    public float getMinX() {
        return minX;
    }

    public float getSquareSumX() {
        return squareSumX;
    }

    public float getSumX() {
        return sumX;
    }

    public float getSumXY() {
        return sumXY;
    }

    public float getSumY() {
        return sumY;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setMaxY(float maxY) {
        this.maxY = maxY;
    }

    public void setMinX(float minX) {
        this.minX = minX;
    }

    public void setSumX(float sumX) {
        this.sumX = sumX;
    }

    public void setSumXY(float sumXY) {
        this.sumXY = sumXY;
    }

    public void setSumY(float sumY) {
        this.sumY = sumY;
    }

    public void setSquareSumX(float squareSumX) {
        this.squareSumX = squareSumX;
    }

    public ArrayList<Float> getyPoints() {
        return yPoints;
    }

    public ArrayList<Float> getxPoints() {
        return xPoints;
    }

    public void setyPoints(ArrayList<Float> yPoints) {
        this.yPoints = yPoints;
    }

    public void setxPoints(ArrayList<Float> xPoints) {
        this.xPoints = xPoints;
    }

    public void setPos(int index, int x, int y){
        
        p[index] = new Pos(x, y);
    }

    @Override
    public void render(Graphics2D g2) {
        g2.drawImage(getImage(), null, 0, 0);
        //DRAW EQUATION HERE g2.drawstring
        

    }

   
  
    
}
