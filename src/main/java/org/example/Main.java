package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Step 1: Extract text from PDF
        String text = PDFExtractor.extractText("resume.pdf");

        System.out.println("===== RESUME TEXT =====");
        System.out.println(text);

        // Step 2: Extract skills
        System.out.println("\n===== SKILLS FOUND =====");
        List<String> skills = SkillExtractor.extractSkills(text);

        for (String skill : skills) {
            System.out.println(skill);
        }

        // Step 3: Calculate match score
        int score = MatchCalculator.calculateMatch(skills);

        System.out.println("\n===== MATCH SCORE =====");
        System.out.println("\n===== MISSING SKILLS =====");

        List<String> missing = SuggestionEngine.getMissingSkills(skills);

        for (String skill : missing) {
            System.out.println(skill);
        }
        System.out.println(score + "%");
    }
}