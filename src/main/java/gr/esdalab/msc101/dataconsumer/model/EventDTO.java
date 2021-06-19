package gr.esdalab.msc101.dataconsumer.model;


public class EventDTO {
    EventLevel level;
    String message;

    public EventDTO() {
    }

    public EventDTO(EventLevel level, String message) {
        this.level = level;
        this.message = message;
    }

    public EventLevel getLevel() {
        return level;
    }

    public void setLevel(EventLevel level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "level=" + level +
                ", message='" + message + '\'' +
                '}';
    }
}
