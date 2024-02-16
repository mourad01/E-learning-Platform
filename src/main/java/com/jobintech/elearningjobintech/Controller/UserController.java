package com.jobintech.elearningjobintech.Controller;

import com.jobintech.elearningjobintech.entities.Users;
import com.jobintech.elearningjobintech.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/user")
public class UserController {


   private final  UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping ("/")
    public String index(){
        return "Hello World";
    }

    @GetMapping  ("/findall")
    public List<Users> allUsers(){

        return userService.findAll() ;
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Users> findUser(@PathVariable Long id){
        Users user = userService.findById(id);
        if(user!=null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping ("/update/{id}")
    public Users updateUser(@PathVariable Long id,@RequestBody Users users){
        return userService.UpdateUser(id,users);
    }
    @PostMapping ("/add")
    public Users addUser(@RequestBody Users users){

        return userService.saveOrUpdate(users);
    }


    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){

        if(userService.deleteById(id)){
            System.out.println("User deleted");
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
