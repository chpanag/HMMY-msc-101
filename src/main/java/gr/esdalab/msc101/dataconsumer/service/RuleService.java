package gr.esdalab.msc101.dataconsumer.service;

import gr.esdalab.msc101.dataconsumer.model.EventDTO;
import gr.esdalab.msc101.dataconsumer.model.EventLevel;
import gr.esdalab.msc101.dataconsumer.model.SensorDTO;
import org.springframework.stereotype.Service;

@Service
public class RuleService {

    /**
     * This method implements a set of rules that apply to the sensorDTO object
     * value
     * 
     * @param sensorDTO
     * @return
     */
    public EventDTO processData(SensorDTO sensorDTO) {
        EventDTO eventDTO = new EventDTO();

        if (sensorDTO.getValue() < 0) {
            eventDTO.setLevel(EventLevel.DANGER);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received. Something is wrong with the sensor!");
        } else if (sensorDTO.getValue() >= 0 && sensorDTO.getValue() < 3) {
            eventDTO.setLevel(EventLevel.WARN);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received. Not good for windsurfing :/");
        } else if (sensorDTO.getValue() >= 3 && sensorDTO.getValue() <= 6) {
            eventDTO.setLevel(EventLevel.NORMAL);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received. Go to the sea, wind's great for windsurfing :)");
        } else if (sensorDTO.getValue() > 6) {
            eventDTO.setLevel(EventLevel.DANGER);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received. Dangerous winds, no windsurfing!");
        }

        // Return the eventDTO object
        return eventDTO;
    }
}
