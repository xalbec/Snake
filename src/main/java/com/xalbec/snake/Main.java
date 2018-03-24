package main.java.com.xalbec.snake;

import processing.core.PApplet;

public class Main extends PApplet {


    static final int scale = 20;
    static final int width = 500;
    static final int height = 500;

    public enum CurrentScene{
        MAINMENU,SNAKEGAMESCENE,GAMEOVER
    }

    //creates a Snake
    Snake snake = new Snake(this,0,0,scale);
    //Creates a piece of Food
    Food food = new Food(this, scale);
    //keeps track of what current scene should be displayed
    CurrentScene scene = CurrentScene.SNAKEGAMESCENE;


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

        switch (scene){
            case MAINMENU:
                mainMenuScene();
                break;
            case SNAKEGAMESCENE:
                snakeGameScene();
                break;
            case GAMEOVER:
                gameOverScene();
                break;
        }

    }

    public void keyPressed(){

        switch (scene){
            case SNAKEGAMESCENE:
                snakeGameSceneControls();
                break;
        }

    }

    //////////////////////////////////////////////////////////////////////

    public void mainMenuScene(){
        background(0);
        fill(255);
        textSize(50);
        text("Snekkity Snek", 100, 100);
        textSize(20);
        text("by Xalbec", 150, 150);
    }

    public void mainMenuSceneControls(){

    }

    public void gameOverScene(){
        background(0);
        fill(255);
        textSize(40);
        text("GameOver!", 100, 150);
    }

    public void gameOverSceneControls(){

    }

    public void snakeGameScene(){

        background(0);

        snake.display();
        snake.update();

        if(snake.isTailCollision()){
            scene = CurrentScene.GAMEOVER;
        }

        food.display();

        snake.eat(food);

    }

    public void snakeGameSceneControls(){

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


