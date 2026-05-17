public class ElderTeacher extends Teacher {
    // 静态唯一实例
    private static ElderTeacher instance = null;

    // 私有构造函数：需要调用父类 Teacher 的构造方法
    private ElderTeacher(int age, Gender gender, Name name, String subject) {
        super(age, gender, name, subject);
    }

    // 全局访问点
    public static ElderTeacher getInstance() {
        if (instance == null) {
            // 此处使用默认值创建实例（可根据实际需求调整）
            Name defaultName = new Name("Elder", "Teacher");
            instance = new ElderTeacher(60, Gender.MALE, defaultName, "Senior Education");
        }
        return instance;
    }

    // 可选：重写 talk() 体现老年教师特色
    @Override
    public void talk() {
        System.out.println("Hi, how is your research going?");
    }

    // 可选：重写 toString() 增加标识
    @Override
    public String toString() {
        return super.toString() + " (ElderTeacher)";
    }
}