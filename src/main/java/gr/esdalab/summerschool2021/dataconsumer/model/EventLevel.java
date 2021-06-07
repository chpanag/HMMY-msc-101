package gr.esdalab.summerschool2021.dataconsumer.model;

import lombok.Data;

public enum EventLevel {
    NORMAL("normal"),
    WARN("warn"),
    DANGER("danger");

    String value;

    EventLevel(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "EventLevel{" +
                "value='" + value + '\'' +
                '}';
    }
}
