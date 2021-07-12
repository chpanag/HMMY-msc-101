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


    SensorDTO tempLowSensorDTO = new SensorDTO("temp", 15.0);
    SensorDTO tempNormalSensorDTO = new SensorDTO("temp", 18.0);
    SensorDTO tempHighSensorDTO = new SensorDTO("temp", 20.0);
    SensorDTO tempOutOfBoundsSensorDTO = new SensorDTO("temp", 25.0);
    SensorDTO relHumLowSensorDTO = new SensorDTO("relhum", 43.0);
    SensorDTO relHumSubNormalSensorDTO = new SensorDTO("relhum", 52.0);
    SensorDTO relHumNormalSensorDTO = new SensorDTO("relhum", 56.5);
    SensorDTO relHumOverNormalSensorDTO = new SensorDTO("relhum", 62.0);
    SensorDTO relHumOutOfBoundsSensorDTO = new SensorDTO("relhum", 70.2);
    SensorDTO pressLowSensorDTO = new SensorDTO("press", 0.8);
    SensorDTO pressNormalSensorDTO = new SensorDTO("press", 1.1);
    SensorDTO pressHighSensorDTO = new SensorDTO("press", 1.3);
    SensorDTO concentrNormalSensorDTO = new SensorDTO("quality", 580.0);
    SensorDTO concentrRisingSensorDTO = new SensorDTO("quality", 620.0);
    SensorDTO concentrHighSensorDTO = new SensorDTO("quality", 735.0);

    @Autowired
    RuleService ruleService;

    @BeforeAll
    public static void init(){
        log.info("Tesing RuleService started.");
    }

    @Test
    void testTempLow() {
        assertEquals(EventLevel.DANGER, ruleService.processData(tempLowSensorDTO).getLevel());
    }

    @Test
    void testTempNormal() {
        assertEquals(EventLevel.NORMAL, ruleService.processData(tempNormalSensorDTO).getLevel());
    }

    @Test
    void testTempHigh() {
        assertEquals(EventLevel.WARN, ruleService.processData(tempHighSensorDTO).getLevel());
    }

    @Test
    void testTempOut() {
        assertEquals(EventLevel.DANGER, ruleService.processData(tempOutOfBoundsSensorDTO).getLevel());
    }

    @Test
    void testHumLow() {
        assertEquals(EventLevel.DANGER, ruleService.processData(relHumLowSensorDTO).getLevel());
    }
    
    @Test
    void testHumSub() {
        assertEquals(EventLevel.WARN, ruleService.processData(relHumSubNormalSensorDTO).getLevel());
    }
    
    
    @Test
    void testHumNormal() {
        assertEquals(EventLevel.NORMAL, ruleService.processData(relHumNormalSensorDTO).getLevel());
    }
    
    @Test
    void testHumOver() {
        assertEquals(EventLevel.WARN, ruleService.processData(relHumOverNormalSensorDTO).getLevel());
    }
    
    @Test
    void testHumOut() {
        assertEquals(EventLevel.DANGER, ruleService.processData(relHumOutOfBoundsSensorDTO).getLevel());
    }
    
    @Test
    void testPressLow() {
        assertEquals(EventLevel.DANGER, ruleService.processData(pressLowSensorDTO).getLevel());
    }
    
    @Test
    void testPressNormal() {
        assertEquals(EventLevel.NORMAL, ruleService.processData(pressNormalSensorDTO).getLevel());
    }
    
    @Test
    void testPressHigh() {
        assertEquals(EventLevel.WARN, ruleService.processData(pressHighSensorDTO).getLevel());
    }
    
    @Test
    void testConcentrNormal() {
        assertEquals(EventLevel.NORMAL, ruleService.processData(concentrNormalSensorDTO).getLevel());
    }
    
    @Test
    void testConcentrHigh() {
        assertEquals(EventLevel.WARN, ruleService.processData(concentrRisingSensorDTO).getLevel());
    }
    
    @Test
    void testConcentrOut() {
        assertEquals(EventLevel.DANGER, ruleService.processData(concentrHighSensorDTO).getLevel());
    }
}
