package gr.esdalab.msc101.dataconsumer;

import gr.esdalab.msc101.dataconsumer.model.EventLevel;
import gr.esdalab.msc101.dataconsumer.model.SensorDTO;
import gr.esdalab.msc101.dataconsumer.service.RuleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class RulesTests {

    private static final Logger log = LogManager.getLogger(RulesTests.class);


    SensorDTO outOfOperationLowSensorDTO = new SensorDTO("temp", 35.8);
    SensorDTO outOfOperationHighSensorDTO = new SensorDTO("temp", 41.9);
    SensorDTO heatSensorDTO = new SensorDTO("temp", 38.8);
    SensorDTO coolSensorDTO = new SensorDTO("temp", 37.5);
    SensorDTO normalSensorDTO = new SensorDTO("temp", 36.6);

    @Autowired
    RuleService ruleService;

    @BeforeAll
    public static void init(){
        log.info("Tesing RuleService started.");
    }

    @Test
    void testOutOfOperationLow() {
        assertEquals(EventLevel.DANGER, ruleService.processData(outOfOperationLowSensorDTO).getLevel());
    }

    @Test
    void testOutOfOperationHigh() {
        assertEquals(EventLevel.DANGER, ruleService.processData(outOfOperationHighSensorDTO).getLevel());
    }

    @Test
    void testHeat() {
        assertEquals(EventLevel.WARN, ruleService.processData(heatSensorDTO).getLevel());
    }

    @Test
    void testCool() {
        assertEquals(EventLevel.WARN, ruleService.processData(coolSensorDTO).getLevel());
    }

    @Test
    void testNormal() {
        assertEquals(EventLevel.NORMAL, ruleService.processData(normalSensorDTO).getLevel());
    }

}
