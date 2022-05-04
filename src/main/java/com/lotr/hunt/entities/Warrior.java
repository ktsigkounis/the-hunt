package com.lotr.hunt.entities;

import com.lotr.hunt.actions.Action;

/**
 * @author Konstantinos Tsigkounis
 * @date 02/05/2022
 */
public class Warrior implements Action {

    private int maxHpPoints;
    private int hpPoints;
    private int potions;
    private int coins;
    private Weapon weapon;

    public int getMaxHpPoints() {
        return maxHpPoints;
    }

    public void setMaxHpPoints(int maxHpPoints) {
        this.maxHpPoints = maxHpPoints;
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
