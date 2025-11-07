package com.example.house;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = "*")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping
    public List<ServiceEntity> getAllServices() {
        return serviceService.getAllServices();
    }

    @GetMapping("/{id}")
    public ServiceEntity getServiceById(@PathVariable Long id) {
        return serviceService.getServiceById(id);
    }

    @GetMapping("/category/{category}")
    public List<ServiceEntity> getServicesByCategory(@PathVariable String category) {
        return serviceService.getServicesByCategory(category);
    }

    @GetMapping("/search")
    public List<ServiceEntity> searchServices(@RequestParam String keyword) {
        return serviceService.searchServices(keyword);
    }

    @GetMapping("/top-rated")
    public List<ServiceEntity> getTopRatedServices() {
        return serviceService.getTopRatedServices();
    }

    @PostMapping
    public ServiceEntity addService(@RequestBody ServiceEntity service) {
        return serviceService.addService(service);
    }

    @PutMapping("/{id}")
    public ServiceEntity updateService(@PathVariable Long id, @RequestBody ServiceEntity service) {
        return serviceService.updateService(id, service);
    }

    @DeleteMapping("/{id}")
    public String deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
        return "Service deleted successfully!";
    }

    // Health check endpoint
    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> healthCheck() {
        Map<String, Object> response = new HashMap<>();
        long count = serviceService.getAllServices().size();
        response.put("status", "OK");
        response.put("serviceCount", count);
        response.put("message", "Service API is running");
        return ResponseEntity.ok(response);
    }
}
