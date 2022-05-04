package com.lotr.hunt.entities.enemy;

import com.lotr.hunt.entities.Enemy;
import com.lotr.hunt.entities.weapon.Sword;

/**
 * @author Konstantinos Tsigkounis
 * @date 01/05/2022
 */
public class Orc extends Enemy {

    public Orc() {
        setMaxHpPoints(20);
        setHpPoints(20);
        setWeapon(new Sword());
    }

}
