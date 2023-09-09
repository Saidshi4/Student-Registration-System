package main;

import util.InputUtil;
import util.MenuUtil;
import util.StudentUtil;


public class Main {
    public static void main(String[] args) {
        while(true){
            int menu = InputUtil.requireNumber("""
                    What do you to do?
                    1.Register Student
                    2.Show all students
                    3.Find student
                    4.Update Student
                    0.Exit""");
            MenuUtil.prosessMenu(menu);
        }
    }
}