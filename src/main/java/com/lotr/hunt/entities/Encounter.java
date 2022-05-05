package com.lotr.hunt.entities;

import com.lotr.hunt.actions.RandomGenerator;
import com.lotr.hunt.entities.location.Forest;
import com.lotr.hunt.entities.location.Plain;

import java.util.Map;

/**
 * @author Konstantinos TsigkounisΟΛ
 * @date 03/05/2022
 */
public class Encounter implements RandomGenerator {

    private Map<String, Integer> messages;
    private boolean forestAvailable;
    private boolean plainAvailable;
    private boolean tombsAvailable;

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    private Location currentLocation;


    public Encounter() {
        setForestAvailable(true);
        setPlainAvailable(true);
    }

    public Map<String, Integer> getMessages() {
        return messages;
    }

    public void setMessages(Map<String, Integer> messages) {
        this.messages = messages;
    }

    public boolean isTombsAvailable() {
        return tombsAvailable;
    }

    public void setTombsAvailable(boolean tombsAvailable) {
        this.tombsAvailable = tombsAvailable;
    }

    @Override
    public void generateEncounter() {
    }

    @Override
    public Enemy generateEnemy() {
        return null;
    }

    @Override
    public Location generateLocation() {
        if (isForestAvailable()) {
            setForestAvailable(false);
            return new Forest();
        }
        else {
            setPlainAvailable(false);
            return new Plain();
        }
    }

    @Override
    public void generateNumberOfSteps() {
    }

    @Override
    public String pickUpAvailableMessage() {
        Map<String, Integer> allMessages = getMessages();
        for (String s : allMessages.keySet()) {
            return s;
        }
        return null;
    }

    public boolean isForestAvailable() {
        return forestAvailable;
    }

    public void setForestAvailable(boolean forestAvailable) {
        this.forestAvailable = forestAvailable;
    }

    public boolean isPlainAvailable() {
        return plainAvailable;
    }

    public void setPlainAvailable(boolean plainAvailable) {
        this.plainAvailable = plainAvailable;
    }
}
