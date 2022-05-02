package com.lotr.hunt.entities;

/**
 * @author Konstantinos Tsigkounis
 * @date 01/05/2022
 */

public class Enemy extends Warrior {

    private int hpPoints;

    public int getHpPoints() {
        return hpPoints;
    }

    public void setHpPoints(int hpPoints) {
        this.hpPoints = hpPoints;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    private Weapon weapon;

}
