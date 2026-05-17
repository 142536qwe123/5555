public class TestSingleton {
    public static void main(String[] args) {
        ElderTeacher t1 = ElderTeacher.getInstance();
        ElderTeacher t2 = ElderTeacher.getInstance();

        System.out.println("t1 地址: " + System.identityHashCode(t1));
        System.out.println("t2 地址: " + System.identityHashCode(t2));
        System.out.println("是否为同一对象: " + (t1 == t2));

        // 调用方法验证功能
        t1.talk();
        System.out.println(t1);
    }
}