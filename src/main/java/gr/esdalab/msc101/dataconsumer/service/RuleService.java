package gr.esdalab.msc101.dataconsumer.service;

import gr.esdalab.msc101.dataconsumer.model.EventDTO;
import gr.esdalab.msc101.dataconsumer.model.EventLevel;
import gr.esdalab.msc101.dataconsumer.model.SensorDTO;
import org.springframework.stereotype.Service;

@Service
public class RuleService {

    /**
     * This method implements a set of rules that apply to the sensorDTO object value
     * @param sensorDTO
     * @return
     */
    public EventDTO processData(SensorDTO sensorDTO){
        EventDTO eventDTO = new EventDTO();

        // @TODO Implement your own rules and populate the eventDTO object
        if (sensorDTO.getValue() >= 39.5 && sensorDTO.getValue() <= 42.0 ) {
        	eventDTO.setLevel(EventLevel.DANGER);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received.WARNING ! HIGH  PATIENT TEMPERATURE");
        } else if (sensorDTO.getValue() >= 37.2 && sensorDTO.getValue() < 39.5) {
            eventDTO.setLevel(EventLevel.WARN);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received. Patient's temperature is RISING.");
        } else if (sensorDTO.getValue() >= 36.1  && sensorDTO.getValue() < 37.2) {
            eventDTO.setLevel(EventLevel.NORMAL);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received. Everything seems OK with temperature.");
        } else if (sensorDTO.getValue() >=35.1  && sensorDTO.getValue() <36.1){
            eventDTO.setLevel(EventLevel.DANGER);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received. LOW Patient TEMPERATURE. WARNING !");
        }else if (sensorDTO.getValue() > 42.0 || sensorDTO.getValue() < 35.1){
            eventDTO.setLevel(EventLevel.WARN);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received.Something wrong with temperature!");
        }

//      Return the eventDTO object
        return eventDTO;
    }
}
