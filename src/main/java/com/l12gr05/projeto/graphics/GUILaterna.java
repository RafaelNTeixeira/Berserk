package com.l12gr05.projeto.graphics;

import com.l12gr05.projeto.model.game.Position;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;


public class GUILaterna implements GUI {
    private final Screen screen;
    Set<Integer> pressedKeys = new HashSet<>();
    public GUILaterna(Screen screen) {
        this.screen = screen;
    }

    public GUILaterna(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        Screen screen_ = createScreen(terminal);
        this.screen = screen_;
    }


    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height+1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        ((AWTTerminalFrame)terminal).getComponent(0).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pressedKeys.add(e.getButton());
            }
        });
        return terminal;
    }

    private AWTTerminalFontConfiguration loadFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font loadedFont = font.deriveFont(Font.PLAIN, 20);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    @Override
    public void drawHero(Position position) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.enableModifiers(SGR.BOLD);
        int xPosition = position.getX();
        int yPosition = position.getY();
        graphics.putString(new TerminalPosition(xPosition, yPosition), "X");
    }

    @Override
    public void drawHeart(Position position) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.enableModifiers(SGR.BORDERED);
        int x = position.getX();
        int y = position.getY();
        graphics.putString(new TerminalPosition(x,y),"J");
    }

    @Override
    public void drawHeartBoss(Position position) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString("#608482"));
        graphics.enableModifiers(SGR.BORDERED);
        int x = position.getX();
        int y = position.getY();
        graphics.putString(new TerminalPosition(x,y),"J");
    }

    @Override
    public void drawWall(Position position) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#484857"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#484857"));
        graphics.enableModifiers(SGR.BOLD);
        int x = position.getX();
        int y = position.getY();
        graphics.putString(new TerminalPosition(x, y), "w");
    }

    @Override
    public void drawMonster(Position position) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString("#D31717"));
        graphics.enableModifiers(SGR.BORDERED);
        int x = position.getX();
        int y = position.getY();
        graphics.putString(new TerminalPosition(x,y),"M");
    }

    @Override
    public void drawKing(Position position) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString("#EFC320"));
        graphics.enableModifiers(SGR.BORDERED);
        int x = position.getX();
        int y = position.getY();
        graphics.putString(new TerminalPosition(x,y),"K");
    }

    @Override
    public void drawBoss(Position position) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString("#ADABAC"));
        graphics.enableModifiers(SGR.BORDERED);
        int x = position.getX();
        int y = position.getY();
        graphics.putString(x,y,"F");
        graphics.putString(x - 1,y - 1,"A");
        graphics.putString(x,y - 1,"C");
        graphics.putString(x + 1,y - 1,"D");
        graphics.putString(x - 1,y,"E");
        graphics.putString(x + 1,y,"G");
        graphics.putString(x - 1 ,y+1,"H");
        graphics.putString(x,y+1,"I");
        graphics.putString(x+1,y+1,"L");
    }

    @Override
    public void drawHeroBullet(Position position) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString("#008000"));
        graphics.enableModifiers(SGR.BORDERED);
        int x = position.getX();
        int y = position.getY();
        graphics.putString(new TerminalPosition(x,y),"B");
    }

    @Override
    public void drawEnemyBullet(Position position) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString("#B22222"));
        graphics.enableModifiers(SGR.BORDERED);
        int x = position.getX();
        int y = position.getY();
        graphics.putString(new TerminalPosition(x,y),"O");
    }


    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        int x = position.getX();
        int y = position.getY();
        tg.putString(x, y, text);
    }

    @Override
    public void clear() {
        screen.clear();
    }
    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }
    @Override
    public void close() throws IOException {
        screen.close();
    }


    public Screen getScreen() {return screen;}

    @Override
    public KeyStroke getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) {
            if (pressedKeys.contains(1)) {
                pressedKeys.remove(1);
                return new KeyStroke(KeyType.ArrowLeft);
            }
            if (pressedKeys.contains(3)) {
                pressedKeys.remove(3);
                return new KeyStroke(KeyType.ArrowRight);
            }
            if (pressedKeys.contains(5)) {
                pressedKeys.remove(5);
                return new KeyStroke(KeyType.ArrowUp);
            }
            if (pressedKeys.contains(4)) {
                pressedKeys.remove(4);
                return new KeyStroke(KeyType.ArrowDown);
            }
        }
        return keyStroke;
    }

    public void setPressedKeys(Set<Integer> set) {
        pressedKeys = set;
    }
}
