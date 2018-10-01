import java.awt.Graphics;
import java.util.ArrayList;

public class Handler {
    public ArrayList<GameObject> objects = new ArrayList<GameObject>();


    public void tick() {
        for (GameObject thisObject : objects) {
            thisObject.tick(objects);
        }
    }

    public void render(Graphics g) {
        for (GameObject thisObject : objects) {
            thisObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        objects.add(object);
    }

    public GameObject getObject(GameObject obj) {

        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).equals(obj))
            {
                return objects.get(i);
            }

        }
        return null;
    }

    public void removeObject(GameObject object) {
        objects.remove(object);
    }

    public void setupWorld()
    {
        this.addObject(new Car(250,20, ObjectID.Car1));
        this.addObject(new Wall(100, 100, 20, 50, ObjectID.Wall));
    }

}

