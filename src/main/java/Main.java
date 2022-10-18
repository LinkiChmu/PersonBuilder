import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {

        Person mom = new PersonBuilder()
                .setName("Иван  ")
                .setSurname("Прок")
                .setAge(34)
                .setCity("Орёл")
                .build();
        Person son = mom.newChildBuilder(2)
                .setName("Матвей")
                .build();
        son.happyBirthday();
        System.out.println("У " + mom + " есть ребенок: " + son);

        try {
            new PersonBuilder()
                    .setSurname("Черноусов")
                    .setAge(60)
                    .build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            new PersonBuilder()
                    .setCity("Омск")
                    .setName("Игорь")
                    .setSurname("Морозов")
                    .setAge(-18)
                    .build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
