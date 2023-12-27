package com.education.ztu;

public class App {
    public static void main(String[] args) throws Exception {
        Person student = new Student("John", "Doe", 20, Gender.Male, Location.KYIV, "University of XYZ",
                "Computer Science", 2);

        Car teacherCar = new Car("Honda", 2000);
        Person teacher = new Teacher("Jane", "Smith", 35, Gender.Female, Location.VINNYTSY, "University of ABC", "Math",
                teacherCar);

        Car employeeCar = new Car("Ford", 2015);
        Employee employee = new Employee("Developer", "Software Engineer", "XYZ Company", employeeCar);

        System.out.println("Student Info:");
        System.out.println(student.getFullInfo());
        student.whoIAm();
        Student.showCounter();
        System.out.println();

        System.out.println("Teacher Info:");
        System.out.println(teacher.getFullInfo());
        teacher.whoIAm();
        Teacher.showCounter();
        System.out.println();

        System.out.println("Employee Info:");
        System.out.println(employee.getFullInfo());
        employee.whoIAm();
        Employee.showCounter();
        System.out.println();

        teacherCar.getEngine().startEngine();
        System.out.println(String.format("Teacher car: %s", teacherCar.getFullInfo()));
        System.out.println(String.format("Employee car: %s", employeeCar.getFullInfo()));
        System.out.println();

        System.out.println(String.format("Teacher car is old: %s", teacherCar.isOldCar()));
        System.out.println(String.format("Employee car is old: %s", employeeCar.isOldCar()));
        System.out.println();

        employee.stopDriving();
        employee.startDriving();
        employee.getCar().getEngine().startEngine();
        employee.startDriving();
        employee.stopDriving();
        System.out.println();

        System.out.println(String.format("student is an instance of Person: %s", student instanceof Person));
        System.out.println(String.format("student is an instance of Teacher: %s", student instanceof Teacher));

        System.out.println(String.format("teacher is an instance of Human: %s", teacher instanceof Human));
        System.out.println(String.format("teacher is an instance of Student: %s", teacher instanceof Student));

        System.out.println(String.format("employee is an instance of Human: %s", employee instanceof Human));
    }
}