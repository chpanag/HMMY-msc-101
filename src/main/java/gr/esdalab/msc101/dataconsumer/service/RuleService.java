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
        if (sensorDTO.getLabel() == "temp") {
		if (sensorDTO.getValue() < 16) {
		    eventDTO.setLevel(EventLevel.DANGER);
		    eventDTO.setMessage("Temperature value " + sensorDTO.getValue() + " received. Temperature too low.");
		} else if (sensorDTO.getValue() >= 16 && sensorDTO.getValue() <= 19) {
		    eventDTO.setLevel(EventLevel.NORMAL);
		    eventDTO.setMessage("Temperature value " + sensorDTO.getValue() + " received. Optimal conditions!");
		} else if (sensorDTO.getValue() > 19  && sensorDTO.getValue() < 21) {
		    eventDTO.setLevel(EventLevel.WARN);
		    eventDTO.setMessage("Temperature value " + sensorDTO.getValue() + " received. Temperature needs to be regulated.");
		} else if (sensorDTO.getValue() >= 21){
		    eventDTO.setLevel(EventLevel.DANGER);
		    eventDTO.setMessage("Temperature value " + sensorDTO.getValue() + " received. Alert!!! Too high, you must cool the environment!");
		}
	} else if (sensorDTO.getLabel() == "relhum") {
		if (sensorDTO.getValue() <= 50) {
		    eventDTO.setLevel(EventLevel.DANGER);
		    eventDTO.setMessage("Relative humidity is " + sensorDTO.getValue() + " %. Supply humid air");
		} else if (sensorDTO.getValue() >= 50 && sensorDTO.getValue() <= 55) {
		    eventDTO.setLevel(EventLevel.WARN);
		    eventDTO.setMessage("Relative humidity is " + sensorDTO.getValue() + " %. Warning, air losing humidity");
		} else if (sensorDTO.getValue() > 55  && sensorDTO.getValue() < 60) {
		    eventDTO.setLevel(EventLevel.NORMAL);
		    eventDTO.setMessage("Relative humidity is " + sensorDTO.getValue() + " %. Optimal conditions.");
		} else if (sensorDTO.getValue() >= 60 && sensorDTO.getValue() <= 65){
		    eventDTO.setLevel(EventLevel.WARN);
		    eventDTO.setMessage("Relative humidity is " + sensorDTO.getValue() + " %. Too high, remove moisture!");
		}else if (sensorDTO.getValue() > 65){
		    eventDTO.setLevel(EventLevel.DANGER);
		    eventDTO.setMessage("Relative humidity is " + sensorDTO.getValue() + " %. Turn on ventilation");
		}
	} else if (sensorDTO.getLabel() == "press") {
		if (sensorDTO.getValue() < 1.0) {
		    eventDTO.setLevel(EventLevel.DANGER);
		    eventDTO.setMessage("Air pressure is " + sensorDTO.getValue() + " atm. Seal doors");
		} else if (sensorDTO.getValue() >= 1.0 && sensorDTO.getValue() <= 1.2) {
		    eventDTO.setLevel(EventLevel.NORMAL);
		    eventDTO.setMessage("Air pressure is " + sensorDTO.getValue() + " atm. Pressure within limits");
		} else if (sensorDTO.getValue() > 1.2){
		    eventDTO.setLevel(EventLevel.WARN);
		    eventDTO.setMessage("Air pressure is " + sensorDTO.getValue() + " atm. Pressure out of normal value range!");
		}
	} else if (sensorDTO.getLabel() == "quality") {
		if (sensorDTO.getValue() >= 500 && sensorDTO.getValue() <= 600) {
		    eventDTO.setLevel(EventLevel.NORMAL);
		    eventDTO.setMessage("Concentration is " + sensorDTO.getValue() + " ppm. Ideal");
		} else if (sensorDTO.getValue() > 600 && sensorDTO.getValue() < 650) {
		    eventDTO.setLevel(EventLevel.WARN);
		    eventDTO.setMessage("Concentration is " + sensorDTO.getValue() + " ppm. Start ventilation");
		} else if (sensorDTO.getValue() >= 650){
		    eventDTO.setLevel(EventLevel.DANGER);
		    eventDTO.setMessage("Concentration is " + sensorDTO.getValue() + " ppm. Wear protective equipment!");
		}
	}
//      Return the eventDTO object
        return eventDTO;
    }
}
