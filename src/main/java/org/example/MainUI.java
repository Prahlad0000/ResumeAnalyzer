package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.File;
import java.util.List;

public class MainUI extends Application {

    @Override
    public void start(Stage stage) {
        DatabaseHelper.createTable();

        Button uploadBtn = new Button("Upload Resume");

        TextArea outputArea = new TextArea();
        outputArea.setPrefHeight(200);

        Label scoreLabel = new Label("Match Score: ");
        Label scoreValue = new Label("0%");

        uploadBtn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(stage);

            if (file != null) {

                String text = PDFExtractor.extractText(file.getAbsolutePath());

                outputArea.setText(text);

                List<String> skills = SkillExtractor.extractSkills(text);

                int score = MatchCalculator.calculateMatch(skills);
                String skillsStr = String.join(", ", skills);
                DatabaseHelper.insertData(file.getName(), score, skillsStr);
                scoreValue.setText(score + "%");

                List<String> missing = SuggestionEngine.getMissingSkills(skills);

                outputArea.appendText("\n\n==== Missing Skills ====\n");
                for (String s : missing) {
                    outputArea.appendText(s + "\n");
                }
            }
        });

        HBox scoreBox = new HBox(10, scoreLabel, scoreValue);
        VBox root = new VBox(10, uploadBtn, scoreBox, outputArea);
        root.setStyle("-fx-background-color: #e3f2fd; -fx-padding: 20;");
        ProgressBar bar = new ProgressBar(0);


        root.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(root, 500, 400);
        stage.setTitle("Resume Analyzer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}