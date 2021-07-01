package gr.esdalab.msc101.dataconsumer.model;

public enum EventLevel {
    NORMAL("normal"), WARN("warn"), DANGER("danger");

    String value;

    EventLevel(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "EventLevel{value='" + value + "'}";
    }
}
