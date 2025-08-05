# Deployment Guide - Free Heroku Alternatives 🚀

This guide provides detailed, step-by-step instructions for deploying your Blood Pressure Tracking application to various free hosting platforms.

## 🎯 Quick Comparison

| Platform | Free Tier | Database | Ease of Use | Best For |
|----------|-----------|----------|-------------|----------|
| Railway | $5/month credit | PostgreSQL included | ⭐⭐⭐⭐⭐ | Heroku-like experience |
| Render | 750 hours/month | Free PostgreSQL | ⭐⭐⭐⭐ | Simple deployment |
| Fly.io | 3 VMs, 160GB bandwidth | External DB needed | ⭐⭐⭐ | Docker-based |
| Vercel | Unlimited deployments | External DB needed | ⭐⭐ | Requires configuration |

## 🚂 Option 1: Railway (Recommended)

Railway is the closest replacement to Heroku with excellent Spring Boot support.

### Prerequisites
- GitHub account
- Your code pushed to GitHub
- Railway account (free signup)

### Step-by-Step Instructions

#### 1. Prepare Your Repository
```bash
# Ensure your code is on GitHub
git add .
git commit -m "Prepare for Railway deployment"
git push origin main
```

#### 2. Create Railway Account
1. Go to [railway.app](https://railway.app)
2. Click "Login" and sign in with GitHub
3. Authorize Railway to access your repositories

#### 3. Create New Project
1. Click "New Project"
2. Select "Deploy from GitHub repo"
3. Choose your blood pressure app repository
4. Railway automatically detects it's a Spring Boot application

#### 4. Add PostgreSQL Database
1. In your project dashboard, click "New"
2. Select "Database" → "PostgreSQL"
3. Railway automatically creates the database and provides connection variables

#### 5. Configure Environment Variables
Railway automatically sets `DATABASE_URL`, but you can verify/add others:

1. Go to your web service (not database)
2. Click "Variables" tab
3. Add if needed:
   ```
   PORT=8080
   DDL_AUTO=update
   SHOW_SQL=false
   ```

#### 6. Deploy
1. Railway automatically deploys on every git push
2. Check the "Deployments" tab for build status
3. Once deployed, click "Generate Domain" to get your public URL

#### 7. Verify Deployment
1. Visit your generated URL
2. Test login with default credentials:
   - Username: `Anh`, Password: `password`
   - Username: `Matias`, Password: `password`

### Railway Tips
- Builds take 2-5 minutes
- Check logs in "Deployments" tab if issues occur
- $5 monthly credit is usually sufficient for small apps
- Automatic HTTPS included

---

## 🎨 Option 2: Render

Render offers a generous free tier with built-in PostgreSQL.

### Step-by-Step Instructions

#### 1. Create Render Account
1. Go to [render.com](https://render.com)
2. Sign up with GitHub
3. Authorize Render to access repositories

#### 2. Create PostgreSQL Database
1. Click "New" → "PostgreSQL"
2. Fill in:
   - Name: `bloodpressure-db`
   - Database: `bloodpressure`
   - User: `bloodpressure_user`
3. Select "Free" plan
4. Click "Create Database"
5. **Important**: Copy the "External Database URL" - you'll need this

#### 3. Create Web Service
1. Click "New" → "Web Service"
2. Connect your GitHub repository
3. Fill in settings:
   - Name: `bloodpressure-app`
   - Environment: `Java`
   - Build Command: `./mvnw clean package -DskipTests`
   - Start Command: `java -jar target/bloodpressure-0.0.1-SNAPSHOT.jar`

#### 4. Configure Environment Variables
In the "Environment" section, add:
```
DATABASE_URL=<paste_your_database_url_from_step_2>
PORT=8080
DDL_AUTO=update
```

#### 5. Deploy
1. Click "Create Web Service"
2. Render will build and deploy automatically
3. Monitor progress in the logs

#### 6. Access Your App
1. Once deployed, Render provides a `.onrender.com` URL
2. Test the application with default credentials

### Render Tips
- First deploy takes 5-10 minutes
- Free tier sleeps after 15 minutes of inactivity
- Database has 1GB storage limit
- SSL/HTTPS included automatically

---

## ✈️ Option 3: Fly.io

Fly.io offers good performance but requires external database.

### Prerequisites
- Install Fly CLI:
  ```bash
  # macOS/Linux
  curl -L https://fly.io/install.sh | sh
  
  # Windows
  # Download from https://github.com/superfly/flyctl/releases
  ```

### Step-by-Step Instructions

#### 1. Setup External Database
Use a free PostgreSQL service:

**Option A: Supabase (Recommended)**
1. Go to [supabase.com](https://supabase.com)
2. Create new project
3. Get connection string from Settings → Database

**Option B: Neon**
1. Go to [neon.tech](https://neon.tech)
2. Create database
3. Copy connection string

#### 2. Initialize Fly Application
```bash
# Login to Fly
flyctl auth login

# Initialize in your project directory
flyctl launch
```

#### 3. Configure fly.toml
The `flyctl launch` command creates `fly.toml`. Update it:

```toml
app = "your-app-name"
primary_region = "fra"

[env]
  PORT = "8080"
  DDL_AUTO = "update"

[http_service]
  internal_port = 8080
  force_https = true
  auto_stop_machines = true
  auto_start_machines = true
  min_machines_running = 0

[[vm]]
  cpu_kind = "shared"
  cpus = 1
  memory_mb = 256
```

#### 4. Set Database URL
```bash
flyctl secrets set DATABASE_URL="your_postgresql_connection_string"
```

#### 5. Deploy
```bash
flyctl deploy
```

#### 6. Access Your App
```bash
flyctl open
```

### Fly.io Tips
- Machines auto-sleep when inactive (free tier)
- Great performance and global edge locations
- Requires more technical setup
- Good for production apps

---

## 🔧 Troubleshooting

### Common Issues

#### Database Connection Errors
**Problem**: App can't connect to database
**Solutions**:
1. Verify `DATABASE_URL` format: `postgresql://user:password@host:port/database`
2. Check if database allows external connections
3. Ensure firewall/security groups allow connections

#### Build Failures
**Problem**: Maven build fails
**Solutions**:
1. Check Java version compatibility (app uses Java 1.8)
2. Verify `pom.xml` is correct
3. Check for missing dependencies
4. Try building locally first: `./mvnw clean package`

#### Application Startup Issues
**Problem**: App starts but crashes immediately
**Solutions**:
1. Check application logs
2. Verify environment variables are set correctly
3. Ensure database is accessible
4. Check if port is correctly configured

#### Memory Issues
**Problem**: App runs out of memory
**Solutions**:
1. Increase memory allocation if platform allows
2. Optimize JVM settings:
   ```bash
   java -Xmx512m -jar target/bloodpressure-0.0.1-SNAPSHOT.jar
   ```

### Platform-Specific Issues

#### Railway
- **Build timeout**: Increase timeout in Railway settings
- **Database connection**: Verify `DATABASE_URL` variable is automatically set

#### Render
- **Service sleeping**: Free tier sleeps after 15 minutes of inactivity
- **Build cache**: Clear build cache if getting stale builds

#### Fly.io
- **Machine startup**: Cold starts can take 10-15 seconds
- **Region selection**: Choose region closest to your users

## 📊 Monitoring Your Deployment

### Health Checks
All platforms provide health monitoring. Your app responds to:
- `GET /` - Main application page
- `GET /api/bloodpressures` - API health check

### Logs
- **Railway**: Deployments tab → View logs
- **Render**: Service dashboard → Logs
- **Fly.io**: `flyctl logs` command

### Performance
Monitor your app's performance:
- Response times
- Memory usage
- Database connections
- Error rates

## 🚀 Going to Production

For production deployments, consider:

1. **Custom Domain**: All platforms support custom domains
2. **Environment Separation**: Use different databases for staging/production
3. **SSL Certificates**: Automatically provided by all platforms
4. **Monitoring**: Set up application monitoring (New Relic, DataDog)
5. **Backups**: Configure database backups
6. **Scaling**: Upgrade to paid plans for better performance

## 💡 Cost Optimization

### Free Tier Limits
- **Railway**: $5 monthly credit (reset monthly)
- **Render**: 750 hours/month (sufficient for one app)
- **Fly.io**: 3 VMs, 160GB bandwidth

### Optimization Tips
1. Use sleep/wake functionality on free tiers
2. Optimize database queries to reduce load
3. Implement caching where appropriate
4. Monitor resource usage regularly

---

**Success!** 🎉 Your Blood Pressure Tracking app should now be live and accessible to users worldwide!