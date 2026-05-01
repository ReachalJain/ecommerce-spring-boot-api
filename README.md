Ecommerce REST API

A REST API for Ecommerce built using Spring Boot and MySQL.

Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Hibernate

API Endpoints

Products
- GET /api/products - Get all products
- GET /api/products/{id} - Get product by ID
- GET /api/products/category/{category} - Get products by category

Auth
- POST /api/auth/login - Login
- POST /api/auth/signup - Signup

Cart
- GET /api/cart/{userId} - Get user cart
- POST /api/cart/add - Add to cart
- DELETE /api/cart/remove/{userId}/{productId} - Remove from cart

How to Run
1. Clone the repository
2. Open in IntelliJ IDEA
3. Setup MySQL database
4. Configure application.properties
5. Run EcommerceApiApplication.java
6. API runs on http://localhost:8080

Developer
Reachal Jain
