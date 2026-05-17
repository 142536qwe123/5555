public class TestTalk {
    public static void main(String[] args) {
        Name name = new Name("Alice", "Johnson");
        Person p = new Student(20, Gender.FEMALE, name, "CS");

        p.talk();          // 调用 Student 重写的 talk()
        p.talk("Math");    // 调用 Person 继承来的 talk(String)
    }
}