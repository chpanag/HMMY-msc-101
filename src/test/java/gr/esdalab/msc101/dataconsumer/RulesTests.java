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


    SensorDTO outOfOperationLowSensorDTO = new SensorDTO("temp", 5.0);
    SensorDTO outOfOperationHighSensorDTO = new SensorDTO("temp", 100.0);
    SensorDTO heatSensorDTO = new SensorDTO("temp", 40.0);
    SensorDTO coolSensorDTO = new SensorDTO("temp", 35.0);
    SensorDTO normalSensorDTO = new SensorDTO("temp", 36.5);

    @Autowired
    RuleService ruleService;

    @BeforeAll
    public static void init(){
        log.info("Tesing RuleService started.");
    }

    @Test
    void testOutOfOperationLow() {
        assertEquals(EventLevel.WARN, ruleService.processData(outOfOperationLowSensorDTO).getLevel());
    }

    @Test
    void testOutOfOperationHigh() {
        assertEquals(EventLevel.WARN, ruleService.processData(outOfOperationHighSensorDTO).getLevel());
    }

    @Test
    void testHeat() {
        assertEquals(EventLevel.DANGER, ruleService.processData(heatSensorDTO).getLevel());
    }

    @Test
    void testCool() {
        assertEquals(EventLevel.DANGER, ruleService.processData(coolSensorDTO).getLevel());
    }

    @Test
    void testNormal() {
        assertEquals(EventLevel.NORMAL, ruleService.processData(normalSensorDTO).getLevel());
    }

}
