package org.example;

import java.util.*;

public class SuggestionEngine {

    public static List<String> getMissingSkills(List<String> userSkills) {

        List<String> requiredSkills = MatchCalculator.requiredSkills;
        List<String> missingSkills = new ArrayList<>();

        for (String skill : requiredSkills) {
            if (!userSkills.contains(skill)) {
                missingSkills.add(skill);
            }
        }

        return missingSkills;
    }
}