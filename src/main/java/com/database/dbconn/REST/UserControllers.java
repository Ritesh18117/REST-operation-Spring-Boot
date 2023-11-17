package com.database.dbconn.REST;

import com.database.dbconn.dao.UserRepository;
import com.database.dbconn.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserControllers {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/test")
    public String hello(){
        return "Hello";
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAll(){
        List<User> list = (List<User>) userRepository.findAll();
        if(list.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") int id){
        Optional<User> user = userRepository.findById(id);
        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(user);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<User>> getByName(@PathVariable("name") String name){
        List<User> users = userRepository.findByName(name);
        if(users.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(users));
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<User>> getByCity(@PathVariable("city") String city){
        List<User> users = userRepository.findByCity(city);
        if(users.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(users));
    }

    @PostMapping("/newUser")
    public ResponseEntity<User> newUser(@RequestBody User user){
        try{
            userRepository.save(user);
            return ResponseEntity.of(Optional.of(user));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/deleteUser/{user_id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("user_id") int user_id){
        try{
            userRepository.deleteById(user_id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update/{user_id}")
    public ResponseEntity<User> updateUser(@PathVariable("user_id") int user_id, @RequestBody User user){
        try{
            user.setId_user(user_id);
            userRepository.save(user);
            return ResponseEntity.of(Optional.of(user));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
