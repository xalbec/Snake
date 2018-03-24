package main.java.com.xalbec.snake;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Snake {

    PApplet parent;

    int scale = 20;
    int score = 0;
    //position
    PVector pos = new PVector(0,0);
    //velocity
    PVector vel = new PVector(1,0);

    ArrayList<PVector> bodies = new ArrayList<>();



    public Snake(PApplet parent){

        this.parent = parent;

    }

    public Snake(PApplet parent, int x, int y, int scale){

        this(parent);
        pos.x = x;
        pos.y = y;
        this.scale = scale;

    }

    public void display(){

        parent.fill(255);
        for(int i = 0; i < score; i++){
            parent.rect(bodies.get(i).x, bodies.get(i).y, scale, scale);
        }

        parent.rect(pos.x, pos.y, scale, scale);

    }

    public void update(){

        if(score > 0){
            for(int i = 0; i < score -1; i++){
                bodies.set(i, bodies.get(i+1));
            }
            bodies.set(score -1, pos.copy());
        }

        pos.x += vel.x * scale;
        pos.y += vel.y * scale;

        this.checkWallCollision();

    }

    public void checkWallCollision(){

        if(pos.x < 0){
            pos.x = 0;
        }
        if(pos.x > parent.width - scale){
            pos.x = parent.width - scale;
        }
        if(pos.y < 0){
            pos.y = 0;
        }
        if(pos.y > parent.height - scale){
            pos.y = parent.height - scale;
        }


    }

    public boolean isTailCollision(){

        for(PVector bod : bodies){
            if(this.pos.equals(bod)){
                return true;
            }
        }
        return false;

    }

    public void changeDir(char dir){

        switch(dir){
            case 'u':
                vel.x = 0;
                vel.y = -1;
                break;
            case 'd':
                vel.x = 0;
                vel.y = 1;
                break;
            case 'l':
                vel.x = -1;
                vel.y = 0;
                break;
            case 'r':
                vel.x = 1;
                vel.y = 0;
                break;
        }

    }

    public void eat(Food food){

        if(food.pos.x == pos.x && food.pos.y == pos.y){
            food.setPos();
            bodies.add(pos.copy());
            score++;
        }

    }

    public PVector getPos() {
        return pos.copy();
    }
    public void setPos(PVector pos) {
        this.pos = pos;
    }

}
