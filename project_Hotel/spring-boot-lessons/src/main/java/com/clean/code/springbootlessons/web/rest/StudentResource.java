package com.clean.code.springbootlessons.web.rest;

import com.clean.code.springbootlessons.model.Student;
import com.clean.code.springbootlessons.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {

    private static StudentRepository studentRepository;

    public static void setStudentRepository(StudentRepository studentRepository) {
        StudentResource.studentRepository = studentRepository;
    }

    @GetMapping("students/all")
    public ResponseEntity<?> getAll() {
        Student student1 = new Student(1L, "Aziz", "Abdullayev","3-kurs");
        Student student2 = new Student(2L, "Jasur", "Mavlonov","1-kurs");
        Student student3 = new Student(3L, "Samandar", "Mo'minov","4-kurs");

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        return ResponseEntity.ok(students);
    }


    @GetMapping("/students/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {

        Student student = new Student(id, "Aziz", "Abdullayev","3-kurs");

        return ResponseEntity.ok(student);

    }

    @PostMapping("/students")
    public ResponseEntity create(@RequestBody Student student) {
        Student student1 = new Student(student.getId(), student.getName(), student.getLastName(), student.getCourse());
        studentRepository.save(student1);
        return ResponseEntity.ok(student1);
    }

    @GetMapping("/students")
    public ResponseEntity getOne(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String lastName,
                                 @RequestParam String course) {

        Student student = new Student(id, name, lastName,course);

        return ResponseEntity.ok(student);

    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.ok("Malumot o'chirildi");
    }

    @PutMapping("/students/{id}")
    public ResponseEntity update( @PathVariable Long id,
                                  @RequestBody Student studentNew) {
        Student student = new Student(1L, "Aziz", "Abdullayev","3-kurs");
        student.setId(id);
        student.setCourse(student.getCourse());
        student.setName(studentNew.getName());
        return ResponseEntity.ok(student);
    }


//     2 - usul
//    @GetMapping("/student")
//    public String hello() {
//        return "Hello World";
//    }
//
//
//     1 - usul
//        @RequestMapping(value = "/student", method = RequestMethod.GET)
//        public String hello() {
//            return "Hello World";
//        }



}
