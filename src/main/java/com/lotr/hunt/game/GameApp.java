package com.lotr.hunt.game;

import com.lotr.hunt.entities.Encounter;
import com.lotr.hunt.entities.Enemy;
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
        List<String> roadmap = new ArrayList<>(); //In this list we keep all messages (location) in order the user can go forth/back
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

            if (roadmap.size() == 0) {
                gameJustStarted = true;
                System.out.println("This is the first message"); //TODO: Change this obviously
            }

            //Here generate encounter
            //If game just started the first encounter is location
            if (gameJustStarted) {
                Location newLocation = mainEncounter.generateLocation();
                mainEncounter.setCurrentLocation(newLocation);
                //int stepsInLocation = newLocation.getNumberOfSteps(); // maybe use this in a loop ?
                gameJustStarted = false;
                String message = newLocation.pickUpAvailableMessage();
                System.out.println("This is the messaged I found");
                System.out.println(message);
                roadmap.add(message);
            } else {
                Location currentLocation = mainEncounter.getCurrentLocation();
                if (currentLocation.getCurrentStep() == currentLocation.getNumberOfSteps()) {
                    currentLocation = mainEncounter.generateLocation();
                }
                String message = currentLocation.pickUpAvailableMessage();
                System.out.println("This is the messaged I found");
                System.out.println(message);

                boolean isBattle = message.contains("something");

                if (isBattle) {
                    //Random Initialize battle => Actions A, D, I, E
                    Enemy enemy = mainEncounter.generateEnemy();
                    int enemyHP = enemy.getHpPoints();
                    int heroHP = hero.getHpPoints();
                    System.out.println("Enemy rolled dice and the dice said: " + enemy.rollDice());
                    boolean heroPlaysFirst = hero.rollDice() >= enemy.rollDice();
                    String userBattleInput;

                    System.out.println(message);
                    System.out.println("-------------------- Actions --------------------");
                    System.out.println("-- 1. Press 'A' to attack the enemy");
                    System.out.println("-- 2. Press 'D' to drink potion and heal.");
                    System.out.println("-- 3. Press 'I' to see your hero's information.");
                    System.out.println("-- 4. Press 'E' to exit game.");

                    // Actions A, D, I, E
                    Scanner scanner = new Scanner(System.in);
                    userBattleInput = scanner.nextLine();

                    while (enemyHP > 0 || heroHP > 0) {

                        if (PlayerAction.ATTACK.getCommand().equals(userBattleInput)) {
                            //FIGHT!!!!
                            if (heroPlaysFirst) {
                                hero.attack(enemy, hero.getWeapon());
                                enemyHP = enemy.getHpPoints();
                                heroPlaysFirst = false;
                            } else {
                                enemy.attack(hero, enemy.getWeapon());
                                heroHP = hero.getHpPoints();
                                heroPlaysFirst = true;
                            }
                        }
                        else if (PlayerAction.DRINK_POTION.getCommand().equals(userBattleInput)) {
                            hero.drinkPotion(hero);
                        }
                        System.out.println("-------------------- Actions --------------------");
                        System.out.println("-- 1. Press 'A' to attack the enemy");
                        System.out.println("-- 2. Press 'D' to drink potion and heal.");
                        System.out.println("-- 3. Press 'I' to see your hero's information.");
                        System.out.println("-- 4. Press 'E' to exit game.");

                        // Actions A, D, I, E
                        //Scanner scanner = new Scanner(System.in);
                        userBattleInput = scanner.nextLine();
                    }
                    if (heroHP <= 0) {
                        heroIsAlive = false;
                        break;
                    }
                } else {
                    roadmap.add(message);
                }
            }


            // Here will be the choices and actions of the user
            System.out.println("-------------------- Choose wisely --------------------");
            System.out.println("-- 1. Choice 1");
            System.out.println("-- 2. Choice 2");
            System.out.println("\n");
            System.out.println("-------------------- Actions --------------------");
            System.out.println("-- 1. Press 'MF' to move forward");
            System.out.println("-- 2. Press 'MB' to move back.");
            System.out.println("-- 3. Press 'I' to see your hero's information.");
            System.out.println("-- 4. Press 'E' to exit game.");

            // Actions MF, MB, S, I, E
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
