package io.maslick.haha;

import io.maslick.haha.helper.ContextLoader;
import io.maslick.haha.helper.IFileLoader;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class HahaTest {
    @Test
    public void haha() {
        // load file
        IFileLoader loader = new ContextLoader();
        List<String> strings = loader.getStringsFromFile("podatki-1.txt");

        // convert to Pojo
        List<Student> collection = strings.stream()
                .map(s -> s.split(":"))
                .map(s -> new Student(s[0], Integer.parseInt(s[1])))
                .collect(Collectors.toList());

        // find max score
        int maxScore = collection.stream().mapToInt(Student::getScore).max().orElse(-1);

        // filter out best students
        List<Student> best = collection.stream().filter(s -> s.score == maxScore).collect(Collectors.toList());

        // print result
        System.out.println("Maximum " + maxScore + " so dosegli:");
        best.forEach(student -> System.out.println(student.id));
    }
}

