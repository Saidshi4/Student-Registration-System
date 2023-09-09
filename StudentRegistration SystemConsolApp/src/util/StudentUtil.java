package util;

import beans.Student;
import main.Config;

public class StudentUtil {
    public static Student fillStudent(){
        String name = MenuUtil.requireName();
        String surname = MenuUtil.requireSurname();
        int age = MenuUtil.requireAge();
        String className = MenuUtil.requireClassname();

        return new Student(name, surname, age, className);
    }
    public static void printAllRegisteredStudents(){
        if(Config.students == null) return;
        for(int i = 0; i< Config.students.length; i++){
            Student st = Config.students[i];
            System.out.println((1+i)+st.getFullInfo());
        }
    }

    public static void registerStudents(){
        int count = InputUtil.requireNumber("How many student will you register?");
        Config.students = new Student[count];

        for(int i = 0; i<count; i++) {
            System.out.println((i+1)+".Register");
            Config.students[i] = StudentUtil.fillStudent();
        }

        MenuUtil.showSuccessOpMessage();
        StudentUtil.printAllRegisteredStudents();
    }

    public static void findStudentsAndPrint(){
        String text = InputUtil.requireText("type, surname or className");
        Student[] result = findStudents(text);
        for (Student student : result) {
            System.out.println(student.getFullInfo());
        }
    }

    public static Student[] findStudents(String text){
        int count = 0;
        for(int i = 0; i<Config.students.length; i++){
            Student st = Config.students[i];
            if(st.getName().contains(text)||st.getSurname().contains(text)||st.getClassName().contains(text)){
                count++;
            }
        }

        Student[] result = new Student[count];
        int found = 0;
        for(int i = 0; i<Config.students.length; i++){
            Student st = Config.students[i];
            if(st.getName().contains(text)||st.getSurname().contains(text)||st.getClassName().contains(text)){
                result[found++] = st;
            }
        }
        return result;
    }

    public static void updateStudentWithNewObject(){
        StudentUtil.printAllRegisteredStudents();
        int i = InputUtil.requireNumber("Which parameter do you want to change");

        System.out.println("enter new information:");
        Config.students[i-1] = StudentUtil.fillStudent();
    }

    public static void updateStudentWithSameObject(){
        StudentUtil.printAllRegisteredStudents();
        int i = InputUtil.requireNumber("What person do you want to update?");

        System.out.println("enter new information");
        Student selectStudent = Config.students[i-1];
        String changeParams = InputUtil.requireText("Which parameter do you want to change example:'name','surname','age',className'");
        if(changeParams.contains("'name'")) selectStudent.setName(MenuUtil.requireName());
        if(changeParams.contains("'surname'")) selectStudent.setSurname(MenuUtil.requireSurname());
        if(changeParams.contains("'age'")) selectStudent.setAge(MenuUtil.requireAge());
        if(changeParams.contains("'className'")) selectStudent.setClassName(MenuUtil.requireClassname());
    }

    public static void updateStudentWithSplit(){
        StudentUtil.printAllRegisteredStudents();
        int index = InputUtil.requireNumber("What person do you want to update?");

        System.out.println("enter new information");
        Student selectStudent = Config.students[index-1];
        String changeParams = InputUtil.requireText("Which parameter do you want to change? example:name,surname,age,className");

        String[] parameters = changeParams.split(",");
        for (String param : parameters) {
            if (param.equalsIgnoreCase("name")) selectStudent.setName(MenuUtil.requireName());
            if (param.equalsIgnoreCase("surname")) selectStudent.setSurname(MenuUtil.requireSurname());
            if (param.equalsIgnoreCase("age")) selectStudent.setAge(MenuUtil.requireAge());
            if (param.equalsIgnoreCase("className")) selectStudent.setClassName(MenuUtil.requireClassname());
        }
    }
}
