#define USE_LCD 0
 
#if USE_LCD
#include "C12832.h"
 
// the actual pins are defined in mbed_app.json and can be overridden per target
C12832 lcd(LCD_MOSI, LCD_SCK, LCD_MISO, LCD_A0, LCD_NCS);
 
#define logMessage lcd.cls();lcd.printf
 
#else
 
#define logMessage printf
 
#endif
 
#define MQTTCLIENT_QOS2 1
 
#include "easy-connect.h"
#include "MQTTNetwork.h"
#include "MQTTmbed.h"
#include "MQTTClient.h"
 
int arrivedcount = 0;
 
 
void messageArrived(MQTT::MessageData& md)
{
    MQTT::Message &message = md.message;
    logMessage("Message arrived: qos %d, retained %d, dup %d, packetid %d\r\n", message.qos, message.retained, message.dup, message.id);
    logMessage("Payload %.*s\r\n", message.payloadlen, (char*)message.payload);
    ++arrivedcount;
}
 
 
int main(int argc, char* argv[])
{
    // MQTT broker hostname
    const char* HOST = "dock1.pikei.io";
    // MQTT broker port
    const int PORT = 1884;

    float sample_sensor_value = 28.7;

    // MQTT topics for temperature & humidity
    const char* TEMPERATURE_TOPIC = "/uop/msc/hmmy101/iot/temperature";
    const char* HUMIDITY_TOPIC = "/uop/msc/hmmy101/iot/humidity";
 
    logMessage("Hello HMMY 101");
 
    NetworkInterface* network = easy_connect(true);
    if (!network) {
        return -1;
    }
 
    MQTTNetwork mqttNetwork(network);
 
    MQTT::Client<MQTTNetwork, Countdown> client(mqttNetwork);
 
    logMessage("Connecting to %s:%d\r\n", HOST, PORT);
    int rc = mqttNetwork.connect(HOST, PORT);
    if (rc != 0)
        logMessage("rc from TCP connect is %d\r\n", rc);
 
    MQTTPacket_connectData data = MQTTPacket_connectData_initializer;
    data.MQTTVersion = 3;

    // MQTT unique client id. Update this
    data.clientID.cstring = "tmp";
    // MQTT user credentials. Update this
    data.username.cstring = "testuser";
    data.password.cstring = "testpassword";

    if ((rc = client.connect(data)) != 0)
        logMessage("rc from MQTT connect is %d\r\n", rc);
 
    if ((rc = client.subscribe(TEMPERATURE_TOPIC, MQTT::QOS2, messageArrived)) != 0)
        logMessage("rc from MQTT subscribe is %d\r\n", rc);

 
    if ((rc = client.unsubscribe(TEMPERATURE_TOPIC)) != 0)
        logMessage("rc from unsubscribe was %d\r\n", rc);
 
    if ((rc = client.disconnect()) != 0)
        logMessage("rc from disconnect was %d\r\n", rc);
 
    mqttNetwork.disconnect();
 
    logMessage("Arrived %d msgs\r\n", arrivedcount);
 
    return 0;
}