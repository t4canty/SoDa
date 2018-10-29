import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.ArrayList;

public class Car extends GameObject {

    private int width;
    private int height;
    private float accel = 0.5f;
    private final float maxVel = 10;
    private Handler handler;

    public Car(float x, float y, ObjectID id)
    {
        super(x, y, id);
        width = 15;
        height = 30;
        //this.handler = handler;
        // TODO Auto-generated constructor stub
    }

    public boolean aboveMaxVel() {
        return Math.sqrt(Math.pow(velX, 2) + Math.pow(velY, 2)) > maxVel * 2;
    }

    @Override

    public void tick(ArrayList<GameObject> objects)
    {
        if (leftPressed)
        {
            if (velX >= -maxVel && !aboveMaxVel())
                velX -= accel;


        }
        if (rightPressed) {
            if (velX <= maxVel && !aboveMaxVel())
                velX += accel;
}
        if (upPressed) {
            if (velY >= -maxVel && !aboveMaxVel())
                velY -= accel;
        }
        if (downPressed) {
            if (velY <= maxVel && !aboveMaxVel())
                velY += accel;
        }
        if (velX > 0 && !rightPressed) {
            velX -= accel;

        }
        else if (velX < 0 && !leftPressed) {
            velX += accel;
        }
        if (velY > 0 && !downPressed) {
            velY -= accel;
        }
        else if (velY < 0 && !upPressed) {
            velY += accel;

        }
        x += velX;
        y += velY;

        colission(objects);
    }

    private void colission(ArrayList<GameObject> objects)
    {

        for (int i = 0; i < objects.size(); i++)
        {
            GameObject thisObj = objects.get(i);
            if (thisObj.getID() == ObjectID.Wall)
            {
                if (getBoundsTop().intersects(thisObj.getBounds()))
                {
                    velY = 0;
                    y = (thisObj.getY() + height / 2) + 1;
                }

                if (getBounds().intersects(thisObj.getBounds()))
                {
                    velY = 0;

                    y = thisObj.getY() - height;
                }

                if (getBoundsLeft().intersects(thisObj.getBounds()))
                {
                    x = thisObj.getX() + 17;
                }

                if (getBoundsRight().intersects(thisObj.getBounds()))
                {
                    x = thisObj.getX() - 17;
                }
            }
        }

    }

    @Override
    public void render(Graphics g)
    {
        // TODO Auto-generated method stub
        g.setColor(Color.GREEN);
        g.fillRect((int)x, (int)y, width, height);

        Graphics2D g2d = (Graphics2D)g;
        g.setColor(Color.CYAN);

        g2d.draw(getBounds());
        g2d.draw(getBoundsTop());
        g2d.draw(getBoundsLeft());
        g2d.draw(getBoundsRight());
    }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle((int)(x + width / 2 - width / 4), (int)(y + height /  1.2), width /2 , height / 6);
    }
    public Rectangle getBoundsTop()
    {
        return new Rectangle((int)(x + width / 2 - width / 4), (int)y, (width / 2), height / 6);
    }
    public Rectangle getBoundsLeft()
    {
        return new Rectangle((int)x, (int)(y + 2.5), 5, height - 5);
    }
    public Rectangle getBoundsRight()
    {
        return new Rectangle((int)(x + width - 5), (int)(y + 2.5), 5, height - 5);
    }
}
