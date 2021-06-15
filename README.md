# Getting Started

### General
This project is to support the Course MSC-101. It is supposed to be used as the basis for the courses's assignment.
The details of the assignment are described here (in greek):

## Local Development environment

### Prerequisites
- JDK 8
- Maven3
- An MQTT broker (optional): https://www.emqx.io/
- An MQTT client application for testing (optional): https://chrome.google.com/webstore/detail/mqttbox/kaajoficamnjijhkeomgfljpicifbkaf

### Configure
Before running the application you need to setup the MQTT broker connection details.

You will find them in `src/main/resources/application.yml`


### Test the application
Run Tests:

`mvn test`

### Run the application
Execute the following from command line:

`mvn spring-boot:run`

## Preconfigured Development Environment
To skip all the above and have a development environment ready sooner, you can import the following ova to your favorite
hypervisor.

