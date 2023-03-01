package com.example.wordlepal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Word {

    //
    public ArrayList<String> wordle = new ArrayList<>();
    public ArrayList<String> deleteList = new ArrayList<>();

    //
    public static String greenCombo;
    public static String yellowCombo;
    public static String redCombo;

    //
    private char currentLetter;
    private char wordLetter;

    // green / top-row letters
    private String G1 = "";
    private String G2 = "";
    private String G3 = "";
    private String G4 = "";
    private String G5 = "";

    // yellow / mid-row letters
    private String Y1 = "";
    private String Y2 = "";
    private String Y3 = "";
    private String Y4 = "";
    private String Y5 = "";

    // gray / bottom-row letters
    private String R1 = "";
    private String R2 = "";
    private String R3 = "";
    private String R4 = "";
    private String R5 = "";

    public String getG3() {
        return G3;
    }

    public void setG3(String g3) {
        G3 = g3;
    }

    public String getG4() {
        return G4;
    }

    public void setG4(String g4) {
        G4 = g4;
    }

    public String getG5() {
        return G5;
    }

    public void setG5(String g5) {
        G5 = g5;
    }

    public String getY1() {
        return Y1;
    }

    public void setY1(String y1) {
        Y1 = y1;
    }

    public String getY2() {
        return Y2;
    }

    public void setY2(String y2) {
        Y2 = y2;
    }

    public String getY3() {
        return Y3;
    }

    public void setY3(String y3) {
        Y3 = y3;
    }

    public String getY4() {
        return Y4;
    }

    public void setY4(String y4) {
        Y4 = y4;
    }

    public String getY5() {
        return Y5;
    }

    public void setY5(String y5) {
        Y5 = y5;
    }

    public String getR1() {
        return R1;
    }

    public void setR1(String r1) {
        R1 = r1;
    }

    public String getR2() {
        return R2;
    }

    public void setR2(String r2) {
        R2 = r2;
    }

    public String getR3() {
        return R3;
    }

    public void setR3(String r3) {
        R3 = r3;
    }

    public String getR4() {
        return R4;
    }

    public void setR4(String r4) {
        R4 = r4;
    }

    public String getR5() {
        return R5;
    }

    public void setR5(String r5) {
        R5 = r5;
    }

    public String getG1() {
        return G1;
    }

    public void setG1(String g1) {
        G1 = g1;
    }

    public String getG2() {
        return G2;
    }

    public void setG2(String g2) {
        G2 = g2;
    }

    public void filterWords() {
        //Red word Iteration
        for (int w = 0; w < wordle.size(); w++) {//iterate for Arraylist

            //Red word Iteration
            for (int i = 0; i < redCombo.length(); i++) {//iterate for the red words listed
                currentLetter = Character.toUpperCase(redCombo.charAt(i));
                wordle.removeIf(e -> e.contains(String.valueOf(currentLetter)));
            }


            //Yellow word Iteration
            for (int i = 0; i < yellowCombo.length(); i++) {//for loop to iterate all the yellow words listed
                currentLetter = Character.toUpperCase(yellowCombo.charAt(i));
                wordle.removeIf(e -> !e.contains(String.valueOf(currentLetter)));
            }
        }
        //Green word Iteration
        for (int w = wordle.size() - 1; w >= 0; w--) {
            for (int i = 0; i < 4; i++) {//for loop to iterate all the green words listed
                currentLetter = Character.toUpperCase(greenCombo.charAt(i));
                wordLetter = wordle.get(w).charAt(i);
                if (!(currentLetter == ' ')) {//Logic to delete dead space
                    if (!(wordLetter == currentLetter)){
                        deleteList.add(wordle.get(w));
                    }
                }
            }
        }
        for (int w = deleteList.size() -1; w >= 0; w--){//Logic used to delete unwanted words after iterating through Worlde list
            int finalW = w;
            wordle.removeIf(e -> e.contains(deleteList.get(finalW)));
        }
    }

    public void scanIn() throws FileNotFoundException {

        // set the file import path
        String answer_path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\example\\wordlepal\\answers.txt";
        if ((System.getProperty("os.name").contains("Linux")) || (System.getProperty("os.name").contains("Mac"))) {
            answer_path = System.getProperty("user.dir") + "/src/main/java/com/example/wordlepal/answers.txt";
        }

        // read in the answers file
        Scanner s = new Scanner(new File(answer_path));
        while (s.hasNext()){
            wordle.add(s.next().strip().toUpperCase());
        }
        s.close();
    }

    private boolean validWord(String s) {

        // input word is not the right size (5 chars)
        if (s.length() != 5) { return false; }

        // input word contains non-letter characters
        for (char c : s.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<String> getWords() throws FileNotFoundException {

        // get a fresh answer list
        wordle = new ArrayList<>();
        scanIn();

        // filter stuff out
        filterWords();

        // return the filtered results
        return wordle;
    }

    public String getWord() {

        // make columns from input
        String col1 = G1.strip() + Y1.strip() + R1.strip();
        String col2 = G2.strip() + Y2.strip() + R2.strip();
        String col3 = G3.strip() + Y3.strip() + R3.strip();
        String col4 = G4.strip() + Y4.strip() + R4.strip();
        String col5 = G5.strip() + Y5.strip() + R5.strip();

        // make rows from input
        if (G1.strip() == "") { G1 = " "; }
        if (G2.strip() == "") { G2 = " "; }
        if (G3.strip() == "") { G3 = " "; }
        if (G4.strip() == "") { G4 = " "; }
        if (G5.strip() == "") { G5 = " "; }

        // CHANGE ME
        greenCombo = G1 + G2 + G3 + G4 + G5;
        yellowCombo = Y1.strip() + Y2.strip() + Y3.strip() + Y4.strip() + Y5.strip();
        redCombo = R1.strip() + R2.strip() + R3.strip() + R4.strip() + R5.strip();

        //
        String word = (col1 + col2 + col3 + col4 + col5).toUpperCase();
        if (word.length() == 0) {
            return word;
        } else if (validWord(word)) {
            // filter the ArrayList
            return word;
        } else  {
            return "Input word \'" + word + "\' is invalid.";
        }
    }
}
