package com.lotr.hunt.entities;

/**
 * @author Konstantinos Tsigkounis
 * @date 01/05/2022
 */

public class Location extends Encounter {

    public int getNumberOfSteps() {
        return numberOfSteps;
    }

    public void setNumberOfSteps(int numberOfSteps) {
        this.numberOfSteps = numberOfSteps;
    }

    private int numberOfSteps;

    public int getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(int currentStep) {
        this.currentStep = currentStep;
    }

    private int currentStep;
}
