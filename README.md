# Blood Pressure Tracking Application 📈💪

A comprehensive web application for tracking and monitoring blood pressure measurements, built with Spring Boot and designed for easy health monitoring.

![Java](https://img.shields.io/badge/Java-1.8-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5.6-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-Template%20Engine-yellowgreen)

## 🚀 Features

- **User Authentication**: Secure login and registration system
- **Blood Pressure Tracking**: Record systolic, diastolic pressure and heart rate
- **Historical Data**: View and manage your blood pressure history
- **Data Visualization**: Track your health trends over time
- **Responsive Design**: Works on desktop and mobile devices
- **Role-based Access**: Admin and Guest user roles
- **RESTful API**: Data access through REST endpoints

## 🛠️ Technology Stack

- **Backend**: Spring Boot 2.5.6
- **Database**: PostgreSQL
- **Security**: Spring Security with BCrypt password encryption
- **Frontend**: Thymeleaf Templates + Bootstrap CSS
- **Build Tool**: Maven
- **Java Version**: 1.8

## 📋 Prerequisites

- Java 1.8 or higher
- Maven 3.6+
- PostgreSQL database

## 🏃‍♂️ Quick Start

### Local Development

1. **Clone the repository**
   ```bash
   git clone <your-repo-url>
   cd bloodpressure
   ```

2. **Set up PostgreSQL database**
   ```sql
   CREATE DATABASE bloodpressure_db;
   ```

3. **Configure database connection**
   Update `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/bloodpressure_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

4. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Access the application**
   Open your browser and go to `http://localhost:8080`

### Default Users

The application comes with pre-configured test users:

| Username | Password | Role  |
|----------|----------|-------|
| Anh      | password | ADMIN |
| Matias   | password | GUEST |

## 🌐 Deployment Options (Free Heroku Alternatives)

Since Heroku no longer offers free tiers, here are the best free alternatives:

### Option 1: Railway (Recommended) 🚂

**Why Railway?**
- Most similar to Heroku experience
- $5 monthly credit (sufficient for small apps)
- Built-in PostgreSQL
- Auto-deploy from Git

**Setup Steps:**

1. **Sign up** at [railway.app](https://railway.app)

2. **Deploy from GitHub:**
   ```bash
   # Push your code to GitHub first
   git add .
   git commit -m "Prepare for Railway deployment"
   git push origin main
   ```

3. **Create Railway project:**
   - Click "New Project" → "Deploy from GitHub repo"
   - Select your repository
   - Railway will automatically detect it's a Spring Boot app

4. **Add PostgreSQL:**
   - In your project dashboard, click "New" → "Database" → "PostgreSQL"
   - Railway will automatically provide connection variables

5. **Configure environment variables:**
   ```
   DATABASE_URL=postgresql://username:password@host:port/database
   PORT=8080
   ```

6. **Update application.properties for Railway:**
   ```properties
   server.port=${PORT:8080}
   spring.datasource.url=${DATABASE_URL}
   spring.jpa.hibernate.ddl-auto=update
   ```

### Option 2: Render 🎨

**Setup Steps:**

1. **Sign up** at [render.com](https://render.com)

2. **Create PostgreSQL Database:**
   - New → PostgreSQL
   - Note down the connection details

3. **Create Web Service:**
   - New → Web Service
   - Connect your GitHub repo
   - Build Command: `./mvnw clean package -DskipTests`
   - Start Command: `java -jar target/bloodpressure-0.0.1-SNAPSHOT.jar`

4. **Environment Variables:**
   ```
   DATABASE_URL=your_postgresql_url_from_step_2
   ```

### Option 3: Fly.io ✈️

1. **Install Fly CLI:**
   ```bash
   curl -L https://fly.io/install.sh | sh
   ```

2. **Login and initialize:**
   ```bash
   flyctl auth login
   flyctl launch
   ```

3. **Configure fly.toml** (will be generated automatically)

## 🔧 Configuration Files for Deployment

### For Railway/Render - Updated application.properties:

```properties
# Database Configuration
spring.datasource.url=${DATABASE_URL:jdbc:postgresql://localhost:5432/bloodpressure_db}
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database=POSTGRESQL
spring.datasource.platform=postgres

# Server Configuration
server.port=${PORT:8080}

# JPA Configuration
spring.jpa.hibernate.ddl-auto=${DDL_AUTO:update}
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true

# Application Settings
spring.data.rest.basePath=/api
spring.jpa.open-in-view=true
```

### Dockerfile (Optional for containerized deployment):

```dockerfile
FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/bloodpressure-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
```

## 📊 API Endpoints

The application provides RESTful API endpoints:

- `GET /api/bloodpressures` - Get all blood pressure records
- `POST /api/bloodpressures` - Create new record
- `PUT /api/bloodpressures/{id}` - Update record
- `DELETE /api/bloodpressures/{id}` - Delete record

## 🔒 Security Features

- Password encryption using BCrypt
- Session-based authentication
- CSRF protection
- Role-based access control
- Secure password requirements

## 🎯 Usage

1. **Sign Up**: Create a new account or use default credentials
2. **Login**: Access your personal dashboard
3. **Add Records**: Record your blood pressure measurements
4. **View History**: Track your health trends over time
5. **Edit/Delete**: Manage your existing records

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🆘 Troubleshooting

### Common Issues:

1. **Database Connection Issues:**
   - Verify PostgreSQL is running
   - Check connection string format
   - Ensure database exists

2. **Port Issues:**
   - Application runs on port 8080 by default
   - Change port in application.properties if needed

3. **Build Issues:**
   - Ensure Java 1.8+ is installed
   - Run `./mvnw clean install` to rebuild

### Support

If you encounter any issues:
- Check the application logs
- Verify environment variables
- Ensure database connectivity
- Review deployment platform documentation

## 🚀 What's Next?

Potential improvements and features:
- Mobile app development
- Data export functionality
- Email notifications for irregular readings
- Integration with health APIs
- Advanced analytics and trends
- Doctor/caregiver sharing features

---

**Happy Health Tracking! 💙**