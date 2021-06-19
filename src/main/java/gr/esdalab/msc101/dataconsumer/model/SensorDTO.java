package gr.esdalab.msc101.dataconsumer.model;


public class SensorDTO {

    String label;
    Double value;

    public SensorDTO() {
    }

    public SensorDTO(String label, Double value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public Double getValue() {
        return value;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SensorDTO{" +
                "label='" + label + '\'' +
                ", value=" + value +
                '}';
    }
}
