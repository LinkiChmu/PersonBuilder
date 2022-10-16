public class Main {
    public static void main(String[] args) {
        Person person = new Person("Иван", "Прок", "Moscow", 32);
        System.out.println(person);

        System.out.println(person.hasAddress());
        person.setAddress("Moscow");

        System.out.println(person.hasAge());
        person.happyBirthday();

        System.out.println(person);

        System.out.println(person.hashCode());

    }
}
