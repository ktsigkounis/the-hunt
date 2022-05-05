package com.lotr.hunt.entities.location;

import com.lotr.hunt.entities.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Konstantinos Tsigkounis
 * @date 01/05/2022
 */

public class Forest extends Location {

    public static Map<String, Integer> forestMessages = new HashMap<>() {{
        put("Forest1",1);
        put("Forest2",1);
        put("Forest3",1);
        put("Forest4",1);
        put("Forest5",1);
        put("BattleForest1",1);
        put("BattleForest2",1);
    }};

    public Forest() {
        generateNumberOfSteps();
        setCurrentStep(0);
        setMessages(forestMessages);
    }

    @Override
    public void generateNumberOfSteps(){
        Random random = new Random();
        int steps = random.nextInt(5,10);
        setNumberOfSteps(steps);
    }
}
