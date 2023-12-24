package LeetCode.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Student {
    int number;
    String name;
    public Student(int number, String name){
        this.number = number;
        this.name = name;
    }
    public int getNumber(){
        return number;
    }
    public String getName(){
        return name;
    }

    public static void main(String[] args) {

        Student s1 = new Student(1, "Manir");
        Student s2 = new Student(2, "Mina");
        Student s3 = new Student(3, "Minam");
        Student s4 = new Student(4, "Minour");
        Comparator<Student>  studentComparator = new Comparator<Student>() {
            @Override
            public int compare(Student ss1, Student ss2) {
                return ss1.getNumber() - ss2.getNumber();
            }
        };
        PriorityQueue<Student> pq = new PriorityQueue<>(studentComparator);
        pq.offer(s4);
        pq.add(s2);
        pq.add(s3);
        pq.add(s1);
        while (!pq.isEmpty()){
            Student student = pq.remove();
            System.out.println(student.getNumber() + "-" + student.getName());
        }
    }
}
