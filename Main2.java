
class MediaAsset {
    private String assetId;
    private String title;
    private long fileSizeMB;
    private int durationSeconds;

    public MediaAsset(String assetId, String title,
                      long fileSizeMB, int durationSeconds) {
        this.assetId = assetId;
        this.title = title;
        this.fileSizeMB = fileSizeMB;
        this.durationSeconds = durationSeconds;
    }

    public void play() {
        System.out.println("Playing media");
    }

    public void pause() {
        System.out.println("Media paused.");
    }
}

class VideoTrack extends MediaAsset {
    private String resolution;
    private String videoCodec;
    private int framerate;

    public VideoTrack(String assetId, String title,
                      long fileSizeMB, int durationSeconds,
                      String resolution, String videoCodec,
                      int framerate) {

        super(assetId, title, fileSizeMB, durationSeconds);

        this.resolution = resolution;
        this.videoCodec = videoCodec;
        this.framerate = framerate;
    }

    public void adjustBitrate(int targetBitrate) {
        System.out.println("Bitrate adjusted to: " + targetBitrate);
    }

    public String getStreamInfo() {
        return "Resolution: " + resolution
                + ", Codec: " + videoCodec
                + ", Framerate: " + framerate;
    }
}

class FeatureFilm extends VideoTrack {
    private String director;
    private String mpaaRating;
    private String availableSubtitles;

    public FeatureFilm(String assetId, String title,
                       long fileSizeMB, int durationSeconds,
                       String resolution, String videoCodec,
                       int framerate, String director,
                       String mpaaRating, String availableSubtitles) {

        super(assetId, title, fileSizeMB, durationSeconds,
              resolution, videoCodec, framerate);

        this.director = director;
        this.mpaaRating = mpaaRating;
        this.availableSubtitles = availableSubtitles;
    }

    public void loadSubtitles(String language) {
        if (availableSubtitles.equals(language)) {
            System.out.println(language + " subtitles loaded.");
        } else {
            System.out.println("Subtitles not available.");
        }
    }

    @Override
    public void play() {
        System.out.println("Playing feature film.");
    }
}

public class Main2 {
    public static void main(String[] args) {

        FeatureFilm film = new FeatureFilm(
            "M101", "My Movie", 2000, 7200,
            "1080p", "H.264", 30,
            "Ali Khan", "PG-13", "English"
        );

        film.play();
        film.pause();
        film.adjustBitrate(5000);

        System.out.println(film.getStreamInfo());

        film.loadSubtitles("English");
    }
}

