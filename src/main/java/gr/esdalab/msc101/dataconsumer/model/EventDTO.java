package gr.esdalab.msc101.dataconsumer.model;

import lombok.Data;

@Data
public class EventDTO {
    EventLevel level;
    String message;
}
