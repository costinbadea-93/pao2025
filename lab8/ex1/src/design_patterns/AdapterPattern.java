package design_patterns;

public class AdapterPattern {
    public static void main(String[] args) {
        /**
         * What is it?
         *
         * The Adapter pattern is used to enable two incompatible interfaces to work together.
         * It acts as a bridge between the client and the existing system by converting one
         * interface into another.
         *
         * When to Use?
         *
         * It’s commonly used when integrating legacy systems or when you need to
         * adapt new functionality to an existing system without altering the original system's code.
         *
         * How it Works?
         *
         * An Adapter class implements the required interface and delegates calls to the existing system.
         * This makes the system work with the new interface seamlessly.
         */
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("MP3", "beyond the horizon.mp3");
        audioPlayer.play("MP4", "alone.mp4");
        audioPlayer.play("VLC", "far far away.vlc");
        audioPlayer.play("AVI", "mind me.avi");
    }
}
interface MediaPlayer {
    void play(String audioType, String fileName);
}

class AdvancedMediaPlayer {
    public void playMp4(String fileName) {
        System.out.println("Playing MP4: " + fileName);
    }

    public void playVlc(String fileName) {
        System.out.println("Playing VLC: " + fileName);
    }
}

class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        advancedMediaPlayer = new AdvancedMediaPlayer();

        // You could handle different formats here
        if (audioType.equalsIgnoreCase("MP4")) {
            // Setup for MP4
        } else if (audioType.equalsIgnoreCase("VLC")) {
            // Setup for VLC
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("MP4")) {
            advancedMediaPlayer.playMp4(fileName);
        } else if (audioType.equalsIgnoreCase("VLC")) {
            advancedMediaPlayer.playVlc(fileName);
        }
    }
}

class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("MP3")) {
            System.out.println("Playing MP3: " + fileName);
        } else if (audioType.equalsIgnoreCase("MP4") || audioType.equalsIgnoreCase("VLC")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid audio type: " + audioType);
        }
    }
}
