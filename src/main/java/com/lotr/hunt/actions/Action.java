package com.lotr.hunt.actions;

import com.lotr.hunt.entities.Enemy;
import com.lotr.hunt.entities.Hero;
import com.lotr.hunt.entities.Weapon;

/**
 * @author Konstantinos Tsigkounis
 * @date 01/05/2022
 */
public interface Action {

    public void attack(Enemy enemy, Weapon weapon);

    public void attack(Hero hero, Weapon weapon);

    public void drinkPotion(Hero hero);

    public int rollDice();

}
