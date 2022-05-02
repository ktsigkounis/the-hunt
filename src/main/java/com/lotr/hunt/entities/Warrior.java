package com.lotr.hunt.entities;

import com.lotr.hunt.actions.Action;

/**
 * @author Konstantinos Tsigkounis
 * @date 02/05/2022
 */
public class Warrior implements Action {

    @Override
    public void attack(Enemy enemy, Weapon weapon) {
        int enemyHP = enemy.getHpPoints();
        int weaponAttack = weapon.getAttack();
        enemy.setHpPoints(enemyHP - weaponAttack);
    }

    @Override
    public void attack(Hero hero, Weapon weapon) {
        int heroHP = hero.getHpPoints();
        int weaponAttack = weapon.getAttack();
        hero.setHpPoints(heroHP - weaponAttack);
    }

    @Override
    public void drinkPotion(Hero hero) {
        int heroHP = hero.getHpPoints();
        hero.setHpPoints(heroHP + 10);
    }
}
