// Gender 枚举
enum Gender {
    MALE, FEMALE
}

// Name 类
class Name {
    private String firstName;
    private String lastName;

    public Name() {
        this("Unknown", "Unknown");
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

// Person 类
class Person {
    private Name name;
    private int age;
    private Gender gender;

    public Person() {
        this.name = new Name();
        this.age = 0;
        this.gender = null;
    }

    public Person(int age, Gender gender, Name name) {
        this.age = age;
        this.gender = gender;
        this.name = name;
    }

    public Name getName() { return name; }
    public void setName(Name name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }

    public void talk() {
        System.out.println("Hi, how is it going?");
    }

    public void talk(String topic) {
        System.out.println("Let's talk about " + topic + ".");
    }

    public void chatWith(Person p, String topic) {
        String aName = this.name.toString();
        String bName = p.name.toString();
        System.out.println(aName + " to " + bName + ": Let's talk about " + topic + ".");
    }

    @Override
    public String toString() {
        return name.toString() + ", " + age + ", " + gender;
    }
}

// Student 类
class Student extends Person {
    private String major;

    public Student(int age, Gender gender, Name name, String major) {
        super(age, gender, name);
        this.major = major;
    }

    @Override
    public void talk() {
        System.out.println("Hi, how is your homework going?");
    }

    @Override
    public String toString() {
        return super.toString() + ", Major: " + major;
    }
}

// Teacher 类
class Teacher extends Person {
    private String subject;

    public Teacher(int age, Gender gender, Name name, String subject) {
        super(age, gender, name);
        this.subject = subject;
    }

    @Override
    public void talk() {
        System.out.println("Hi, how is your paper going?");
    }

    @Override
    public String toString() {
        return super.toString() + ", Subject: " + subject;
    }
}

// 测试动态绑定的主类
public class TestPolymorphism {
    public static void main(String[] args) {
        // 创建 Name 对象
        Name name1 = new Name("Alice", "Johnson");
        Name name2 = new Name("Bob", "Smith");
        Name name3 = new Name("Charlie", "Brown");

        // 创建三种 Person 类型的对象
        Person student = new Student(20, Gender.FEMALE, name1, "Computer Science");
        Person teacher = new Teacher(35, Gender.MALE, name2, "Mathematics");
        Person person  = new Person(25, Gender.MALE, name3);

        // 放入 Person 数组
        Person[] people = { student, teacher, person };

        // 遍历数组，调用 talk() 方法
        System.out.println("=== 动态绑定验证：调用 talk() ===");
        for (Person p : people) {
            p.talk();   // 实际执行哪个版本由对象的真实类型决定
        }

        // 额外打印对象信息，展示完整多态
        System.out.println("\n=== 对象详细信息 ===");
        for (Person p : people) {
            System.out.println(p.toString());
        }
    }
}