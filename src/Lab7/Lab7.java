package Lab7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lab7 {

    public static void main(String[] args) {

                Institute inst = new Institute("ITS");

        Faculty tk = new Faculty("ТК");

        tk.addStudent(new Student("Юрій", "Батютенко", "CK31-001", 92));
        tk.addStudent(new Student("Володимир", "Бермічев", "CK31-002", 87));
        tk.addStudent(new Student("Назар", "Гришняков", "CK31-003", 90));
        tk.addStudent(new Student("Андрій", "Довгополюк", "CK31-004", 85));

        tk.addStudent(new Student("Олександр", "Арполенко", "CK32-001", 88));
        tk.addStudent(new Student("Іван", "Гуменюк", "CK32-002", 86));
        tk.addStudent(new Student("Данило", "Долгерт", "CK32-003", 84));
        tk.addStudent(new Student("Корольов", "Євгеній", "CK32-006", 95));

        inst.addFaculty(tk);

        Faculty ekir = new Faculty("ЕКІР");

        ekir.addStudent(new Student("Кіра", "Богдан", "CS31-001", 91));
        ekir.addStudent(new Student("Віталій", "Вінце", "CS31-002", 78));
        ekir.addStudent(new Student("Ілля", "Довбуш", "CS31-003", 83));
        ekir.addStudent(new Student("Михайло", "Неділько", "CS31-004", 97));

        inst.addFaculty(ekir);

        Faculty itt = new Faculty("ІТТ");

        itt.addStudent(new Student("Рустам", "Алієв", "CI31-001", 80));
        itt.addStudent(new Student("Гліб", "Бурлаков", "CI31-002", 89));
        itt.addStudent(new Student("Ігор", "Григор'єв", "CI31-003", 94));
        itt.addStudent(new Student("Даніїл", "Добровольський", "CI31-004", 98));

        inst.addFaculty(itt);

        int totalStudents = 0;
        for (Faculty fac : inst.getFaculties()) {
            for (Student st : fac.getStudents()) {
                totalStudents++;
            }
        }

        System.out.println("1) Загальна кількість студентів: " + totalStudents);

        Iterator<Faculty> facultyIterator = inst.getFaculties().iterator();

        Faculty maxFaculty = null;
        int maxCount = -1;

        while (facultyIterator.hasNext()) {
            Faculty fac = facultyIterator.next();
            int count = fac.getStudents().size();

            if (count > maxCount) {
                maxCount = count;
                maxFaculty = fac;
            }
        }

        System.out.println("2) Факультет з найбільшою кількістю студентів: "
                + maxFaculty.getName() + " (" + maxCount + " студентів)");

        List<Student> excellentStudents = new ArrayList<>();

        for (Faculty fac : inst.getFaculties()) {

            @SuppressWarnings("rawtypes")
            Iterator untypedIterator = fac.getStudents().iterator(); // untyped!

            while (untypedIterator.hasNext()) {
                Object obj = untypedIterator.next();
                Student st = (Student) obj;

                if (st.getAverageScore() >= 95 && st.getAverageScore() <= 100) {
                    excellentStudents.add(st);
                }
            }
        }

        System.out.println("3) Студенти з балом 95..100:");
        for (Student s : excellentStudents) {
            System.out.println("   - " + s);
        }
    }
}

class Student {
    private String name;
    private String surname;
    private String recordBook;
    private double averageScore;

    public Student(String name, String surname, String recordBook, double averageScore) {
        this.name = name;
        this.surname = surname;
        this.recordBook = recordBook;
        this.averageScore = averageScore;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public String getFullName() {
        return surname + " " + name;
    }

    @Override
    public String toString() {
        return getFullName() + " (" + recordBook + "), score=" + averageScore;
    }
}

class Faculty {
    private String name;
    private List<Student> students;

    public Faculty(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }
}

class Institute {
    private String name;
    private List<Faculty> faculties;

    public Institute(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty f) {
        faculties.add(f);
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }
}