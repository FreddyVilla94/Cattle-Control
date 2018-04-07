package com.example.freddy.cattlecontrol.Clases;

/**
 * Created by Freddy on 7/4/2018.
 */

public class Extension {

    private int extension;
    private int measure;

    public Extension() {
    }

    public Extension(int extension, int measure) {
        this.extension = extension;
        this.measure = measure;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    public int getMeasure() {
        return measure;
    }

    public void setMeasure(int measure) {
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
