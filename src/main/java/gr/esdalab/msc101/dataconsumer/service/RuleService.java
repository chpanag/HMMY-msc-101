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
        if (sensorDTO.getValue() <= 15) {
            eventDTO.setLevel(EventLevel.DANGER);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received.Something wrong with ventilation");
        } else if (sensorDTO.getValue() >= 15 && sensorDTO.getValue() <= 20) {
            eventDTO.setLevel(EventLevel.WARN);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received. Too high, you must heat the environment!");
        } else if (sensorDTO.getValue() > 20  && sensorDTO.getValue() < 28) {
            eventDTO.setLevel(EventLevel.NORMAL);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received. Everything seems ok.");
        } else if (sensorDTO.getValue() >= 28 && sensorDTO.getValue() <= 32){
            eventDTO.setLevel(EventLevel.WARN);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received. Too high, you must cool the environment!");
        }else if (sensorDTO.getValue() > 32){
            eventDTO.setLevel(EventLevel.DANGER);
            eventDTO.setMessage("Value " + sensorDTO.getValue() + " received.Something wrong with ventilation");
        }

//      Return the eventDTO object
        return eventDTO;
    }
}
