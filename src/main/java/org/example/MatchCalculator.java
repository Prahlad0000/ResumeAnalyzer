package org.example;

import java.util.*;

public class MatchCalculator {

    static List<String> requiredSkills = Arrays.asList(
            "Java", "SQL", "HTML", "CSS", "JavaScript", "Spring"
    );

    public static int calculateMatch(List<String> userSkills) {

        int matchCount = 0;

        for (String skill : requiredSkills) {
            if (userSkills.contains(skill)) {
                matchCount++;
            }
        }

        return (matchCount * 100) / requiredSkills.size();
    }
}