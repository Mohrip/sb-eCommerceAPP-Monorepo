# StackShop - E-Commerce Backend API

A RESTFUL e-commerce backend built with Spring Boot, featuring JWT authentication, product management, shopping cart, and order processing.

## Technologies Used

- **Java 17** - Programming language
- **Spring Boot 3.5** - Application framework
- **Spring Security** - Authentication & Authorization
- **Spring Data JPA** - Data persistence
- **JWT** - Token-based authentication
- **Hibernate Validator** - Bean validation
- **Maven** - Build automation
- **Lombok** - Code generation
- **MySQL** - Database
- **Docker** - Containerization
- **JUnit** - Testing framework

## Features

- User authentication (signup/login) with JWT
- Role-based access control (Admin/User)
- Category CRUD operations
- Product management with image upload
- Shopping cart functionality
- Order processing
- Address management
- Input validation with custom error messages
- Global exception handling
- RESTful API design
- Swagger/OpenAPI documentation

## API Endpoints

### Authentication
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/auth/signup` | Register new user |
| `POST` | `/api/auth/signin` | Login user |
| `POST` | `/api/auth/signout` | Logout user |

### Categories
| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/public/categories` | Get all categories |
| `POST` | `/api/admin/categories` | Create category (Admin) |
| `PUT` | `/api/admin/categories/{id}` | Update category (Admin) |
| `DELETE` | `/api/admin/categories/{id}` | Delete category (Admin) |

### Products
| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/public/products` | Get all products |
| `GET` | `/api/public/categories/{categoryId}/products` | Get products by category |
| `POST` | `/api/admin/categories/{categoryId}/product` | Add product (Admin) |
| `PUT` | `/api/admin/products/{productId}` | Update product (Admin) |
| `DELETE` | `/api/admin/products/{productId}` | Delete product (Admin) |

### Cart
| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/carts` | Get user's cart |
| `POST` | `/api/carts/products/{productId}/quantity/{quantity}` | Add to cart |
| `PUT` | `/api/carts/products/{productId}/quantity/{operation}` | Update cart item |
| `DELETE` | `/api/carts/{cartId}/product/{productId}` | Remove from cart |

### Orders
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/order/users/payments/{paymentMethod}` | Place order |
| `GET` | `/api/admin/orders` | Get all orders (Admin) |

### Address
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/addresses` | Add address |
| `GET` | `/api/addresses` | Get user addresses |
| `PUT` | `/api/addresses/{addressId}` | Update address |
| `DELETE` | `/api/addresses/{addressId}` | Delete address |

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher
- Docker & Docker Compose
- MySQL 8.0 (or use Docker)

### Installation

1. **Clone the repository**
```bash
git clone https://github.com/Mohrip/sb-eCommerceAPP.git
cd sb-eCommerceAPP/Backend
```

2. **Create `.env` file**
```bash
DB_USERNAME=root
DB_PASSWORD=your_password_here
```

3. **Run with Docker (Recommended)**
```bash
./mvnw clean package -DskipTests
docker-compose up --build
```

4. **Or run locally**
```bash
# Start MySQL first, then:
./mvnw spring-boot:run
```

### Access the Application
- API: `http://localhost:5000`
- Swagger UI: `http://localhost:5000/swagger-ui.html`

## Docker Commands

```bash
# Start containers
docker-compose up --build

# Run in background
docker-compose up -d

# Stop containers
docker-compose down

# Stop and remove data
docker-compose down -v

# View logs
docker-compose logs -f app
```

## Project Structure

```
Backend/
├── src/main/java/com/StackShop/project/
│   ├── Address/        # Address management
│   ├── cart/           # Shopping cart
│   ├── category/       # Product categories
│   ├── config/         # App configuration
│   ├── exceptions/     # Global exception handling
│   ├── order/          # Order processing
│   ├── payment/        # Payment handling
│   ├── product/        # Product management
│   ├── security/       # JWT & Spring Security
│   ├── user/           # User entities
│   └── util/           # Utility classes
├── Dockerfile
├── docker-compose.yml
├── .env
└── pom.xml
```

## Environment Variables

| Variable | Description |
|----------|-------------|
| `DB_USERNAME` | MySQL username |
| `DB_PASSWORD` | MySQL password |

## License

This project is for educational purposes.
