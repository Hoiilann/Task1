
import java.util.ArrayList;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int course;
        System.out.println("Список студентов:");
        ArrayList<Student> students = Student.Initialization();
        Student.print(students);
        System.out.println("\nПосле отчисления:");
        students=Student.removingStudents(students);
        Student.print(students);
        course = rand.nextInt(5)+1;
        System.out.println("\nСтуденты "+ course + " курса:");
        Student.printStudents(students,course);
    }
}