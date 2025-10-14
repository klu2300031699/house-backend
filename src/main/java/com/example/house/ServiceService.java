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
            existing.setShortDescription(newData.getShortDescription());
            existing.setLongDescription(newData.getLongDescription());
            existing.setPrice(newData.getPrice());
            existing.setIcon(newData.getIcon());
            existing.setCategory(newData.getCategory());
            existing.setImage(newData.getImage());
            existing.setGradient(newData.getGradient());
            existing.setFeatured(newData.isFeatured());
            existing.setIncludes(newData.getIncludes());
            return repository.save(existing);
        }
        return null;
    }

    public void deleteService(Long id) {
        repository.deleteById(id);
    }
}
