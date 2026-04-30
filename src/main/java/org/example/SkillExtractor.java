package org.example;

import java.util.*;

public class SkillExtractor {

    static List<String> skillsList = Arrays.asList(
            "Java", "Python", "C++", "HTML", "CSS", "JavaScript",
            "SQL", "MySQL", "Spring", "Hibernate", "Machine Learning"
    );

    public static List<String> extractSkills(String text) {

        List<String> foundSkills = new ArrayList<>();

        for (String skill : skillsList) {
            if (text.toLowerCase().contains(skill.toLowerCase())) {
                foundSkills.add(skill);
            }
        }

        return foundSkills;
    }
}