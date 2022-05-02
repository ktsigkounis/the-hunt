package com.lotr.hunt.entities.enemy;

import com.lotr.hunt.entities.Enemy;
import com.lotr.hunt.entities.weapon.Dagger;

/**
 * @author Konstantinos Tsigkounis
 * @date 01/05/2022
 */
public class Skeleton extends Enemy {

    public Skeleton() {
        setHpPoints(5);
        setWeapon(new Dagger());
    }
}
