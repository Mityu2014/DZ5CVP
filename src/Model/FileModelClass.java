package Model;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static Controller.ControllerClass.language; // флаг языка

/**
 * Класс для модели обработки команд списка студентов полученных из файла
 */
public class FileModelClass implements iGetModel {
    private String fileName; // имя файла

    /**
     * Комструктор класса со всеми параметрами
     * @param fileName имя файла
     */
    public FileModelClass(String fileName) {
        this.fileName = fileName;

        try(FileWriter fw = new FileWriter(fileName, true)) //чтение фыйла без перезаписи
        {
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод сохранения списока студентов в файл
     * @param students список студентов
     */
    public void saveAllStudentToFile(List<Student> students)
    {
        try(FileWriter fw = new FileWriter(fileName, false))//чтение фыйла с перезаписью
        {
            for(Student pers : students)
            {
                fw.write(pers.getName()+" "+pers.getAge()+" "+pers.getId());
                fw.append('\n');
            }
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод возвращающий весь список студентов
     * @return список студентов
     */
    @Override
    public List<Student> getAllStudents() {
        List<Student> students  = new ArrayList<Student>();
        try
        {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line!=null)
            {
                String[] param = line.split(" ");
                Student pers = new Student(param[0], Integer.parseInt(param[1]));
                pers.setId(Integer.parseInt(param[2]));
                students.add(pers);
                line = reader.readLine();
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return students;
    }

    /**
     * Метод для удаления студента из списка через ID
     * @param id студента для удаления
     */
    @Override
    public void delStudent(Integer id) {
        List<Student> students = getAllStudents();// получение списка студентов из файла
        boolean b = students.removeIf(student -> student.getId() == id);//проверка налисие записи/студента в списке (по ID)
                                                                        // и удаление записи/сдудента из списка
        if (!b){
            if (language){
                System.out.println("С таким ID студента нет");
            }else {
                System.out.println("There is no student with this ID");
            }
        }
        saveAllStudentToFile(students); // перезапись файла
    }
}
