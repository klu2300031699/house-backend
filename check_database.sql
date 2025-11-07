-- Check Database Status for HomeServe Application

-- 1. Check if database exists and select it
USE house;

-- 2. Show all tables
SHOW TABLES;

-- 3. Check users table
SELECT COUNT(*) as user_count FROM users;
SELECT * FROM users;

-- 4. Check services table
SELECT COUNT(*) as service_count FROM services;
SELECT id, title, category, price, rating FROM services;

-- 5. Check service features
SELECT COUNT(*) as feature_count FROM service_entity_features;
SELECT * FROM service_entity_features LIMIT 20;

-- 6. Get services by category
SELECT category, COUNT(*) as count FROM services GROUP BY category;

-- ========================================
-- ONLY RUN BELOW IF YOU WANT TO RESET DATA
-- ========================================

-- Uncomment these lines to clear all data and start fresh:
-- DELETE FROM service_entity_features;
-- DELETE FROM services;
-- DELETE FROM users;

-- Uncomment to reset auto increment:
-- ALTER TABLE services AUTO_INCREMENT = 1;
-- ALTER TABLE users AUTO_INCREMENT = 1;

-- After clearing, restart your Spring Boot application
-- to trigger the DataInitializers again
