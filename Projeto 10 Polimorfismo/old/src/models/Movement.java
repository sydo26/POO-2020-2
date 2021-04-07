package src.models;

import src.util.Vector2D;

public class Movement {

    private double accelerationFactorX;
    private double accelerationFactorY;

    private double velocityX;
    private double velocityY;

    private double maxVelocityX;
    private double maxVelocityY;

    public Movement(Vector2D acceleration, Vector2D maxVelocity) {
        this.accelerationFactorX = acceleration.getX();
        this.accelerationFactorY = acceleration.getY();
        this.maxVelocityX = maxVelocity.getX();
        this.maxVelocityY = maxVelocity.getY();

        this.velocityX = 0;
        this.velocityY = 0;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public double getMaxVelocityX() {
        return maxVelocityX;
    }

    public double getMaxVelocityY() {
        return maxVelocityY;
    }

    public boolean slowdown(int dx, int dy) {
        // if (dx == 1) {
        // double diff = Math.ceil((Math.abs(maxVelocityX - velocityX) * 100)) / 100;
        // if (diff < accelerationFactorX)
        // this.velocityX -= diff;
        // else
        // this.velocityX -= Math.ceil(Math.floor((accelerationFactorX / 2) * 100));

        // if (Math.abs(velocityX) == 0)
        // return true;
        // } else if (dx == -1) {
        // double diff = Math.ceil(Math.abs((-maxVelocityX) - velocityX) * 100) / 100;
        // if (diff < accelerationFactorX)
        // this.velocityX += diff;
        // else
        // this.velocityX += Math.ceil(Math.floor((accelerationFactorX / 2) * 100));

        // if (Math.abs(velocityX) == 0)
        // return true;
        // }

        return false;
    }

    public void update() {
        if (velocityX > 0) {
            this.velocityX -= accelerationFactorX;
            // System.out.println(velocityX);
        }
    }

    public boolean accelerate(int dx, int dy) { // true se chegar ao máximo
        if (dx == 1) {
            double diff = maxVelocityX - velocityX;
            if (diff > accelerationFactorX) { //
                this.velocityX += accelerationFactorX;
            } else {
                this.velocityX += diff;
            }

        } else if (dx == -1) {
            // acceleration = 1

            // maxVelocity = 10
            // velocity = 9
            /** diff = -10-9 = -19 */

            // maxVelocity = 10
            // velocity = -9
            /** diff = -10+9 = 19 */

            // double diff = Math.ceil(Math.abs((maxVelocityX) - velocityX) * 100) / 100;
            // if (diff < accelerationFactorX)
            // this.velocityX -= diff;
            // else
            // this.velocityX -= accelerationFactorX;

            // if (Math.abs(velocityX) >= maxVelocityX)
            // return true;
        }

        return false;
    }
}
