package game.util;

import java.util.ArrayList;
import java.util.List;

import game.interfaces.UpdateRunnable;

public class FrameManager {
    private double currentFps;
    private long ms;
    private double lag;
    private double deltaTime;

    private int defaultFrameRate;
    private int frameRate;

    private long startTime;

    private List<Double> saveDeltaTimes;
    private List<Double> saveFps;

    public FrameManager(int frameDuration) {
        this.startTime = System.nanoTime();
        this.saveDeltaTimes = new ArrayList<>();
        this.saveFps = new ArrayList<>();
        this.frameRate = frameDuration;
        this.defaultFrameRate = frameDuration;
        this.currentFps = 0;
        this.lag = 0;
        this.ms = 0;
        this.deltaTime = 0;
    }

    public int getDefaultFrameRate() {
        return defaultFrameRate;
    }

    public void setFrameRate(int frameDuration) {
        this.frameRate = frameDuration;
    }

    public int getFrameRate() {
        return frameRate;
    }

    public double getFps() {
        return currentFps;
    }

    public double getMs() {
        return ms;
    }

    public double getLag() {
        return lag;
    }

    public double getDeltaTime() {
        return deltaTime;
    }

    public double getAverageDeltaTime() {
        double average = 0;
        for (double v : saveDeltaTimes) {
            average += v;
        }

        return average / saveDeltaTimes.size();
    }

    public double getAverageFps() {
        double average = 0;
        for (double v : saveFps) {
            average += v;
        }

        return average / saveFps.size();
    }

    // public void update(UpdateRunnable updateRunnable) {
    // long currentTime = System.nanoTime();
    // this.ms = currentTime - startTime;
    // this.startTime = currentTime;
    // this.lag += ms;

    // while (lag >= frameDuration) {
    // updateRunnable.runLogic();
    // lag -= frameDuration;
    // }

    // this.deltaTime = lag / frameDuration;

    // if (this.saveDeltaTimes.size() <= this.getFrameDuration()) {
    // this.saveDeltaTimes.add(deltaTime);
    // } else {
    // this.saveDeltaTimes.remove(0);
    // }

    // updateRunnable.runGraphics();

    // this.currentFps = (double) 1000 / ms;
    // if (this.saveFps.size() <= this.getFrameDuration()) {
    // this.saveFps.add(currentFps);
    // } else {
    // this.saveFps.remove(0);
    // }

    // }

    public void update(UpdateRunnable updateRunnable) {
        long current = System.nanoTime();
        long elapsed = current - startTime;

        updateRunnable.runLogic();

        // this.deltaTime = elapsed / (1000.0 / frameRate);
        // this.deltaTime = elapsed;
        this.deltaTime = Math.max(0, Math.min(1.2, elapsed / 1000000.0));
        // this.deltaTime = elapsed / 1000000.0;

        this.startTime = current;

        updateRunnable.runGraphics();
    }

}
