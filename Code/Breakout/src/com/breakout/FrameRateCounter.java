package com.breakout;
import java.util.*;

public class FrameRateCounter {

    private Map<Long, Long> measurementTimes;


    public FrameRateCounter() {
        measurementTimes = new HashMap<Long, Long>();
    }

    public synchronized void submitReading() {
        long measurementTime = System.nanoTime();
        long invalidationTime = System.nanoTime() + 1000000000;
        measurementTimes.put(measurementTime, invalidationTime);
    }

    public int getFrameRate() {
        performInvalidations();
        return measurementTimes.size();
    }

    private synchronized void performInvalidations() {
        long currentTime = System.nanoTime();
        Iterator<Long> i = measurementTimes.keySet().iterator();
        while(i.hasNext()) {
            long measurementTime = i.next();
            long invalidationTime = measurementTimes.get(measurementTime);
            if(invalidationTime < currentTime) {
                i.remove();
            }
        }
    }
}
