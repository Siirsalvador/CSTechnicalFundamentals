package ChiPractice.GS.Eng2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-03
 */

class Student implements Comparable<Student> {
    private int idx;
    private int score;

    Student(int idx, int score) {
        this.idx = idx;
        this.score = score;
    }

    int getIdx() {
        return this.idx;
    }

    void setScore(int score) {
        this.score = this.score + score;
    }

    @Override
    public int compareTo(Student o) {
        int sameScore = o.score - this.score;
        return sameScore == 0 ? this.idx - o.idx : sameScore;
    }
}

public class FindTheRank {

    public static int findTheRank(List<List<Integer>> values, int rank) {

        HashMap<Integer, Student> idxToStd = new HashMap<>();
        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < values.size(); i++) {

            Student student;

            if (idxToStd.containsKey(i)) {
                student = idxToStd.get(i);
            } else {
                student = new Student(i, 0);
            }

            List<Integer> scores = values.get(i);

            for (Integer score : scores) {
                student.setScore(score);
            }

            idxToStd.put(i, student);
            students.add(student);

        }

        Collections.sort(students);

        Student student = students.get(rank - 1);
        return student.getIdx();

    }

    public static void main(String[] args) {

        List<Integer> scores1 = new ArrayList<>();
        scores1.add(79);
        scores1.add(89);
        scores1.add(15);

        List<Integer> scores2 = new ArrayList<>();
        scores2.add(85);
        scores2.add(89);
        scores2.add(92);

        List<Integer> scores3 = new ArrayList<>();
        scores3.add(71);
        scores3.add(96);
        scores3.add(88);

        List<List<Integer>> studentScores = new ArrayList<>();
        studentScores.add(scores1);
        studentScores.add(scores2);
        studentScores.add(scores3);

        System.out.println(findTheRank(studentScores, 2));

        List<Integer> scores4 = new ArrayList<>();
        scores4.add(80);
        scores4.add(96);
        scores4.add(81);
        scores4.add(77);

        List<Integer> scores5 = new ArrayList<>();
        scores5.add(78);
        scores5.add(71);
        scores5.add(93);
        scores5.add(75);

        List<Integer> scores6 = new ArrayList<>();
        scores6.add(71);
        scores6.add(98);
        scores6.add(70);
        scores6.add(95);

        List<Integer> scores7 = new ArrayList<>();
        scores7.add(80);
        scores7.add(96);
        scores7.add(89);
        scores7.add(77);

        List<List<Integer>> studentScores2 = new ArrayList<>();
        studentScores2.add(scores4);
        studentScores2.add(scores5);
        studentScores2.add(scores6);
        studentScores2.add(scores7);

        System.out.println(findTheRank(studentScores2, 3));

    }
}
