package com.lotr.hunt.entities;

import com.lotr.hunt.actions.Action;
import com.lotr.hunt.entities.weapon.Dagger;

/**
 * @author Konstantinos Tsigkounis
 * @date 01/05/2022
 */

public class Hero extends Warrior {

    private int hpPoints;
    private int potions;
    private int coins;
    private Weapon weapon;

    public Hero() {
        this.hpPoints = 100;
        this.coins = 0;
        this.weapon = new Dagger();
    }

    public int getHpPoints() {
        return hpPoints;
    }

    public void setHpPoints(int hpPoints) {
        this.hpPoints = hpPoints;
    }

    public int getPotions() {
        return potions;
    }

    public void setPotions(int potions) {
        this.potions = potions;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void attack(Enemy enemy, Weapon weapon){
        int enemyHP = enemy.getHpPoints();
        int weaponAttack = weapon.getAttack();
        enemy.setHpPoints(enemyHP - weaponAttack);
    }



}
