interface MediaPlayer {
    void play(String file);
}

class Mp3Player implements MediaPlayer {
    public void play(String file) {
        System.out.println("Playing MP3: " + file);
    }
}

class Mp4Player {
    void playMp4(String file) {
        System.out.println("Playing MP4: " + file);
    }
}

class MediaAdapter implements MediaPlayer {
    Mp4Player mp4 = new Mp4Player();

    public void play(String file) {
        mp4.playMp4(file);
    }
}

public class AdapterExample1_Media {
    public static void main(String[] args) {
        MediaPlayer player = new MediaAdapter();
        player.play("video.mp4");
    }
}