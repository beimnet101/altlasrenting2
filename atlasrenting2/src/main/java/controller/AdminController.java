package controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import model.RentalOwner;
import model.Product;
import model.ProductCategory;
import model.Renter;
import model.Admin;
import model.SubAdmin;
import repository.ProductCategoryRepository;
import service.AdminService;
import service.SubAdminService;
import service.RentalOwnerService;
import service.RenterService;
import service.ProductService;
import service.ProductCategoryService;
@RestController
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private AdminService adminService;
    
    @Autowired
    private SubAdminService subAdminService;
    @Autowired
    private RentalOwnerService RentalOwnerService;
    @Autowired
    private RenterService RenterService;
    
    @Autowired
    private ProductCategoryService productcategoryService;
    
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
      
    @DeleteMapping("/rental-owner/{rentalOwnerId}")
            public void deleteRentalOwnerAndProducts(@PathVariable Long roleId) {
                adminService.deleteRentalOwnerAndProducts(roleId);
    }


    @GetMapping("admin/rental-owners")
    public List<RentalOwner> getAllRentalOwners() {
        return RentalOwnerService.findAll();
    }

    @PostMapping("/admin/create/rental-owners")
    public RentalOwner createRentalOwner(@RequestBody RentalOwner rentalOwner) {
        return RentalOwnerService.save(rentalOwner);
    }

    @PutMapping("/update/rental-owners/{id}")
  //  public RentalOwner updateRentalOwner(@PathVariable Long id, @RequestBody RentalOwner rentalOwner) {
    //    return rentalOwnerService.updateRentalOwner(id, rentalOwner);
    //}

    @DeleteMapping("/admin/delete/rental-owners/{id}")
    public void deleteRentalOwner(@PathVariable Long id) {
        RentalOwnerService.deleteRentalOwner(id);
    }

    // Renter Endpoints

    @GetMapping("/admin/get/renters")
    public List<Renter> getAllRenters() {
        return RenterService.findAll();
    }

    @PostMapping("/admin/createrenters")
    public Renter createRenter(@RequestBody Renter renter) {
        return RenterService.save(renter);
    }

    

    @DeleteMapping("/renters/{id}")
    public void deleteRenter(@PathVariable Long id) {
        RenterService.deleteById(id);
    }


    @GetMapping("/admin/categories")
    public ResponseEntity<List<ProductCategory>> getAllProductCategories() {
        List<ProductCategory> categories = productcategoryService.getAllProductCategories();
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/add/categories")
    public ResponseEntity<ProductCategory> addProductCategory(@RequestBody ProductCategory productCategory) {
        ProductCategory createdCategory = productcategoryService.createProductCategory(productCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/update/categories/{categoryId}")
    public ResponseEntity<ProductCategory> updateProductCategory(
            @PathVariable Long categoryId, @RequestBody ProductCategory productCategory) {
        ProductCategory updatedCategory = productcategoryService.updateProductCategory(categoryId, productCategory);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/remove/categories/{categoryId}")
    public ResponseEntity<Void> removeProductCategory(@PathVariable Long categoryId) {
        productcategoryService.deleteProductCategory(categoryId);
        return ResponseEntity.noContent().build();
    }
}


   