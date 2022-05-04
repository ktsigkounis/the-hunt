package com.lotr.hunt.entities;

import com.lotr.hunt.entities.weapon.Dagger;

/**
 * @author Konstantinos Tsigkounis
 * @date 01/05/2022
 */

public class Hero extends Warrior {

    public Hero() {
        setMaxHpPoints(100);
        setHpPoints(100);
        setCoins(0);
        setWeapon(new Dagger());
    }

    @Override
    public void attack(Enemy enemy, Weapon weapon) {
        int enemyHP = enemy.getHpPoints();
        int weaponAttack = weapon.getAttack();
        enemy.setHpPoints(enemyHP - weaponAttack);
    }


}
