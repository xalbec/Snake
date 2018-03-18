package main.java.com.xalbec.snake;

import processing.core.PApplet;

public class Main extends PApplet {


    static final int scale = 20;
    static final int width = 500;
    static final int height = 500;

    //creates a Snake
    Snake snake = new Snake(this,0,0,scale);
    //Creates a piece of Food
    Food food = new Food(this, scale);

    public static void main(String[] args){

        PApplet.main(new String[] {Main.class.getName()});

    }

    public void setup(){

        frameRate(10);

    }

    public void settings(){

        size(width, height);

    }

    public void draw(){

        background(0);

        snake.display();
        snake.update();

        food.display();

        snake.eat(food);

    }

    public void keyPressed(){

        if(keyCode == UP){
            snake.changeDir('u');
        }
        if (keyCode == DOWN){
            snake.changeDir('d');
        }
        if(keyCode == LEFT){
            snake.changeDir('l');
        }
        if(keyCode == RIGHT){
            snake.changeDir('r');
        }

    }


}
