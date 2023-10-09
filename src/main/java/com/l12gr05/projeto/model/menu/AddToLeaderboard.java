package com.l12gr05.projeto.model.menu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class AddToLeaderboard extends MenuManager{
    private PrintWriter out;
    private String name = new String();
    private final int Score;
    public AddToLeaderboard(int Score) throws IOException {
        super(Arrays.asList("menu", "leader board"));
        this.Score = Score;
        openOut();
    }

    void setOut(PrintWriter out_) {
        out = out_;
    }

    void openOut() {
        try {
            this.out = new PrintWriter(Files.newBufferedWriter(Paths.get("src/main/resources/Leaders"), UTF_8, CREATE, APPEND));
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }

    public void addChar(Character character) {
        name += character;
    }

    public void delChar() {
        name = name.substring(0, name.length()-1);
    }
    public void setName(String name) {this.name = name;}
    public String getName() {
        return name;
    }
    public int getScore() {return Score;}

    public boolean isSelectedMenu() {
        return isSelected(0);
    }
    public boolean isSelectedLeaderBoard() {
        return isSelected(1);
    }

    public void addScore() {
        addScore(out);
        closeScore(out);
    }

    private void closeScore(PrintWriter out) {
        if (out != null) {
            out.close();
        }
    }

    private void addScore(PrintWriter out) {
        if (name.isEmpty()){
            out.println("Noname;" + Score);
        }
        else {
            out.println( name + ";" + Score);
        }
    }
}
