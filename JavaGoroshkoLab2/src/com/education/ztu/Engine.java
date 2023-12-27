package com.education.ztu;

public class Engine {
    private boolean engineWorks;

    public Engine() {
        engineWorks = false;
    }

    public boolean isEngineWorks() {
        return engineWorks;
    }

    public void startEngine() {
        engineWorks = true;
    }

    public void stopEngine() {
        engineWorks = false;
    }
}
