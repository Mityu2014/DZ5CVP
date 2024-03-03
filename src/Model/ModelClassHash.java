package Model;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static Controller.ControllerClass.language; // флаг языка
/**
 * Класс для модели обработки команд списка студентов полученных из карты/словаря (HashMap)
 */
public class ModelClassHash implements iGetModel {
    public HashMap <Integer,Student> setStudHash; // список студентов
    /**
     * Конструктор класса с параметрами
     * @param studHash список студентов в виде словаря
     */
     public ModelClassHash(HashMap<Integer, Student> studHash) {
        this.setStudHash = new HashMap<>(studHash);

    }

    /**
     * Метод возвращающий весь список студентов
     * @return список студентов
     */
    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<Student>();
        for (Student val : this.setStudHash.values()) {
            students.add(val);
        }
        return students;
    }
    /**
     * Метод для удаления студента из списка через ID
     * @param id студента для удаления
     */
    @Override
    public void delStudent(Integer id) {
        if (setStudHash.containsKey(id)) {
            setStudHash.remove(id);
        }else {
            if (language){
                System.out.println("С таким ID студента нет");
            }else {
                System.out.println("There is no student with this ID");
            }
        }

    }
}
