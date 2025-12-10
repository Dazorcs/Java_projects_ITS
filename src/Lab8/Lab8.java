package Lab8;

import java.util.*;

public class Lab8 {

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

        Set<Student> excellentStudents = new HashSet<>();
        for (Faculty fac : inst.getFaculties()) {
            @SuppressWarnings("rawtypes")
            Iterator untypedIterator = fac.getStudents().iterator();
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

        System.out.println("\n=== Функціональність ===");
        Map<String, Student> studentRegistry = inst.getStudentRegistry();
        System.out.println("4) Реєстр студентів (всього записів: " + studentRegistry.size() + ")");

        String searchRecordBook = "CS31-004";
        Student foundStudent = studentRegistry.get(searchRecordBook);
        if (foundStudent != null) {
            System.out.println("   Знайдено студента з номером " + searchRecordBook + ": " + foundStudent);
        } else {
            System.out.println("   Студента з номером " + searchRecordBook + " не знайдено");
        }

        System.out.println("\n5) Статистика середніх балів по факультетах:");
        Map<String, Double> facultyAverages = inst.getFacultyAverageScores();
        for (Map.Entry<String, Double> entry : facultyAverages.entrySet()) {
            System.out.printf("   %s: %.2f%n", entry.getKey(), entry.getValue());
        }

        System.out.println("\n6) Спроба додати дублікат студента:");
        Student duplicate = new Student("Юрій", "Батютенко", "CK31-001", 92);
        boolean added = tk.addStudent(duplicate);
        System.out.println("   Дублікат додано: " + added);
        System.out.println("   Кількість студентів на ТК: " + tk.getStudents().size());
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

    public String getRecordBook() {
        return recordBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(recordBook, student.recordBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordBook);
    }

    @Override
    public String toString() {
        return getFullName() + " (" + recordBook + "), score=" + averageScore;
    }
}

class Faculty {
    private String name;
    private Set<Student> students;

    public Faculty(String name) {
        this.name = name;
        this.students = new HashSet<>();
    }

    public boolean addStudent(Student s) {
        return students.add(s);
    }

    public Set<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public double getAverageScore() {
        if (students.isEmpty()) return 0.0;
        double sum = 0;
        for (Student s : students) {
            sum += s.getAverageScore();
        }
        return sum / students.size();
    }
}

class Institute {
    private String name;
    private Set<Faculty> faculties;

    public Institute(String name) {
        this.name = name;
        this.faculties = new HashSet<>();
    }

    public void addFaculty(Faculty f) {
        faculties.add(f);
    }

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public Map<String, Student> getStudentRegistry() {
        Map<String, Student> registry = new HashMap<>();
        for (Faculty fac : faculties) {
            for (Student st : fac.getStudents()) {
                registry.put(st.getRecordBook(), st);
            }
        }
        return registry;
    }

    public Map<String, Double> getFacultyAverageScores() {
        Map<String, Double> averages = new HashMap<>();
        for (Faculty fac : faculties) {
            averages.put(fac.getName(), fac.getAverageScore());
        }
        return averages;
    }
}