//package com.Maurice.Springboot_project.controller.admin;
//
//import com.Maurice.Springboot_project.model.ViewProductModel;
//import com.Maurice.Springboot_project.service.ServiceImpl.AdminService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//public class ViewProductController {
//    private final AdminService adminService;
//
//    @Autowired
//    public ViewProductController(AdminService adminService) {
//        this.adminService = adminService;
//    }
//
//    @DeleteMapping("/products/{id}")
//    public String deleteProduct(@PathVariable Long id) {
//        // Call a service method to delete the product by ID
//        adminService.putProduct(deleteProduct());
//        return "redirect:/delete_products"; // Redirect back to the product list page
//    }
//
//    @GetMapping("/delete_products")
//    public String deleteProductView(Model model) {
//        // Retrieve all products from the service
//        List<ViewProductModel> products = adminService.getAllProduct();
//
//        // Add the products to the model for rendering in the HTML template
//        model.addAttribute("productsRequest", products);
//        return "deleteProduct"; // Assuming you have a Thymeleaf template named "deleteProduct.html"
//    }
//
//    @GetMapping("/products")   // Admin view product
//    public String listProducts(Model model) {
//        // Retrieve all products from the service
//        List<ViewProductModel> products = adminService.getAllProduct();
//
//        // Add the products to the model for rendering in the HTML template
//        model.addAttribute("productsRequest", products);
//        return "viewProduct"; // Assuming you have a Thymeleaf template named "viewProduct.html"
//    }
//
//    @PostMapping("/products")
//    public String processProductForm() {
//        return "redirect:/products";
//    }
//}
//
//
////    @DeleteMapping("/products/{id}")
////    public String deleteProduct(@PathVariable Long id) {
////        // Call a service method to delete the product by ID
////        adminService.deleteProductById(id);
////        return "redirect:/delete_products"; // Redirect back to the product list page
////    }
////
////    @GetMapping("/delete_products")
////    public String deleteProductView(Model model) {
////        // Retrieve all products from the service
////        List<ViewProductModel> products = adminService.getAllProduct();
////
////        // Add the products to the model for rendering in the HTML template
////        model.addAttribute("productsRequest", products);
////        return "deleteProduct"; // Assuming you have a Thymeleaf template named "product_list.html"
////    }
////
////
////    @GetMapping("/products")   //admin to view product
////    public String listProducts(Model model) {
////        // Retrieve all products from the service
////        List<ViewProductModel> products = adminService.getAllProduct();
////
////        // Add the products to the model for rendering in the HTML template
////        model.addAttribute("productsRequest", products);
////        return "viewProduct"; // Assuming you have a Thymeleaf template named "product_list.html"
////    }
////
////    @PostMapping("/products")
////    public String processProductForm() {
////        return "redirect:/products";
////    }
////}
