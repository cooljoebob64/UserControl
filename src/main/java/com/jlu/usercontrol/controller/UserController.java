package com.jlu.usercontrol.controller;

import com.jlu.usercontrol.config.SwaggerConfig;
import com.jlu.usercontrol.model.User;
import com.jlu.usercontrol.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Api(tags = {SwaggerConfig.TAG_USERS})
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    @ApiOperation(value="Get the list of all users, optionally filtered by state", response=User.class, responseContainer = "List")
    public List<User> getUsers(@RequestParam(value = "state", required = false) String state) {
        if (state != null) {
            return (List<User>) userRepository.findByState(state);
        }
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    @ApiOperation(value="Get one particular user by specifying an Id", response=User.class)
    public Optional<User> getUserById(@PathVariable(value = "id") Long id) {
        return userRepository.findById(id);
    }

    @PostMapping("/users")
    @ApiOperation(value="Create a new user, pending validation")
    @ApiResponses(value={
            @ApiResponse(code=201, message="Created - Successfully created the new user"),
            @ApiResponse(code=400, message="Bad Request - Supplied User object did not pass validation")
    })
    public ResponseEntity<Void> createUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        if(userRepository.findById(user.getId()).isPresent()){
            bindingResult.rejectValue("userId", "error.userId", "User Id is already taken");
        }

        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    @ApiOperation(value="Update a user with a supplied object")
    public void updateUser(@PathVariable(value = "id") Long id, @RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping("/users/{id}")
    @ApiOperation(value="Delete a user based on Id number")
    public void deleteUser(@PathVariable(value = "id") Long id) {
        userRepository.deleteById(id);
    }
}
