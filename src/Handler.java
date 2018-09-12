import java.awt.Graphics;
import java.util.LinkedList;

public class Handler
{
    public LinkedList<GameObject> objects = new LinkedList<GameObject>();


    public void tick()
    {
        for (GameObject thisObject : objects)
        {
            thisObject.tick(objects);
        }
    }

    public void render(Graphics g)
    {
        for (GameObject thisObject : objects)
        {
            thisObject.render(g);
        }
    }

    public void addObject(GameObject object)
    {
        objects.add(object);
    }

    public void removeObject(GameObject object)
    {
        objects.remove(object);
    }

}

