package Learn.entity;

public class Score<T> {
    String name;
    int age;
    T value;

    public Score(String name, int age, T value) {
        this.name = name;
        this.age = age;
        this.value = value;
    }

}
