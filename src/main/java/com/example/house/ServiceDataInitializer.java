package com.example.house;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Component
@Order(2) // Run after DataInitializer (user admin)
public class ServiceDataInitializer implements CommandLineRunner {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("=== ServiceDataInitializer started ===");
        
        // Check if services already exist
        long count = serviceRepository.count();
        System.out.println("Current service count in database: " + count);
        
        if (count > 0) {
            System.out.println("Services already exist in database. Skipping initialization.");
            return;
        }

        System.out.println("Initializing services data...");

        // Service 1: Professional Plumbing
        ServiceEntity plumbing = new ServiceEntity();
        plumbing.setTitle("Professional Plumbing");
        plumbing.setImage("/plumbing.jpg");
        plumbing.setCategory("Repair");
        plumbing.setBadge("Popular");
        plumbing.setBadgeColor("blue");
        plumbing.setRating(4.8);
        plumbing.setReviews(245);
        plumbing.setPrice("$50 - $200");
        plumbing.setDescription("Expert leak fixes & installations. Professional plumbing solutions with advanced equipment and experienced technicians.");
        plumbing.setFeatures(Arrays.asList("Emergency service", "Leak detection", "Pipe installation", "Water heater repair"));

        // Service 2: Electrical Services
        ServiceEntity electrical = new ServiceEntity();
        electrical.setTitle("Electrical Services");
        electrical.setImage("/electical.jpg");
        electrical.setCategory("Repair");
        electrical.setBadge("Popular");
        electrical.setBadgeColor("yellow");
        electrical.setRating(4.9);
        electrical.setReviews(312);
        electrical.setPrice("$75 - $300");
        electrical.setDescription("Wiring, repair & safety checks. Licensed electricians providing safe and reliable electrical solutions.");
        electrical.setFeatures(Arrays.asList("Wiring & rewiring", "Circuit breaker repair", "Safety inspections", "Outlet installation"));

        // Service 3: Home Deep Cleaning
        ServiceEntity cleaning = new ServiceEntity();
        cleaning.setTitle("Home Deep Cleaning");
        cleaning.setImage("/deep cleaning.jpg");
        cleaning.setCategory("Cleaning");
        cleaning.setBadge("Trending");
        cleaning.setBadgeColor("green");
        cleaning.setRating(4.7);
        cleaning.setReviews(428);
        cleaning.setPrice("$40 - $150");
        cleaning.setDescription("Spotless, healthier living spaces. Transform your home with our professional deep cleaning services.");
        cleaning.setFeatures(Arrays.asList("Deep carpet cleaning", "Kitchen sanitization", "Bathroom cleaning", "Window washing"));

        // Service 4: AC & HVAC Services
        ServiceEntity ac = new ServiceEntity();
        ac.setTitle("AC & HVAC Services");
        ac.setImage("/ac.jpg");
        ac.setCategory("Repair");
        ac.setBadge("Hot");
        ac.setBadgeColor("orange");
        ac.setRating(4.8);
        ac.setReviews(189);
        ac.setPrice("$60 - $250");
        ac.setDescription("Experienced HVAC technicians for AC cooling and heating needs, ensuring comfort year-round.");
        ac.setFeatures(Arrays.asList("AC repair & service", "Installation", "Maintenance", "Emergency cooling"));

        // Service 5: Professional Painting
        ServiceEntity painting = new ServiceEntity();
        painting.setTitle("Professional Painting");
        painting.setImage("/painting.jpg");
        painting.setCategory("Renovation");
        painting.setBadge("Popular");
        painting.setBadgeColor("pink");
        painting.setRating(4.6);
        painting.setReviews(156);
        painting.setPrice("$100 - $500");
        painting.setDescription("Professional painting services for interior, with creative color consultations and quality finishes.");
        painting.setFeatures(Arrays.asList("Interior painting", "Exterior painting", "Color consultation", "Wall preparation"));

        // Service 6: Carpentry & Woodwork
        ServiceEntity carpentry = new ServiceEntity();
        carpentry.setTitle("Carpentry & Woodwork");
        carpentry.setImage("/carpentry.jpg");
        carpentry.setCategory("Renovation");
        carpentry.setBadge("Featured");
        carpentry.setBadgeColor("orange");
        carpentry.setRating(4.7);
        carpentry.setReviews(203);
        carpentry.setPrice("$80 - $350");
        carpentry.setDescription("Skilled carpenter services for expert furniture, cabinet installation, and custom woodworking projects.");
        carpentry.setFeatures(Arrays.asList("Custom furniture", "Cabinet installation", "Door repair", "Wood refinishing"));

        // Service 7: Smart Home Installation
        ServiceEntity smartHome = new ServiceEntity();
        smartHome.setTitle("Smart Home Installation");
        smartHome.setImage("/smart.jpg");
        smartHome.setCategory("Technology");
        smartHome.setBadge("New");
        smartHome.setBadgeColor("purple");
        smartHome.setRating(4.9);
        smartHome.setReviews(134);
        smartHome.setPrice("$150 - $600");
        smartHome.setDescription("Expert smart home and security systems for modern connected living with automation.");
        smartHome.setFeatures(Arrays.asList("Smart device setup", "Home automation", "Voice control", "App integration"));

        // Service 8: Bathroom Renovation
        ServiceEntity bathroom = new ServiceEntity();
        bathroom.setTitle("Bathroom Renovation");
        bathroom.setImage("/bath.jpg");
        bathroom.setCategory("Renovation");
        bathroom.setBadge("Premium");
        bathroom.setBadgeColor("teal");
        bathroom.setRating(4.8);
        bathroom.setReviews(267);
        bathroom.setPrice("$500 - $3000");
        bathroom.setDescription("Complete bathroom transformation with modern fixtures, tiling, and custom design services.");
        bathroom.setFeatures(Arrays.asList("Complete remodeling", "Fixture installation", "Tiling", "Modern design"));

        // Service 9: Flooring Solutions
        ServiceEntity flooring = new ServiceEntity();
        flooring.setTitle("Flooring Solutions");
        flooring.setImage("/flooring.jpg");
        flooring.setCategory("Renovation");
        flooring.setBadge("Quality");
        flooring.setBadgeColor("gray");
        flooring.setRating(4.7);
        flooring.setReviews(198);
        flooring.setPrice("$200 - $1500");
        flooring.setDescription("Professional flooring installation including hardwood, tile, carpet, and laminate options.");
        flooring.setFeatures(Arrays.asList("Hardwood installation", "Tile flooring", "Carpet fitting", "Floor refinishing"));

        // Service 10: Kitchen Appliance Repair
        ServiceEntity kitchen = new ServiceEntity();
        kitchen.setTitle("Kitchen Appliance Repair");
        kitchen.setImage("/kit.jpg");
        kitchen.setCategory("Repair");
        kitchen.setBadge("Fast");
        kitchen.setBadgeColor("blue");
        kitchen.setRating(4.6);
        kitchen.setReviews(289);
        kitchen.setPrice("$55 - $220");
        kitchen.setDescription("On-site kitchen repairs. Quick and reliable appliance repair services for all major brands.");
        kitchen.setFeatures(Arrays.asList("Refrigerator repair", "Oven servicing", "Dishwasher fix", "Same-day service"));

        // Service 11: Garden & Landscaping
        ServiceEntity garden = new ServiceEntity();
        garden.setTitle("Garden & Landscaping");
        garden.setImage("/garden.jpg");
        garden.setCategory("Outdoor");
        garden.setBadge("Eco");
        garden.setBadgeColor("green");
        garden.setRating(4.5);
        garden.setReviews(176);
        garden.setPrice("$90 - $400");
        garden.setDescription("Transform outdoor spaces with professional landscaping, garden design, and lawn maintenance.");
        garden.setFeatures(Arrays.asList("Lawn maintenance", "Garden design", "Tree trimming", "Irrigation systems"));

        // Service 12: Roofing & Gutter Service
        ServiceEntity roofing = new ServiceEntity();
        roofing.setTitle("Roofing & Gutter Service");
        roofing.setImage("/roof.jpg");
        roofing.setCategory("Repair");
        roofing.setBadge("Trusted");
        roofing.setBadgeColor("gray");
        roofing.setRating(4.8);
        roofing.setReviews(145);
        roofing.setPrice("$150 - $800");
        roofing.setDescription("Professional roofing and gutter cleaning services with quality materials and expert workmanship.");
        roofing.setFeatures(Arrays.asList("Roof repair", "Gutter cleaning", "Leak fixing", "Inspection"));

        // Service 13: Window Installation & Repair
        ServiceEntity window = new ServiceEntity();
        window.setTitle("Window Installation & Repair");
        window.setImage("/wind.jpg");
        window.setCategory("Repair");
        window.setBadge("Quality");
        window.setBadgeColor("gray");
        window.setRating(4.7);
        window.setReviews(167);
        window.setPrice("$100 - $500");
        window.setDescription("Complete window services including installation, repair, and energy-efficient replacements.");
        window.setFeatures(Arrays.asList("Window replacement", "Glass repair", "Energy efficient", "Custom sizes"));

        // Service 14: Security System Installation
        ServiceEntity security = new ServiceEntity();
        security.setTitle("Security System Installation");
        security.setImage("/sec.jpg");
        security.setCategory("Technology");
        security.setBadge("Premium");
        security.setBadgeColor("red");
        security.setRating(4.9);
        security.setReviews(203);
        security.setPrice("$200 - $1000");
        security.setDescription("Complete home security system installation including cameras, sensors, and 24/7 monitoring.");
        security.setFeatures(Arrays.asList("CCTV installation", "Alarm systems", "24/7 monitoring", "Smart locks"));

        // Service 15: Handyman Services
        ServiceEntity handyman = new ServiceEntity();
        handyman.setTitle("Handyman Services");
        handyman.setImage("/man.jpg");
        handyman.setCategory("General");
        handyman.setBadge("Versatile");
        handyman.setBadgeColor("gray");
        handyman.setRating(4.8);
        handyman.setReviews(312);
        handyman.setPrice("$40 - $150");
        handyman.setDescription("All-in-one handyman services for minor repairs, installations, and home improvement tasks.");
        handyman.setFeatures(Arrays.asList("Minor repairs", "Furniture assembly", "TV mounting", "General fixes"));

        // Service 16: Pool Maintenance
        ServiceEntity pool = new ServiceEntity();
        pool.setTitle("Pool Maintenance");
        pool.setImage("/pool.jpg");
        pool.setCategory("Outdoor");
        pool.setBadge("Summer");
        pool.setBadgeColor("blue");
        pool.setRating(4.5);
        pool.setReviews(127);
        pool.setPrice("$70 - $250");
        pool.setDescription("Professional pool cleaning, maintenance, and repair services for crystal clear water.");
        pool.setFeatures(Arrays.asList("Pool cleaning", "Chemical balance", "Equipment repair", "Regular maintenance"));

        // Save all services
        List<ServiceEntity> services = Arrays.asList(
            plumbing, electrical, cleaning, ac, painting, carpentry,
            smartHome, bathroom, flooring, kitchen, garden, roofing,
            window, security, handyman, pool
        );

        System.out.println("Saving " + services.size() + " services to database...");
        
        try {
            int savedCount = 0;
            for (ServiceEntity service : services) {
                try {
                    ServiceEntity saved = serviceRepository.save(service);
                    savedCount++;
                    System.out.println("✓ Saved: " + saved.getTitle() + " (ID: " + saved.getId() + ")");
                } catch (Exception e) {
                    System.err.println("✗ Failed to save: " + service.getTitle() + " - " + e.getMessage());
                    e.printStackTrace();
                }
            }
            
            long finalCount = serviceRepository.count();
            System.out.println("✓ Successfully saved " + savedCount + " out of " + services.size() + " services!");
            System.out.println("✓ Total services in database: " + finalCount);
            
        } catch (Exception e) {
            System.err.println("✗ Error during service initialization: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("=== ServiceDataInitializer completed ===");
    }
}
