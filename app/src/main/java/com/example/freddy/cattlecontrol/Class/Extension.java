
package com.example.freddy.cattlecontrol.Class;


public class Extension {

    private Integer extension;
    private Boolean measure;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Extension() {
    }

    /**
     * 
     * @param extension
     * @param measure
     */
    public Extension(Integer extension, Boolean measure) {
        super();
        this.extension = extension;
        this.measure = measure;
    }

    public Integer getExtension() {
        return extension;
    }

    public void setExtension(Integer extension) {
        this.extension = extension;
    }

    public Boolean getMeasure() {
        return measure;
    }

    public void setMeasure(Boolean measure) {
        this.measure = measure;
    }

    @Override
    public String toString() {
        return "Extension{" +
                "extension=" + extension +
                ", measure=" + measure +
                '}';
    }
}
