package za.ac.cput.service;

import za.ac.cput.domain.Student;

public interface IStudentService extends IService<Student, String>{
    Student findByStudentNumber(String studentNumber);
}
