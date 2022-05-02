package com.lotr.hunt.entities.weapon;

import com.lotr.hunt.entities.Weapon;
import com.lotr.hunt.util.WeaponType;

/**
 * @author Konstantinos Tsigkounis
 * @date 01/05/2022
 */

public class Dagger extends Weapon {

    public Dagger() {
        setAttack(10);
        setType(WeaponType.DAGGER.getName());
    }

}
