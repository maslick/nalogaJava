import io.maslick.haha.helper.ContextLoader;
import io.maslick.haha.helper.IFileLoader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class HahaTest {

    @Test
    public void haha() throws IOException {
        IFileLoader loader = new ContextLoader();
        List<String> strings = loader.getStringsFromFile("podatki-1.txt");

        List<Student> collection = strings.stream()
                .map(s -> s.split(":"))
                .map(s -> new Student(s[0], Integer.parseInt(s[1])))
                .collect(Collectors.toList());

        int maxScore = collection.stream().mapToInt(Student::getScore).max().orElse(-1);
        List<Student> best = collection.stream().filter(s -> s.score == maxScore).collect(Collectors.toList());

        System.out.println("Maximum " + maxScore + " so dosegli: ");
        best.forEach(student -> System.out.println(student.id));
    }

    class Student {
        int score;
        String id;

        String getId() {
            return id;
        }

        public int getScore() {
            return score;
        }

        public Student(String id, int score) {
            this.id = id;
            this.score = score;
        }
    }

}
