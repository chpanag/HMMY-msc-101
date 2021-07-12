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
        
        if (sensorDTO.getValue() < 36 && sensorDTO.getValue() >=34 ) {
            eventDTO.setLevel(EventLevel.DANGER);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received. You have hypothermia");
        } else if (sensorDTO.getValue() < 34) {
                eventDTO.setLevel(EventLevel.WARN);
                eventDTO.setMessage("Value " + sensorDTO.getValue() + " received. Please check your thermometer. Maybe is broken");
        } else if (sensorDTO.getValue() >= 36 && sensorDTO.getValue() <= 37.2) {
            eventDTO.setLevel(EventLevel.NORMAL);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received. Your temperature is normal");
        } else if (sensorDTO.getValue() > 37.2  && sensorDTO.getValue() < 39) {
            eventDTO.setLevel(EventLevel.WARN);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received. You have fever and you need to get medicines.");
        } else if (sensorDTO.getValue() >= 39 && sensorDTO.getValue() <= 42){
            eventDTO.setLevel(EventLevel.DANGER);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received. You have high fever and you need to go to hospital");    
    	} else if (sensorDTO.getValue() >42){
        eventDTO.setLevel(EventLevel.WARN);
        eventDTO.setMessage("Value " + sensorDTO.getValue() + " received. Please check your thermometer. Maybe is broken.");
    	}    
       

//      Return the eventDTO object
        return eventDTO;
    }
}
