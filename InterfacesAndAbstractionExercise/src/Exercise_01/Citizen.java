package Exercise_01;

public record Citizen(String name, int age, String id, String birthDate) implements Person, Birthable, Identifiable {
}
