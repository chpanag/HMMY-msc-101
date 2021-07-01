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

    SensorDTO outOfOperationLowSensorDTO = new SensorDTO("wind", -1.0);
    SensorDTO outOfOperationHighSensorDTO = new SensorDTO("wind", 15.0);
    SensorDTO warnSensorDTO = new SensorDTO("wind", 2.0);
    SensorDTO normalSensorDTO = new SensorDTO("wind", 4.0);
    SensorDTO hurricaneSensorDTO = new SensorDTO("wind", 11.0);

    @Autowired
    RuleService ruleService;

    @BeforeAll
    public static void init() {
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
    void testWarn() {
        assertEquals(EventLevel.WARN, ruleService.processData(warnSensorDTO).getLevel());
    }

    @Test
    void testHurricane() {
        assertEquals(EventLevel.DANGER, ruleService.processData(hurricaneSensorDTO).getLevel());
    }

    @Test
    void testNormal() {
        assertEquals(EventLevel.NORMAL, ruleService.processData(normalSensorDTO).getLevel());
    }

}
