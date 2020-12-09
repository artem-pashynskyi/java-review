package interfaces.mytube;

public class VideoProcessor {

    VideoEncoder encoder;
    VideoDatabase database;
    NotificationService notification;

    public VideoProcessor(VideoEncoder encoder, VideoDatabase database, NotificationService notification) {
        this.encoder = encoder;
        this.database = database;
        this.notification = notification;
    }

    public void process(Video video) {
        encoder.encode(video);
        database.store(video);
        notification.sendEmail(video.getUser());
    }
}

