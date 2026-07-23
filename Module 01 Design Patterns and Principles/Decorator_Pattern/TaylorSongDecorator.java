interface Song {
    String play();
}

class TaylorSong implements Song {
    public String play() {
        return "Karma";
    }
}

class Remix implements Song {
    Song song;

    Remix(Song song) {
        this.song = song;
    }

    public String play() {
        return song.play() + " (Remix)";
    }
}

public class Main {
    public static void main(String[] args) {
        Song song = new Remix(new TaylorSong());
        System.out.println(song.play());
    }
}