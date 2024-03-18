import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class student {
    private String name;
    private String program;
    private String semester;
    private List<Course> registeredCourses;

    public student(String name, String program, String semester) {
        this.name = name;
        this.program = program;
        this.semester = semester;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Program: " + program);
        System.out.println("Semester: " + semester);
        System.out.println("Courses Registered:");
        for (Course course : registeredCourses) {
            System.out.println(course.getName());
        }
    }

    public void printLowMarks() {
        System.out.println("Name: " + name);
        System.out.println("Program: " + program);
        System.out.println("Semester: " + semester);
        System.out.println("Courses with marks less than 40:");
        for (Course course : registeredCourses) {
            float mark = course.getMark(name);
            if (mark < 40) {
                System.out.println(course.getName() + " : " + mark);
            }
        }
    }

    // getters and setters for name, program, semester
}

class Course {
    private String name;
    private Map<String, Float> studentMarks;

    public Course(String name) {
        this.name = name;
        this.studentMarks = new HashMap<>();
    }

    public void addStudentMark(String studentName, float mark) {
        studentMarks.put(studentName, mark);
    }

    public String getName() {
        return name;
    }

    public float getMark(String studentName) {
        return studentMarks.get(studentName);
    }

    // getters and setters for name
}

class Main {
    public static void main(String[] args) {
        // create courses
        Course course1 = new Course("Machine Learning");
        Course course2 = new Course("Software Testing");
        Course course3 = new Course("C# Programming");

        // add student marks for each course
        course1.addStudentMark("Aisha", 88);
        course2.addStudentMark("Aisha", 35);
        course3.addStudentMark("Aisha", 38);

        // create student
        student stu = new student("Aisha", "BCA", "4th");

        // register courses for student
        stu.registerCourse(course1);
        stu.registerCourse(course2);
        stu.registerCourse(course3);

        // print registered courses
        stu.printDetails();

        // print low marks
        stu.printLowMarks();
    }
}