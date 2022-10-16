import com.sun.source.tree.OpensTree;

import java.util.Optional;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected String city;
    protected OptionalInt age;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, String city) {
        this.name = name;
        this.surname = surname;
        this.city = city;
    }

    public Person(String name, String surname, String city, int age) {
        this.name = name;
        this.surname = surname;
        this.city = city;

        if (this.age == null || this.age.isEmpty()) {
            if (age >= 0) {
                this.age = OptionalInt.of(age);
            }
        }
    }
    public boolean hasAge() {
        return age != null;
    }
    public boolean hasAddress() {
        return city != null;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getCity() {
        return city;
    }
    public OptionalInt getAge() {
        return age;
    }

    public void happyBirthday() {
        if (age != null) {
            int currentAge = age.getAsInt();
            currentAge++;
            age = OptionalInt.of(currentAge);
        }
    }

    public void setAddress(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return '{' + name + " " + surname + ", "
                + age + " лет, " + city + '}';
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 *result + surname.hashCode();
        return result;




    }
}
