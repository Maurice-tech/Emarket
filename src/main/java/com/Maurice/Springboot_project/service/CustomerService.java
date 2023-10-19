package com.Maurice.Springboot_project.service;

import com.Maurice.Springboot_project.model.CustomerModel;

public interface CustomerService {
    public CustomerModel registerUser(String userName, String email , String password);
    public String loginUser(String email, String password);

}
