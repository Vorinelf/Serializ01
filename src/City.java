import java.io.Serializable;

public class City implements Serializable {
    private String name;
    private int age;
    private int area;
    private transient int secretcode;

    public City(String name, int age, int area, int secretcode) {
        this.name = name;
        this.age = age;
        this.area = area;
        this.secretcode = secretcode;
    }

    String getName() {
        return name;
    }

    String getAge() {
        return String.valueOf(age);
    }

    double getArea() {
        return area;
    }

    int getSecretcode() {
        return secretcode;
    }
}
