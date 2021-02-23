package com.bolero.boleroteam.controller;

import com.bolero.boleroteam.model.User;
import com.bolero.boleroteam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class UserRestController {
    @Autowired
    private UserService userService;
//
//    @PostMapping(value = "user/create",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Void> createSong(@RequestBody User user){
//        userService.save(user);
//        HttpHeaders headers = new HttpHeaders();
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }

    //    @GetMapping(value = "user")
//    public ResponseEntity<List<User>> listUsers(){
//        List<User> users;
//        users = userService.findAll();
//        if (users.isEmpty()){
//            return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
//        }else {
//            return new ResponseEntity<List<User>>(users,HttpStatus.OK);
//        }
//    }
//
//    @GetMapping(value = "user/{id}")
//    public ResponseEntity<User> findUserById(@PathVariable Long id){
//        Optional<User> user = userService.findById(id);
//        User user1 = user.get();
//        if (user1 == null){
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }else {
//            return new ResponseEntity<User>(user1,HttpStatus.OK);
//        }
//    }
//
//    @PutMapping("user/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
//        Optional<User> user1 = userService.findById(id);
//        User user2 = user1.get();
//        if (user2 == null){
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }else {
//            user2.setName(user.getName());
//            user2.setEmail(user.getEmail());
//            user2.setPhoneNumber(user.getPhoneNumber());
//            userService.save(user2);
//            return new ResponseEntity<User>(HttpStatus.OK);
//        }
//    }
//
//    @DeleteMapping("user/{id}")
//    public ResponseEntity<User> deleteUser(@PathVariable Long id){
//        Optional<User> user = userService.findById(id);
//        if (user == null){
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }else {
//            userService.remove(id);
//            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//        }
//    }
//
//    @PutMapping("user/{id}")
//    public ResponseEntity<User> updatePassword(@PathVariable Long id,@RequestBody User user){
//        Optional<User> user1 = userService.findById(id);
//        User user2 = user1.get();
//        if (user2 == null){
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }else {
//            user2.setPassword(user.getPassword());
//            userService.save(user2);
//            return new ResponseEntity<User>(user2,HttpStatus.OK);
//        }
//    }
//@PostMapping("/user/{id}")
//public void saveUser(@RequestBody User user) {
//    userService.save(user);
//}
//
//    @PutMapping("/user/{id}")
//    public void updateUser(@PathVariable(value = "id") Long id, @RequestBody User user) {
//        user.setId(id);
//        userService.save(user);
//    }
    @GetMapping("users/{username}")
    public ResponseEntity<User> findUserByUsername(@PathVariable("username") String username) {
        return new ResponseEntity<>(userService.findByUserName(username), HttpStatus.OK);
    }

    @PutMapping("users/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User user1 = userService.findByUserName(user.getUsername());
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setPhoneNumber(user.getPhoneNumber());
        userService.save(user1);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping(value = "user/create",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createSong(@RequestBody User user){
        userService.save(user);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "user")
    public ResponseEntity<List<User>> listUsers(){
        List<User> users;
        users = userService.findAll();
        if (users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<List<User>>(users,HttpStatus.OK);
        }
    }

    @GetMapping(value = "user/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        User user1 = user.get();
        if (user1 == null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<User>(user1,HttpStatus.OK);
        }
    }

    @PutMapping("user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
        Optional<User> user1 = userService.findById(id);
        User user2 = user1.get();
        if (user2 == null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }else {
            user2.setFirstName(user.getFirstName());
            user2.setLastName(user.getLastName());
            user2.setEmail(user.getEmail());
            user2.setPhoneNumber(user.getPhoneNumber());
            userService.save(user2);
            return new ResponseEntity<User>(HttpStatus.OK);
        }
    }

    @GetMapping("user/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        if (user == null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }else {
            userService.remove(id);
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
    }

//    @PutMapping("user/{id}")
//    public ResponseEntity<User> updatePassword(@PathVariable Long id,@RequestBody User user){
//        Optional<User> user1 = userService.findById(id);
//        User user2 = user1.get();
//        if (user2 == null){
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }else {
//            user2.setPassword(user.getPassword());
//            userService.save(user2);
//            return new ResponseEntity<User>(user2,HttpStatus.OK);
//        }
//    }
}
