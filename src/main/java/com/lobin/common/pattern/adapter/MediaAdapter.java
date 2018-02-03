package com.lobin.common.pattern.adapter;

public class MediaAdapter implements MediaPlayer {
    AdvanceMediaPlayer advanceMediaPlayer;

    MediaAdapter(String type) {
        switch (type) {
            case "vlc":
                advanceMediaPlayer = new VlcPlayer();
                break;
            case "mp3":
                advanceMediaPlayer = new Mp3Player();
                break;
            default:
                break;
        }
    }

    @Override
    public void play(String type, String name) {
        switch (type) {
            case "vlc":
                advanceMediaPlayer.playVlc(name);
                break;
            case "mp3":
                advanceMediaPlayer.playMp3(name);
                break;
            default:
                break;
        }
    }
}
