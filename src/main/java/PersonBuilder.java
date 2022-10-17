import java.util.OptionalInt;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected String city;
    protected OptionalInt age;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (this.age == null) {
            this.age = OptionalInt.of(age);
        }
        return this;
    }

    public Person build() {
        if (name == null || name.isBlank()) {
            throw new IllegalStateException("Не заполнено поле 'name'");
        }
        if (surname == null || surname.isBlank()) {
            throw new IllegalStateException("Не заполнено поле 'surname'");
        }
        if (city == null || city.isBlank()) {
            throw new IllegalStateException("Не заполнено поле 'city'");
        }
        if (age == null) {
            throw new IllegalStateException("Не заполнено поле 'age'");
        }
        if (age.getAsInt() > 110 || age.getAsInt() < 0) {
            throw new IllegalArgumentException("Неправильно введён возраст: " + age.getAsInt());
        }
        return new Person(name, surname, city, age.getAsInt());
    }

}
