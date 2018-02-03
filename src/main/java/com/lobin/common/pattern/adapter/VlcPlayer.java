package com.lobin.common.pattern.adapter;

public class VlcPlayer implements AdvanceMediaPlayer{
    @Override
    public void playVlc(String name) {
        System.out.println("vlc:"+name);
    }

    @Override
    public void playMp3(String name) {

    }
}
