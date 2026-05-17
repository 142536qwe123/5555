public class Student extends Person {
    private String major;

    // 构造函数，使用 super 调用父类有参构造
    public Student(int age, Gender gender, Name name, String major) {
        super(age, gender, name);   // 调用 Person(int, Gender, Name)
        this.major = major;
    }

    // 重写 talk() 方法
    @Override
    public void talk() {
        System.out.println("Hi, how is your homework going?");
    }

    // 重写 toString() 方法，在父类信息基础上增加专业信息
    @Override
    public String toString() {
        // 获取父类的姓名、年龄、性别
        String nameStr = getName().toString();      // "First Last"
        int age = getAge();
        Gender gender = getGender();
        return nameStr + ", " + age + ", " + gender + ", Major: " + major;
    }

    // 可选：major 的访问器
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}