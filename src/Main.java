import Controller.ControllerClass;
import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.Domain.Student;
import Model.FileModelClass;
import Model.ModelClass;
import Model.ModelClassHash;
import View.ViewClass;
import View.ViewClassEng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args)  {
        Student student1 = new Student("Vasilisa", 26);
        Student student2 = new Student("Karina", 25);
        Student student3 = new Student("Andrey", 22);
        Student student4 = new Student("Masha", 27);
        Student student5 = new Student("Irina", 28);
        Student student6 = new Student("Nikolay", 30);

        List<Student> studList = new ArrayList<>(); // список студентов в List
        studList.add(student1);
        studList.add(student2);
        studList.add(student3);

        HashMap<Integer,Student> studHash = new HashMap<Integer,Student>(); // список студентов в HashMap
        studHash.put(student4.getId(), student4);
        studHash.put(student5.getId(), student5);
        studHash.put(student6.getId(), student6);

        FileModelClass modelFile = new FileModelClass("StudentDB.csv"); // создание модели из списока студентов в файле
        //fmClass.saveAllStudentToFile(studList);
        iGetModel modelList = new ModelClass(studList); // создание модели из списока студентов (List)
        iGetModel modelHash = new ModelClassHash(studHash); // создание модели из списока студентов (HashMap)
        iGetView view;

        Scanner lan = new Scanner(System.in);
        System.out.println("1 - English, 2 - Русский"); //Выбор языка
        if (lan.nextInt() == 1){
            view = new ViewClassEng();
            ControllerClass.language = true;
        }else {
            view = new ViewClass();
        }
        ControllerClass controller = new ControllerClass(modelFile, view); // передача в контроллер модели и вида
        //controller.update();
        controller.run(); // запуск контроллера
    }
}