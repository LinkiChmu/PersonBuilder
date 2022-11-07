import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected String city;
    protected int age = -1;

    public Person(String name, String surname) {
        if (name == null || surname == null) {
            throw new IllegalArgumentException("Не хватает данных. Обязательные поля: 'name', 'surname'");
        }
        this.name = name;
        this.surname = surname;
    }

    public boolean hasAge() {
        return age != -1;
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

    public void setCity(String city) {
        this.city = city;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public OptionalInt getAge() {
        return age != -1 ? OptionalInt.of(age) : OptionalInt.empty();
    }

    public void happyBirthday() {
        if (age != -1) {
            age++;
        }
    }

    public void setAddress(String city) {
        this.city = city;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(0)
                .setCity(city);
    }

    @Override
    public String toString() {
        return name + " " + surname + ", " + age + " лет, " + city;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Person p = (Person) obj;
        return Objects.equals(name, p.name) &&
                Objects.equals(surname, p.surname);
    }
}
