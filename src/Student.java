import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
public class Student {
    private final String name,group;
    private int course;
    private final double averageMark;
    public Student(String name, String group, int course, double averageMark) {
        this.course = course;
        this.averageMark = averageMark;
        this.group = group;
        this.name = name;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public static ArrayList<Student> Initialization(){
        String name,group;
        int course, counter = 0;
        double averageMark;
        Random rand = new Random();
        ArrayList<Student> students = new ArrayList<>();
        String[] names = {"Леонардо ДиКаприо","Райан Гослинг","Джонни Депп","Киану Ривз","Роберт Паттисон", "Генри Кавилл", "Брэд Питт","Кристиан Бэйл"};
        String[] groups={"C-","Б-"};
        name = names[rand.nextInt(8)];
        group = groups[rand.nextInt(2)]+(rand.nextInt(200)+1);
        course = rand.nextInt(5)+1;
        averageMark = 2*rand.nextDouble()+3;
        students.add(new Student(name,group,course,averageMark));
        while(students.size()<8){
            name = names[rand.nextInt(8)];
            group = groups[rand.nextInt(2)]+(rand.nextInt(200)+1);
            course = rand.nextInt(5)+1;
            averageMark = 2*rand.nextDouble()+3;
            for (int i =0;i<students.size();i++){
                if (name.equals(students.get(i).getName())){
                    counter = 1;
                }
            }
            if (counter==0){
                students.add(new Student(name,group,course,averageMark));
            }
            counter = 0;
        }
        return students;
    }
    public static ArrayList<Student> removingStudents (ArrayList<Student> students){
        for (int i=0;i<students.size();i++){
            if (students.get(i).getAverageMark()<3){
                students.remove(i);
                i--;
            } else {
                students.get(i).setCourse(students.get(i).getCourse()+1);
            }
        }
        return students;
    }
    public static void print(ArrayList<Student> students){
        DecimalFormat decimalFormat = new DecimalFormat( "#.##" );
        System.out.printf("%-20s%15s%10s%15s%n","Фамилия и Имя","Группа","Курс","Средний балл");
        for (int i =0;i<students.size();i++){
            System.out.printf("%-20s%15s%10s%15s%n", students.get(i).getName(),
                     students.get(i).getGroup(), students.get(i).getCourse(), decimalFormat.format(students.get(i).getAverageMark()));
        }
    }

    public static void printStudents (ArrayList<Student> students, int course){
        DecimalFormat decimalFormat = new DecimalFormat( "#.##" );
        int counter = 0;
        System.out.printf("%-20s%15s%10s%15s%n","Фамилия и Имя","Группа","Курс","Средний балл");
        for (int i =0;i<students.size();i++){
            if (students.get(i).getCourse()==course){
                counter+=1;
                System.out.printf("%-20s%15s%10s%15s%n", students.get(i).getName(),
                        students.get(i).getGroup(), students.get(i).getCourse(), decimalFormat.format(students.get(i).getAverageMark()));
            }
        }
        if (counter==0) {
            System.out.println("Студентов данного курса в списке нет");
        }
    }

    public double getAverageMark() {
        return averageMark;
    }

    public int getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }
}
