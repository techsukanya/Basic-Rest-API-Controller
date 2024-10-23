package com.javaSukanya.springboot.controller;

import com.javaSukanya.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Spring boot Rest API returns JAVA BEAN as a JSON to client
@RestController
public class StudentController {
    //http://localhost:8080/student
    @GetMapping("/student")
    public Student getStudent(){
        Student st = new Student(
                1,
                "Sudipta",
                "Biswas"

        );
        return st;
    }

    //That Returns List of JSON to the CLient

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> sts = new ArrayList<>();
        sts.add(new Student(1,"Sudipta","Biswas"));
        sts.add(new Student(2, "Sukanya","Saha"));
        sts.add(new Student(3, "Sayantan", "Saha"));

        return sts;
    }

    //Create Springboot REST API with Path Variable (@Path variable)
    //{id} -URI Template Variable
    //http://localhost:8080/students/1/sukanya/saha
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable ("id") int StudentId,
                                      @PathVariable ("first-name") String firstName,
                                      @PathVariable("last-name") String lastName){
        return new Student(StudentId, firstName, lastName);

    }

    //Springboot Rest API with Request Param
    //http://localhost:8080/students/query?id=1&firstName="Sukanya"&lastName="Saha"        (? query parameter)
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }

    //Springboot Rest API that handles HTTP POST request- creating new resource
    //@PostMapping annotation and @Requestbody annotation
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //Springboot Rest API Put Request that handles HTTP Put Request - updating exixting resource
    @PutMapping("students/update/{id}")
    public Student updateSTudent(@PathVariable int id,@RequestBody Student student){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //Spring boot REST API that handles HTTP DELETE Request - deleting the exsisting resource
    @DeleteMapping("students/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        return "Successfully deleted";
    }

    //


}
