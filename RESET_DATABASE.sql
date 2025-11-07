-- ===================================
-- COMPLETE DATABASE RESET AND TEST
-- ===================================

-- Step 1: Drop and recreate database (OPTIONAL - only if needed)
-- DROP DATABASE IF EXISTS house;
-- CREATE DATABASE house;

-- Step 2: Use the database
USE house;

-- Step 3: Check existing tables
SHOW TABLES;

-- Step 4: Clear all data (if tables exist)
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS service_entity_features;
DROP TABLE IF EXISTS services;
DROP TABLE IF EXISTS users;
SET FOREIGN_KEY_CHECKS = 1;

-- Step 5: Verify tables are empty (they should be recreated by Spring Boot)
SHOW TABLES;

-- After running Spring Boot application, run these checks:

-- Check 1: Verify users table
SELECT COUNT(*) as user_count FROM users;
SELECT * FROM users;

-- Check 2: Verify services table
SELECT COUNT(*) as service_count FROM services;
SELECT id, title, category, price, rating FROM services ORDER BY id;

-- Check 3: Verify features
SELECT COUNT(*) as feature_count FROM service_entity_features;
SELECT se.id, se.title, sef.features 
FROM services se 
JOIN service_entity_features sef ON se.id = sef.service_entity_id
ORDER BY se.id, sef.features;

-- Check 4: Services by category
SELECT category, COUNT(*) as count 
FROM services 
GROUP BY category 
ORDER BY count DESC;

-- Check 5: Top rated services
SELECT id, title, rating, reviews, price 
FROM services 
ORDER BY rating DESC, reviews DESC 
LIMIT 5;

-- Check 6: Verify all 16 services exist
SELECT 
    CASE 
        WHEN COUNT(*) = 16 THEN '✓ SUCCESS: All 16 services exist!'
        ELSE CONCAT('✗ ERROR: Only ', COUNT(*), ' services found. Expected 16.')
    END as status
FROM services;
