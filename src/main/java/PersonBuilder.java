public class PersonBuilder {
    protected String name;
    protected String surname;
    protected String city;
    protected int age = -1;

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
        return age;
    }

    public PersonBuilder setAge(int age) {
        if (age > 110 || age < 0) {
            throw new IllegalArgumentException("Возраст может быть от 0 до 110 лет");
        }
        this.age = age;
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
        Person person = new Person(name, surname);
        person.setAge(age);
        person.setCity(city);
        return person;
    }
}
