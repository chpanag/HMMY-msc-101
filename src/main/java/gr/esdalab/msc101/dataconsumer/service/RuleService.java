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
        if (sensorDTO.getValue() <= 3) {
            eventDTO.setLevel(EventLevel.DANGER);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received. pH too basic");
        } else if (sensorDTO.getValue() > 3 && sensorDTO.getValue() <= 5) {
            eventDTO.setLevel(EventLevel.WARN);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received. ph turns basic");
        } else if (sensorDTO.getValue() > 5  && sensorDTO.getValue() <= 7) {
            eventDTO.setLevel(EventLevel.NORMAL);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received. Perfect ph conditions.");
        } else if (sensorDTO.getValue() >= 7 && sensorDTO.getValue() <= 9){
            eventDTO.setLevel(EventLevel.WARN);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received. pH turns acidic");
        }else if (sensorDTO.getValue() > 9 && sensorDTO.getValue() <= 14){
            eventDTO.setLevel(EventLevel.DANGER);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received. pH too acidic");
        }

//      Return the eventDTO object
        return eventDTO;
    }
}
