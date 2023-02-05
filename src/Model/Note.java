package Model;

public class Note {
    private String id;
    private String heading;
    private String text;

    public Note(String heading, String text) {
        this.heading = heading;
        this.text = text;
    }

    public Note(String id, String heading, String text) {
        this(heading, text);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getHeading() {
        return heading;
    }

    public String getText() {
        return text;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("Идентификатор записки: %s\nЗаголовок записки: %s,\nТекст записки: %s", id, heading, text);
    }
}

