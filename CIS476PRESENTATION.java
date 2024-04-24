package cis.pkg476.presentation;

interface MediaDevice {
    void playAudio(String audio);
    void playVideo(String video);
}

class Phone implements MediaDevice {
    @Override
    public void playAudio(String audio) {
        System.out.println("Phone playing audio: " + audio);
    }
    @Override
    public void playVideo(String video) {
        System.out.println("Phone playing video: " + video);
    }
}

class TV implements MediaDevice {
    @Override
    public void playAudio(String audio) {
        System.out.println("TV playing audio: " + audio);
    }
    @Override
    public void playVideo(String video) {
        System.out.println("TV playing video: " + video);
    }
}
abstract class MediaContent {
    protected MediaDevice device;

    protected MediaContent(MediaDevice device) {
        this.device = device;
    }

    abstract void play();
}

class Music extends MediaContent {
    private String audioFile;

    public Music(MediaDevice device, String audioFile) {
        super(device);
        this.audioFile = audioFile;
    }
    @Override
    void play() {
        device.playAudio(audioFile);
    }
}

class Video extends MediaContent {
    private String videoFile;

    public Video(MediaDevice device, String videoFile) {
        super(device);
        this.videoFile = videoFile;
    }
    @Override
    void play() {
        device.playVideo(videoFile);
    }
}


public class CIS476PRESENTATION {
    public static void main(String[] args) {
        MediaContent musicOnPhone = new Music(new Phone(), "music.mp3");
        MediaContent videoOnTV = new Video(new TV(), "video.mp4");

        musicOnPhone.play(); // Output: Phone playing audio: music.mp3
        videoOnTV.play();   // Output: TV playing video: video.mp4
    }
}
