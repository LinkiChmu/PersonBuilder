import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected String city;
    protected OptionalInt age;

    public Person(String name, String surname) {
        if (name == null || surname == null) {
            throw new IllegalArgumentException("Не хватает данных. Обязательные поля: 'name', 'surname'");
        }
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, String city) {
        if (name == null || surname == null) {
            throw new IllegalArgumentException("Не хватает данных. Обязательные поля: 'name', 'surname'");
        }
        this.name = name;
        this.surname = surname;
        this.city = city;
    }

    public Person(String name, String surname, String city, int age) {
        if (name == null || surname == null) {
            throw new IllegalArgumentException("Не хватает данных. Обязательные поля: 'name', 'surname'");
        }
        this.name = name;
        this.surname = surname;
        this.city = city;
        if (age >= 0 && age < 110) {
            this.age = OptionalInt.of(age);
        } else {
            throw new IllegalArgumentException("Недопустимый возраст");
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

    public int getAge() {
        if (age != null) {
            return age.getAsInt();
        }
        return -1;
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

    public PersonBuilder newChildBuilder(int age) {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAge(age)
                .setCity(this.city);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAge(0)
                .setCity(this.city);
    }

    @Override
    public String toString() {
        return name + " " + surname + ", " + age.getAsInt() + " лет, " + city;
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
