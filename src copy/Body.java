import java.awt.Graphics;

public class Body {
    private double x, y;
    private double velocityX, velocityY;
    private double mass;

    public void randomStartPos(double y, double x){
        this.y = y;
        this.x = x;
    }

    
// Getters and Setters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

// ** Physics functionality
    public void applyForce(double fx, double fy){
        velocityX += fx / mass;
        velocityY += fy / mass;
    }
    
    public double checkDistance(Body otherBody){
        if (otherBody == null) {
            throw new IllegalArgumentException("otherBody cannot be null");
        }

        double dx = otherBody.getX() - x;
        double dy = otherBody.getY() - y;
        return Math.sqrt((dx * dx) + (dy * dy));
    }

    public void updatePosition(){

        }
        
    public void draw(Graphics g){
        
    }
}
