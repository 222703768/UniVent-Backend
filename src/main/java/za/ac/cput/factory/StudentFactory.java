package za.ac.cput.factory;

import za.ac.cput.domain.RoleEnum;
import za.ac.cput.domain.Student;
import za.ac.cput.util.Helper;

public class StudentFactory {
    public static Student createStudent(String name,
                                         String email,
                                         String passwordHash,
                                         String phoneNumber,
                                         String studentNumber,
                                         String faculty,
                                         String department,
                                         int yearOfStudy) {
        if (Helper.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Name is required");
        }
        if (Helper.isNullOrEmpty(email) || !Helper.isValidEmail(email)) {
            throw new IllegalArgumentException("Valid email is required");
        }
        if (Helper.isNullOrEmpty(passwordHash)) {
            throw new IllegalArgumentException("Password hash is required");
        }
        if (!Helper.isValidPhone(phoneNumber)) {
            throw new IllegalArgumentException("Valid phone number is required");
        }
        if (Helper.isNullOrEmpty(studentNumber)) {
            throw new IllegalArgumentException("Student number is required");
        }
        if (Helper.isNullOrEmpty(faculty)) {
            throw new IllegalArgumentException("Faculty is required");
        }
        if (Helper.isNullOrEmpty(department)) {
            throw new IllegalArgumentException("Department is required");
        }
        if (!Helper.isPositive(yearOfStudy)) {
            throw new IllegalArgumentException("Year of study must be greater than 0");
        }
        return new Student.Builder().setUserId(Helper.generateId())
                .setName(name)
                .setEmail(email)
                .setPasswordHash(passwordHash)
                .setPhoneNumber(phoneNumber)
                .setStudentNumber(studentNumber)
                .setFaculty(faculty)
                .setDepartment(department)
                .setYearOfStudy(yearOfStudy)
                .setRole(RoleEnum.STUDENT)
                .build();
    }
}
