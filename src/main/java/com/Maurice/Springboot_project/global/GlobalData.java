package com.Maurice.Springboot_project.global;


import com.Maurice.Springboot_project.model.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Product> cart;

    static {
        cart = new ArrayList<Product>();
    }
}
