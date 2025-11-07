package com.example.house;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
    List<ServiceEntity> findByCategory(String category);
    
    @Query("SELECT s FROM ServiceEntity s WHERE LOWER(s.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(s.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<ServiceEntity> searchByKeyword(@Param("keyword") String keyword);
    
    List<ServiceEntity> findTop5ByOrderByRatingDesc();
}

