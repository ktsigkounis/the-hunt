package com.lotr.hunt.entities;

/**
 * @author Konstantinos Tsigkounis
 * @date 01/05/2022
 */
public class Weapon {

    private int attack;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

}
