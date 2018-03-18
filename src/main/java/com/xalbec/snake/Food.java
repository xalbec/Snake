package main.java.com.xalbec.snake;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.Random;

public class Food {

    PApplet parent;

    int scale = 20;
    PVector pos = new PVector(0,0);

    public Food(PApplet parent){

        this.parent = parent;
        setPos();

    }

    public Food(PApplet parent, int scale){

        this(parent);
        this.scale = scale;
        setPos();

    }

    public void display(){

        parent.fill(255, 0, 0);
        parent.rect(pos.x, pos.y, scale, scale);

    }

    public void setPos(){

        Random r = new Random();

        pos.x = r.nextInt((parent.width-scale)/scale) * scale;
        pos.y = r.nextInt((parent.height-scale)/scale) * scale;

    }


}
