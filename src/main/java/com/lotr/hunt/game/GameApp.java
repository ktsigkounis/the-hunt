package com.lotr.hunt.game;

import com.lotr.hunt.entities.Hero;
import com.lotr.hunt.util.PlayerAction;
import com.lotr.hunt.util.Info;

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
    private static List<String> path;
    private static String userInput;

    public static void main(String[] args) {
        path = new ArrayList<>();
        Hero hero = new Hero();

        System.out.println("\nWelcome to 'The Hunt'! This is a command-based game developed with Java 17.\n" +
                "Version: " + Info.VERSION + "\n" +
                "Created: " + Info.CREATED_DATE + "\n\n" +
                "Your main task is to search and rescue Merry and Pippin before the horde of Orcs reach Isengard.\n" +
                "You can control your decisions through command choices.\n\n" +
                "Your initial carrying are:\n" +
                "Weapon: " + hero.getWeapon().getType() +"\n" +
                "Health points: " + hero.getHpPoints() +"\n" +
                "Coins: " + hero.getCoins() +"\n");


        do {
            System.out.println("\nHere will be the main gameplay code...");
            System.out.println("...");
            System.out.println("...\n");
            heroIsAlive = true;
            hobbitsRescued = true;


            System.out.println("-------------------- Choose wisely --------------------");
            System.out.println("-- 1. Choice 1");
            System.out.println("-- 2. Choice 2");
            System.out.println("\n");
            System.out.println("-------------------- Actions --------------------");
            System.out.println("-- 1. Press 'I' to see your hero's information.");
            System.out.println("-- 2. Press 'E' to exit.");

            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextLine();

        } while (isHuntAlive());

        System.out.println("Your adventure ends here!\n");
        if (!heroIsAlive) {
            System.out.println("You are dead.");
        }
        else if (PlayerAction.EXIT.getCommand().equals(userInput)) {
            System.out.println("You chose to abandon the poor hobbits and smoke leaf at Prancing Pony!");
        }
        else if (hobbitsRescued) {
            System.out.println("Merry and Pippin are in safe hands now. You are a true Middle Earth hero! Next quest is to destroy the Ring of Power");
        }

    }

    public static boolean isHuntAlive() {
        return heroIsAlive && !hobbitsRescued && !"E".equals(userInput);
    }
}
