package com.lotr.hunt.actions;

import com.lotr.hunt.entities.Enemy;
import com.lotr.hunt.entities.Location;

/**
 * @author Konstantinos Tsigkounis
 * @date 03/05/2022
 */
public interface RandomGenerator {

    public void generateEncounter();

    public Enemy generateEnemy();

    public Location generateLocation();

    public void generateNumberOfSteps();

    public String pickUpAvailableMessage();

}
