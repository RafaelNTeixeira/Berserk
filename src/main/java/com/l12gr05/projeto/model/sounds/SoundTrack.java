package com.l12gr05.projeto.model.sounds;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class SoundTrack {

    private Clip sound;

    public SoundTrack(String sound) {
        this.sound = loadSound(sound);
    }

    private Clip loadSound(String sound) throws NullPointerException {
        try {
            String path = new File(System.getProperty("user.dir")).getPath();
            File soundFile = new File(path+sound);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip soundClip = AudioSystem.getClip();
            soundClip.open(audioInputStream);
            FloatControl control = (FloatControl) soundClip.getControl(FloatControl.Type.MASTER_GAIN);
            control.setValue(-15.0f);

            return soundClip;
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public Clip getSound() {return sound;}

    public void setSound(Clip sound) {this.sound = sound;}

    public boolean isPlaying() {return sound.isRunning();}

    public void stop() {sound.stop();}

    public void play() {
        sound.setMicrosecondPosition(0);
        sound.start();
        sleep();
    }

    public void playLoop() {
        sound.setMicrosecondPosition(0);
        sound.start();
        sound.loop(Clip.LOOP_CONTINUOUSLY);
        sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(5);
        }
        catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
