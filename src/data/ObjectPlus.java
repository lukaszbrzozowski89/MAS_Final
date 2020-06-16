package data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * The class which helps with extent management.
 *
 * @author Mariusz Trzaska
 * Fill free to send me any remarks: mtrzaska@pjwstk.edu.pl
 */
public class ObjectPlus implements Serializable {

    private static final long serialVersionUID = 11112L;

    private static Hashtable<Class<? extends ObjectPlus>, ArrayList<ObjectPlus>> extent = new Hashtable<>();

    public ObjectPlus() {
        ArrayList<ObjectPlus> ext;
        Class<? extends ObjectPlus> className = this.getClass();

        if (extent.containsKey(className)) {
            ext = extent.get(className);
        } else {
            ext = new ArrayList<>();
            extent.put(className, ext);
        }
        ext.add(this);
    }

    public static void saveExtent(ObjectOutputStream oos) throws IOException {
        oos.writeObject(extent);
    }

    public static void getExtent(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        extent = (Hashtable<Class<? extends ObjectPlus>, ArrayList<ObjectPlus>>) ois.readObject();
    }

    public static <T> void deleteExtension(T name) {
        List<T> list = (List<T>) extent.get(name.getClass());
        list.remove(name);
    }

    public static int extentSize(Class<? extends ObjectPlus> className) {
        int counter = 0;
        if (extent.containsKey(className)) {
            counter = extent.get(className).size();
        }
        System.out.println(" Extent " + className.getSimpleName() + " : " + counter);
        return counter;
    }

    public static void showExtent(Class<? extends ObjectPlus> className) throws Exception {
        ArrayList<ObjectPlus> extentList;

        if (extent.containsKey(className)) {
            extentList = extent.get(className);
        } else {
            throw new Exception("Unknown class " + className);
        }

        System.out.println("Extent of class: " + className.getSimpleName());

        for (Object obj : extentList) {
            System.out.println(obj + "\n");
        }
    }

    public static ArrayList<ObjectPlus> getExtent(Class<? extends ObjectPlus> className) throws Exception {
        ArrayList<ObjectPlus> extentList;

        if (extent.containsKey(className)) {
            extentList = extent.get(className);
        } else {
            throw new Exception("Unknown class " + className);
        }
        System.out.println(extentList);
        return extentList;
    }
}