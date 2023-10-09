package com.l12gr05.projeto;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.lang.Object.*;



public class Application {
    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        Game game = new Game();
        try {
            game.run();
        } catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
