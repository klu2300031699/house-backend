package com.example.house;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository repository;

    public List<ServiceEntity> getAllServices() {
        return repository.findAll();
    }

    public ServiceEntity getServiceById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ServiceEntity addService(ServiceEntity service) {
        return repository.save(service);
    }

    public ServiceEntity updateService(Long id, ServiceEntity newData) {
        ServiceEntity existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setTitle(newData.getTitle());
            existing.setImage(newData.getImage());
            existing.setCategory(newData.getCategory());
            existing.setBadge(newData.getBadge());
            existing.setBadgeColor(newData.getBadgeColor());
            existing.setRating(newData.getRating());
            existing.setReviews(newData.getReviews());
            existing.setPrice(newData.getPrice());
            existing.setDescription(newData.getDescription());
            existing.setFeatures(newData.getFeatures());
            return repository.save(existing);
        }
        return null;
    }

    public void deleteService(Long id) {
        repository.deleteById(id);
    }

    public List<ServiceEntity> getServicesByCategory(String category) {
        return repository.findByCategory(category);
    }

    public List<ServiceEntity> searchServices(String keyword) {
        return repository.searchByKeyword(keyword);
    }

    public List<ServiceEntity> getTopRatedServices() {
        return repository.findTop5ByOrderByRatingDesc();
    }
}
