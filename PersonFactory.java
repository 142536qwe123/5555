import java.util.Random;

public class PersonFactory {
    // 预定义的姓名列表（名和姓分别存储）
    private static final String[] FIRST_NAMES = {
        "Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Henry", "Ivy", "Jack",
        "Kevin", "Lisa", "Mona", "Nick", "Olivia", "Paul", "Quinn", "Rose", "Sam", "Tina"
    };
    private static final String[] LAST_NAMES = {
        "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez",
        "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "Martin"
    };
    // 预定义的专业（针对 Student）
    private static final String[] MAJORS = {
        "Computer Science", "Mathematics", "Physics", "Chemistry", "Biology", 
        "Economics", "Psychology", "English Literature", "History", "Engineering"
    };
    // 预定义的科目（针对 Teacher）
    private static final String[] SUBJECTS = {
        "Mathematics", "Physics", "Chemistry", "Biology", "Computer Science",
        "English", "History", "Geography", "Art", "Music"
    };
    // 年龄范围（18~70）
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 70;

    private static final Random random = new Random();

    /**
     * 随机生成一个 Person 对象，可能是 Student 或 Teacher（各 50% 概率）
     */
    public static Person createRandomPerson() {
        // 1. 随机生成姓名
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName  = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        Name name = new Name(firstName, lastName);

        // 2. 随机生成年龄
        int age = MIN_AGE + random.nextInt(MAX_AGE - MIN_AGE + 1);

        // 3. 随机生成性别
        Gender gender = random.nextBoolean() ? Gender.MALE : Gender.FEMALE;

        // 4. 随机决定生成 Student 还是 Teacher
        boolean isStudent = random.nextBoolean();

        if (isStudent) {
            String major = MAJORS[random.nextInt(MAJORS.length)];
            return new Student(age, gender, name, major);
        } else {
            String subject = SUBJECTS[random.nextInt(SUBJECTS.length)];
            return new Teacher(age, gender, name, subject);
        }
    }
}