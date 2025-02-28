package com.BetterGREwords.controller;

import com.BetterGREwords.model.Users;
import com.BetterGREwords.service.UserService;
import com.BetterGREwords.utils.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    /**
     * Create a new user by instance
     * for example: POST http://127.0.0.1:8080/api/user/createUser/properties?name=John&password=123456&email=test2@test.com
     */
    @PostMapping("/createUser/properties")
    public ResponseEntity<?> createUserByProperties(
            @RequestParam String name,
            @RequestParam String password,
            @RequestParam String email) {
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            ErrorResponse errorResponse = new ErrorResponse("Invalid email format", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        if(userService.isEmailPresent(email)) {
            ErrorResponse errorResponse = new ErrorResponse("Email already exists", HttpStatus.CONFLICT.value());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        }
        if(name.isEmpty() || password.isEmpty() || email.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse("Name, password or email cannot be empty", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        if(password.length() < 3 || password.length() > 20) {
            ErrorResponse errorResponse = new ErrorResponse("Password length should be between 3 and 20", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        String encryptedPassword = hashPassword(password);
        Users createdUser = userService.createUser(name, encryptedPassword, email);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PostMapping("/loginByEmail")
    public ResponseEntity<?> registerByEmail(@RequestParam String email, @RequestParam String password) {
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            ErrorResponse errorResponse = new ErrorResponse("Invalid email format", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        if(!userService.isEmailPresent(email)) {
            ErrorResponse errorResponse = new ErrorResponse("Email do not exist", HttpStatus.CONFLICT.value());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        }
        if(password.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse("Password cannot be empty", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        if(password.length() < 3 || password.length() > 20) {
            ErrorResponse errorResponse = new ErrorResponse("Password length should be between 3 and 20", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        String encryptedPassword = hashPassword(password);
        Users user = userService.getUserByEmail(email);
        if(!user.getPasswordHash().equals(encryptedPassword)) {
            ErrorResponse errorResponse = new ErrorResponse("Password is incorrect", HttpStatus.UNAUTHORIZED.value());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
}
