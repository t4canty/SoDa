import java.awt.*;
import java.util.ArrayList;

public class Car extends GameObject {

    private double accel;
    private double velX, velY;
    private double maxVel;



    public Car(float x, float y, ObjectID id) {
        super(x, y, id);
        accel = 0.5;
        velX = 0;
        velY = 0;
        maxVel = 7;
        leftPressed = false;
        rightPressed = false;
        upPressed = false;
        downPressed = false;
    }

    public void reset() {

    }

    public boolean aboveMaxVel()
    {
        if (Math.sqrt(Math.pow(velX, 2) + Math.pow(velY, 2)) > maxVel * 2)
            return true;
        else
            return false;
    }

    @Override
    public void tick(ArrayList<GameObject> objects) {
        if (leftPressed)
        {
            if (velX >= -maxVel && !aboveMaxVel())
                velX -= accel;
            x += velX;
        }
        if (rightPressed)
        {
            if (velX <= maxVel && !aboveMaxVel())
                velX += accel;
            x += velX;
        }
        if (upPressed)
        {
            if (velY >= -maxVel && !aboveMaxVel())
                velY -= accel;
            y += velY;
        }
        if (downPressed)
        {
            if (velY <= maxVel && !aboveMaxVel())
                velY += accel;
            y += velY;
        }
        if (velX > 0 && !rightPressed)
        {
            velX -= accel;
            x += velX;
        }
        else if (velX < 0 && !leftPressed)
        {
            velX += accel;
            x += velX;
        }
        if (velY > 0 && !downPressed)
        {
            velY -= accel;
            y += velY;
        }
        else if (velY < 0 && !upPressed)
        {
            velY += accel;
            y += velY;
        }

    }

    @Override
    public void render(Graphics g) {
        //g.setColor(Color.GRAY);
        //g.fillRect(this.getBounds().x, this.getBounds().y, this.getBounds().width, this.getBounds().height);

        g.setColor(Color.green);
        g.fillOval((int) x, (int) y, 10, 10);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) this.x, (int) this.y, 10, 10);
    }
}
