import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Discussion {
    private List<Person> members;
    private Random random;

    // 预定义一些话题，用于群聊
    private static final String[] TOPICS = {
        "Java programming", "sports", "movies", "music", 
        "travel", "food", "technology", "homework", "exam"
    };

    public Discussion() {
        members = new ArrayList<>();
        random = new Random();
    }

    // 添加一个人到讨论组
    public void addPerson(Person p) {
        if (p != null) {
            members.add(p);
        }
    }

    // 模拟群聊：随机选一个发言者，对其他人逐一调用 chatWith
    public void broadcast() {
        if (members.size() < 2) {
            System.out.println("讨论组人数不足两人，无法进行群聊。");
            return;
        }

        // 随机选择一个发言者
        int speakerIndex = random.nextInt(members.size());
        Person speaker = members.get(speakerIndex);

        // 随机选择一个话题
        String topic = TOPICS[random.nextInt(TOPICS.length)];

        System.out.println("===== 群聊开始 =====");
        System.out.println("发言者：" + speaker.getName().toString());
        System.out.println("话题：" + topic);
        System.out.println("-------------------");

        // 发言者对每个其他人调用 chatWith
        for (Person listener : members) {
            if (listener != speaker) {   // 不对自己说话
                speaker.chatWith(listener, topic);
            }
        }
        System.out.println("===== 群聊结束 =====");
    }

    // 可选：返回成员数量
    public int size() {
        return members.size();
    }

    // 可选：打印所有成员信息
    public void listMembers() {
        System.out.println("当前讨论组成员：");
        for (int i = 0; i < members.size(); i++) {
            System.out.println((i+1) + ". " + members.get(i));
        }
    }
}