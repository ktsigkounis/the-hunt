package com.lotr.hunt.util;

/**
 * @author Konstantinos Tsigkounis
 * @date 01/05/2022
 */
public enum WeaponType {
    DAGGER(1, "Dagger"),
    SWORD(2, "Sword");

    WeaponType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected int id;
    protected String name;

}
