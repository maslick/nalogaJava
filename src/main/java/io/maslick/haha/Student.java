package io.maslick.haha;

public class Student {
    String id;
    int score;

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
