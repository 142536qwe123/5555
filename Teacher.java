public class Teacher extends Person {
    private String subject;   // 教学科目

    // 构造函数，使用 super 调用父类有参构造
    public Teacher(int age, Gender gender, Name name, String subject) {
        super(age, gender, name);   // 调用 Person(int, Gender, Name)
        this.subject = subject;
    }

    // 重写 talk() 方法
    @Override
    public void talk() {
        System.out.println("Hi, how is your paper going?");
    }

    // 重写 toString() 方法，增加教学科目信息
    @Override
    public String toString() {
        String nameStr = getName().toString();      // "First Last"
        int age = getAge();
        Gender gender = getGender();
        return nameStr + ", " + age + ", " + gender + ", Subject: " + subject;
    }

    // subject 的访问器（可选）
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}