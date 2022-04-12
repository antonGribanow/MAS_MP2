package com.company;

import java.io.Serializable;
import java.util.*;

public class Test implements Serializable {
    public final UUID id;
    public final String testType;
    public final List<String> preparationToTest;
    public final int cost;

    public Test(String testType, List<String> preparationToTest, int cost) {
        this.id = UUID.randomUUID();
        this.testType = testType;
        this.preparationToTest = preparationToTest;
        this.cost = cost;
    }

    public void updatePreparationToTest(String oldPreparation, String newPreparation) { // przeciążenie
        Collections.replaceAll(preparationToTest, oldPreparation, newPreparation);
    }

    public void updatePreparationToTest(String newPreparation) { // przeciążenie
        preparationToTest.add(newPreparation);
    }

    @Override
    public String toString() {
        return "Test: " +
                "test id: " + id +
                ", testType: " + testType +
                ", preparationToTest: " + preparationToTest +
                ", cost: " + cost;
    }
}
