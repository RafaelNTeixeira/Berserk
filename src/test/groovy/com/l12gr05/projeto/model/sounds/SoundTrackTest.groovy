package com.l12gr05.projeto.model.sounds


import spock.lang.Specification

import javax.sound.sampled.Clip
import javax.sound.sampled.FloatControl

class SoundTrackTest extends Specification{

    private def soundTrack
    private def clip

    def setup() {
        String path = "/src/main/resources/Sounds/soundTrack.wav"
        soundTrack = new SoundTrack(path)
        clip = Mock(Clip.class)
        soundTrack.setSound(clip)
    }

    def 'Create and load sound'(){
        given:
        String path = "/src/main/resources/Sounds/soundTrack.wav"
        soundTrack = new SoundTrack(path)

        when:
        FloatControl floatControl = soundTrack.getSound().getControl(FloatControl.Type.MASTER_GAIN)

        then:
        floatControl.getValue() == -15.0f
        soundTrack != null
    }

    def 'Is playing'() {
        given:
        boolean f1 = clip.isRunning()
        String path = "/src/main/resources/Sounds/soundTrack.wav"
        soundTrack = new SoundTrack(path)

        when:
        boolean f2 = soundTrack.isPlaying()
        soundTrack.play()
        boolean f3 = soundTrack.isPlaying()
        soundTrack.stop()

        then:
        f1 == f2
        f3
    }

    def 'Play'() {
        when:
        soundTrack.play()

        then:
        1*clip.setMicrosecondPosition(_)
        1*clip.start()
    }

    def 'Play Loop'() {
        when:
        soundTrack.playLoop()

        then:
        1*clip.setMicrosecondPosition(_)
        1*clip.start()
        1*clip.loop(Clip.LOOP_CONTINUOUSLY)
    }

    def 'Stop'(){
        when:
        soundTrack.stop()

        then:
        1*clip.stop()
    }

}
