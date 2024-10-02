package org.example;

import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class EasyGame extends Game{
    private int pickedNumber;
    private int max = 10;
    private int min = 1;
    private int range = max - min + 1;
    private int winner, randomNumber;
    private boolean gameOver = false;
    @Override
    public void initializeGame(int numberOfPlayers) {
        System.out.println("*******Welcome to the game!*********");
        System.out.println("The first person to guess the correct number betweem 1 and 10 wins.");
        randomNumber = (int)(Math.random()*range)+min;
    }

    @Override
    public boolean endOfGame() {
        return gameOver;
    }

    @Override
    public void playSingleTurn(int player) {
        System.out.println("Pick a number between 1 and 10!");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            if(Integer.parseInt(input) < 1 || Integer.parseInt(input) > 10){
                System.out.println("Select a number between 1 and 10!");
            }
            pickedNumber = Integer.parseInt(input);
            if(pickedNumber == randomNumber){
                gameOver = true;
                winner = player;
            }
        } catch (NumberFormatException e){
            e.printStackTrace();
        }

    }

    @Override
    public void displayWinner() {
        System.out.print("The winner is player number : " + winner + "! They guessed the correct number, which" +
                "was :" + randomNumber);
    }
}
