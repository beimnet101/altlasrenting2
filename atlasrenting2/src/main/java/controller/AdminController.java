package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Admin;
import model.SubAdmin;
import service.AdminService;
import service.SubAdminService;

@Controller
public class AdminController {
    
    @Autowired
    private AdminService adminService;
    
    @Autowired
    private SubAdminService subAdminService;
    
    @GetMapping("home/login")
    public String showLoginForm() {
        return "login";
    }
    
    @PostMapping("home/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        Admin admin = adminService.authenticate(username, password);
        if (admin != null) {
            model.addAttribute("admin", admin);
            return "adminDashboard";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
    
    @GetMapping("home/login/subadmins")
    public String getAllSubAdmins(Model model) {
        Iterable<SubAdmin> subAdmins = subAdminService.getAllSubAdmins();
        model.addAttribute("subAdmins", subAdmins);
        return "subAdminList";
    }
    
}

