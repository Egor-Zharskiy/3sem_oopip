import planes.Plane;

import java.io.*;
import java.util.ArrayList;

public class FileIO {
    public void View() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.bin"))) {

            ArrayList<Plane> planes = (ArrayList<Plane>) ois.readObject();
            ArrayList<Plane> airline = (ArrayList<Plane>) ois.readObject();
            System.out.println("список всех самолётов: " + planes);
            System.out.println("авиакомпания: " + airline);
        } catch (IOException e) {
            System.out.println("Файл не найден или пуст");
        } catch (ClassNotFoundException e) {
            System.out.println("Класс не найден");
        }

    }

    public void Write(ArrayList<Plane> planes, ArrayList<Plane> airline) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
            oos.writeObject(planes);
            oos.writeObject(airline);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<ArrayList<Plane>> Read() {
        ArrayList<Plane> planes = new ArrayList<>();
        ArrayList<Plane> airline = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.bin"))) {
            planes = (ArrayList<Plane>) ois.readObject();
            airline = (ArrayList<Plane>) ois.readObject();
        } catch (IOException e) {
            System.out.println("Файл не найден");
        } catch (ClassNotFoundException e) {
            System.out.println("Класс не найден");
        }
        ArrayList<ArrayList<Plane>> dessertList = new ArrayList<>();
        dessertList.add(planes);
        dessertList.add(airline);
        return dessertList;
    }
}
