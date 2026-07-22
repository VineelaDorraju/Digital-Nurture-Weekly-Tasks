# DevOps CI/CD Project Execution

1. Compile the application
   javac App.java AppTest.java

2. Run the application
   java App

3. Verify application
   Open browser: http://localhost:5000/
   Open browser: http://localhost:5000/health

4. Run tests
   java AppTest

5. Build Docker image
   docker build -t devops-app .

6. Run container
   docker run -p 5000:5000 devops-app

7. Run using docker-compose
   docker-compose up --build

8. Trigger CI Pipeline
   Push code to GitHub repository

9. Trigger CD Pipeline
   Deployment runs automatically after CI success

10. Verify deployment
    curl http://localhost:5000/