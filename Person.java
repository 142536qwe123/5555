public class Person {
    private Name name;
    private int age;
    private Gender gender;

    // 无参构造函数
    public Person() {
        // 可根据需要设置默认值，题目未明确，暂时设为空或默认值
        this.name = new Name();   // 默认 "Unknown Unknown"
        this.age = 0;
        this.gender = null;
    }

    // 构造函数，初始化年龄、性别、姓名
    public Person(int age, Gender gender, Name name) {
        this.age = age;
        this.gender = gender;
        this.name = name;
    }

    // 姓名访问器
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    // 可根据需要添加 age 和 gender 的访问器，题目未要求但为了完整性可加
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    // 无参数 talk 方法
    public void talk() {
        System.out.println("Hi, how is it going?");
    }

    // 带主题的 talk 方法
    public void talk(String topic) {
        System.out.println("Let's talk about " + topic + ".");
    }

    // 与另一人聊天
    public void chatWith(Person p, String topic) {
        // 调用者全名（复用 name 的 toString）
        String aName = this.name.toString();
        String bName = p.name.toString();
        System.out.println(aName + " to " + bName + ": Let's talk about " + topic + ".");
    }
}