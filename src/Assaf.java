import java.awt.*;
import java.util.LinkedList;

public class Assaf extends GameObject {

    private double accel;
    private double velX, velY;
    private double velCount = 0;

    public Assaf(float x, float y, ObjectID id) {
        super(x, y, id);
        accel = 0.3;
        velX = 0;
        velY = 0;
    }

    public void reset()
    {

    }

    @Override
    public void tick(LinkedList<GameObject> objects) {
        velY += accel;
        y += velY;


        if (y > 500)
        {
            y = 499;
            velY = -15;
            velY += velCount;
            if (velCount < 15)
            {
                velCount += 3;
            }
        }
    }

    @Override
    public void render(Graphics g)  
        //g.setColor(Color.GRAY);
        //g.fillRect(this.getBounds().x, this.getBounds().y, this.getBounds().width, this.getBounds().height);

        g.setColor(Color.green);
        g.fillOval((int) x, (int) y, 10, 10);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)this.x, (int)this.y, 10, 10);
    }
}
