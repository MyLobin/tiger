package com.lobin.common.pattern.adapter;

public class Mp3Player implements AdvanceMediaPlayer {
    @Override
    public void playVlc(String name) {

    }

    @Override
    public void playMp3(String name) {
        System.out.println("mp3:" + name);
    }
}
