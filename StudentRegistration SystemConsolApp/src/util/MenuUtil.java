package util;

public class MenuUtil {
        public static void prosessMenu(int selectMenu) {

        switch(selectMenu){
            case 1 -> StudentUtil.registerStudents();
            case 2 -> StudentUtil.printAllRegisteredStudents();
            case 3 -> StudentUtil.findStudentsAndPrint();
            case 4 -> StudentUtil.updateStudentWithSameObject();
            case 0 -> System.exit(0);
        }
    }
    public static String requireName(){
            return InputUtil.requireText("enter name");
    }
    public static String requireSurname(){
        return InputUtil.requireText("enter surname");
    }
    public static int requireAge(){
        return InputUtil.requireNumber("enter age");
    }
    public static String requireClassname(){
        return InputUtil.requireText("enter className");
    }
    public static void showSuccessOpMessage(){
        System.out.println("Operation completed successfully");
    }
}
