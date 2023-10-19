package com.Maurice.Springboot_project.service.ServiceImpl;

import com.Maurice.Springboot_project.model.CustomerModel;
import com.Maurice.Springboot_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements com.Maurice.Springboot_project.service.CustomerService {
    private final UserRepository userRepository;

    @Autowired
    public CustomerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CustomerModel registerUser(String userName, String email, String password) {
        if (userName == null || password == null) {
            return null;
        }
        else {
            if (userRepository.findFirstByUserName(userName).isPresent()){
                System.out.println("User Already Exist");
                return null;
            }

            CustomerModel user = new CustomerModel();

            user.setUserName(userName);
            user.setEmail(email);
            user.setPassword(password);
            userRepository.save(user);

            return user;
        }
    }

    @Override
    public String loginUser(String email, String password) {
        if (email == null || password == null) {
            // Invalid credentials, return the login page URL
            return "login_page";
        }
        else {
            // Attempt to find a user with the provided email in the repository
            CustomerModel user = userRepository.findByEmailAndPassword(email, password);

            // If a user with the given email is found and the password matches
            if (user != null) {
                // Return the home page URL
                return "redirect:/";
            } else {
                // Authentication failed, return the login page URL
                return "redirect:/login";
            }
        }
    }
}
