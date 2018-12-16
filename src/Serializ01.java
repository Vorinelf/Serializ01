import java.io.*;
import java.util.ArrayList;

public class Serializ01 {
    public static void main(String[] args) {
        File file = new File("src/city.dat");
        ArrayList<City> al = new ArrayList<>();
        al.add(new City("Minsk", 870, 350, 1));
        al.add(new City("Gomel", 900, 340, 1));
        al.add(new City("Mogilev", 850, 330, 1));

        try (ObjectOutputStream oops = new ObjectOutputStream(new FileOutputStream(file))) {
            oops.writeObject(al);
            System.out.println("Serializable....... ");
            System.out.println("I wrote in the file");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<City> newCity = new ArrayList<City>();
        try (ObjectInputStream oips = new ObjectInputStream(new FileInputStream(file))) {
            newCity = ((ArrayList<City>) oips.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("I am reading from the file");
        for (City n : newCity) {
            System.out.printf("Name: %s \t Age: %s\t Area: %s \t Secretcode: %s\n", n.getName(), n.getAge(), n.getArea(), n.getSecretcode());
        }

        System.out.println("Serializable OK!  ");
    }
}
