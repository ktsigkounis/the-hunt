package com.lotr.hunt.game;

import com.lotr.hunt.entities.Encounter;
import com.lotr.hunt.entities.Hero;
import com.lotr.hunt.entities.Location;
import com.lotr.hunt.util.Info;
import com.lotr.hunt.util.PlayerAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Konstantinos Tsigkounis
 * @date 01/05/2022
 */

public class GameApp {

    private static boolean heroIsAlive;
    private static boolean hobbitsRescued;
    private static String userInput;

    public static void main(String[] args) {
        List<String> path = new ArrayList<>();
        Hero hero = new Hero();
        Encounter mainEncounter = new Encounter();

        System.out.println("\nWelcome to 'The Hunt'! This is a command-based game developed with Java 17.\n" +
                "Version: " + Info.VERSION + "\n" +
                "Created: " + Info.CREATED_DATE + "\n\n" +
                "Your main task is to search and rescue Merry and Pippin before the horde of Orcs reach Isengard.\n" +
                "You can control your decisions through command choices.\n\n" +
                "Your initial carrying are:\n" +
                "Weapon: " + hero.getWeapon().getType() + "\n" +
                "Health points: " + hero.getHpPoints() + "\n" +
                "Coins: " + hero.getCoins() + "\n");

        boolean gameJustStarted = false;
        heroIsAlive = true;
        hobbitsRescued = true; // TODO: Correct this to FALSE in the very start.

        while (isHuntAlive()) {
            if (PlayerAction.EXIT.getCommand().equals(userInput)) {
                break;
            }
            if (PlayerAction.ATTACK.getCommand().equals(userInput)) {
                //How to get the previous Enemy ???? Maybe 'Battle' is a nested loop inside the main loop.
            }
            System.out.println("\nHere will be the main gameplay code...");
            System.out.println("...");
            System.out.println("...\n");

            if (path.size() == 0) {
                gameJustStarted = true;
                System.out.println("This is the first message"); //TODO: Change this obviously
            }

            //Here generate encounter
            //If game just started the first encounter is location
            if (gameJustStarted) {
                Location location = mainEncounter.generateLocation();
                int stepsInLocation = location.getNumberOfSteps(); // maybe use this in a loop ?
                gameJustStarted = false;
                String message = location.pickUpAvailableMessage();
                System.out.println("This is the messaged I found");
                System.out.println(message);
            } else {
                //todo
            }

            //add last message to path in order to create a sequence of the hero's path
            path.add("Last message after");


            // Here will be the choices and actions of the user
            System.out.println("-------------------- Choose wisely --------------------");
            System.out.println("-- 1. Choice 1");
            System.out.println("-- 2. Choice 2");
            System.out.println("\n");
            System.out.println("-------------------- Actions --------------------");
            System.out.println("-- 1. Press 'I' to see your hero's information.");
            System.out.println("-- 2. Press 'E' to exit.");

            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextLine();
        }

        System.out.println("Your adventure ends here!\n");
        if (!heroIsAlive) {
            System.out.println("You are dead.");
        } else if (PlayerAction.EXIT.getCommand().equals(userInput)) {
            System.out.println("You chose to abandon the poor hobbits and smoke leaf at Prancing Pony!");
        } else if (hobbitsRescued) {
            System.out.println("Merry and Pippin are in safe hands now. You are a true Middle Earth hero! Next quest is to destroy the Ring of Power");
        }

    }

    public static boolean isHuntAlive() {
        return heroIsAlive && !hobbitsRescued && !PlayerAction.EXIT.getCommand().equals(userInput);
    }
}
