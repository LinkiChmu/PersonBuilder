import java.util.OptionalInt;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected String city;
    protected OptionalInt age;

    public PersonBuilder setName(String name) {
        this.name = name.trim();
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname.trim();
        return this;
    }

    public PersonBuilder setCity(String city) {
        this.city = city.trim();
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (this.age == null) {
            if (age > 110 || age < 0) {
                throw new IllegalArgumentException("Неправильно введён возраст: " + age);
            }
            this.age = OptionalInt.of(age);
        }
        return this;
    }

    public Person build() {
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Не заполнено имя");
        }
        if (surname == null || surname.isEmpty()) {
            throw new IllegalStateException("Не заполнена фамилия");
        }
        if (city == null || city.isEmpty()) {
            throw new IllegalStateException("Не заполнен город");
        }
        if (age == null) {
            throw new IllegalStateException("Не заполнен возраст");
        }
        return new Person(name, surname, city, age.getAsInt());
    }
}
