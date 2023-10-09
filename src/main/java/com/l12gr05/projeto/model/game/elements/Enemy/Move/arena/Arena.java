package com.l12gr05.projeto.model.game.elements.Enemy.Move.arena;

import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.game.elements.Bullet;
import com.l12gr05.projeto.model.game.elements.Enemy.Boss;
import com.l12gr05.projeto.model.game.elements.Enemy.King;
import com.l12gr05.projeto.model.game.elements.Enemy.Monster;
import com.l12gr05.projeto.model.game.elements.Health;
import com.l12gr05.projeto.model.game.elements.Hero;
import com.l12gr05.projeto.model.game.elements.Wall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Arena {
    private final int height;
    private final int width;

    private final int level;
    private Hero hero;

    private final List<Wall> walls = new ArrayList<>();
    private List<Monster> monsters = new ArrayList<>();
    private final List<King> kings = new ArrayList<>();
    private List<Bullet> bullets = new ArrayList<>();
    private List<Health> health = new ArrayList<>();
    private Boss boss;
    private int score;
    private final boolean[][] matrixOfWalls = new boolean[35][27];
    public Arena(int x, int y, int lvl) {
        width = x;
        height = y;
        level = lvl;
        createElements();
    }


    public boolean hasWalls(int x, int y) {
        if (x < 0 || y < 0 || x > 33 || y > 24) {
            return true;
        }
        return matrixOfWalls[x][y];
    }

    private void createElements() {
        StringBuilder str = new StringBuilder();
        str.append("level");
        str.append(level);
        str.append(".txt");
        String arenaPath = str.toString();

        InputStream istream = ClassLoader.getSystemResourceAsStream(arenaPath);
        InputStreamReader istreamreader = new InputStreamReader(istream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(istreamreader);
        try {
            int i = 0;
            for (String line; (line = reader.readLine()) != null; i++) {

                readMap(i, line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void readMap(int i, String line) {
        int j = 0;
        for (char c: line.toCharArray()) {
            switch (c){
                case'h': hero = new Hero(j,i); break;
                case'm': monsters.add(new Monster(j, i)); break;
                case'k': kings.add(new King(j, i)); break;
                case'w': walls.add(new Wall(j, i)); matrixOfWalls[j][i] = true; break;
                case'f': boss = new Boss(j,i); break;
                case'J': health.add(new Health(j,i)); break;
            }
            j++;
        }
    }

    public void spawnMonster() {
        monsters.add(new Monster(5,5));
        monsters.add(new Monster(20,20));
    }
    public void eraseBullet(int index) {
        if (index < bullets.size()) {
            bullets.remove(index);
        }
    }
    public void eraseMonster(int index) {
        if (index < monsters.size()) {
            monsters.remove(index);
        }
    }
    public void eraseKing(int index) {
        if (index < kings.size()) {
            kings.remove(index);
        }
    }
    public void eraseHealth(int index) {
        if (index < health.size()) {
            health.remove(index);
        }
    }


    public boolean notContainsWall(Position position, char dir){
        int x = position.getX();
        int y = position.getY();
        if(x < 0 || y < 0 ||x > 34 || y > 24){
            return false;
        }
        switch (dir){
            case'r':
                while(x < hero.getX()){
                    if(matrixOfWalls[x][y]){
                        return false;
                    }
                    x++;
                }
                break;
            case'l':
                while(x > hero.getX()){
                    if(matrixOfWalls[x][y]){
                        return false;
                    }
                    x--;
                }
                break;
            case'u':
                while(y > hero.getY()){
                    if(matrixOfWalls[x][y]){
                        return false;
                    }
                    y--;
                }
                break;
            case'd':
                while(y < hero.getY()){
                    if(matrixOfWalls[x][y]){
                        return false;
                    }
                    y++;
                }
                break;
        }
        return !matrixOfWalls[x][y];
    }

    public void shoot(char dir, Position position, boolean hero){
        int x = position.getX();
        int y = position.getY();

        switch (dir){
            case 'r':
                boolean notContainsWall = notContainsWall(new Position(x + 1, y), dir);
                if (notContainsWall) {
                    bullets.add(new Bullet(x + 1, y, dir ,hero));
                }
                break;
            case 'l':
                boolean notContainsWall1 = notContainsWall(new Position(x - 1, y), dir);
                if (notContainsWall1) {
                    bullets.add(new Bullet(x - 1, y, dir, hero));
                }
                break;
            case 'd':
                boolean notContainsWall2 = notContainsWall(new Position(x , y + 1), dir);
                if (notContainsWall2) {
                    bullets.add(new Bullet(x , y + 1, dir, hero));
                }
                break;
            case 'u':
                boolean notContainsWall3 = notContainsWall(new Position(x , y - 1), dir);
                if (notContainsWall3) {
                    bullets.add(new Bullet( x , y - 1, dir, hero));
                }
                break;
            case 'q':
                bullets.add(new Bullet(x -1  , y - 1, dir, hero));
                break;
            case 't':
                bullets.add(new Bullet(x + 1,y-1, dir, hero));
                break;
            case 'a':
                bullets.add(new Bullet(x - 1, y + 1, dir, hero));
                break;
            case 'z':
                bullets.add(new Bullet(x + 1, y + 1, dir, hero));
                break;
        }
    }

    public int getLevel(){
        return level;
    }
    public Hero getHero(){
        return hero;
    }
    public Boss getBoss() {return boss;}
    public List<Wall> getWalls(){
        return walls;
    }
    public List<Health> getHealth(){
        return health;
    }
    public List<Monster> getMonsters(){
        return monsters;
    }
    public List<King> getKings(){
        return kings;
    }
    public List<Bullet> getBullets(){
        return bullets;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public int getScore() {
        return score;
    }
    public boolean[][] getMatrixOfWalls(){
        return matrixOfWalls;
    }
    public void setScore(int score) {
        this.score = score;

    }
    public void setMonsters(List<Monster> m){
        monsters = m;
    }
    public void setBullets(List<Bullet> bullet_l) {bullets = bullet_l;}
    public void setHealth(List<Health> health_l) {health = health_l;}
}
