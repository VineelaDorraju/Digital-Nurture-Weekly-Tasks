# Smart Inventory Management using Docker

## Project Overview

Smart Inventory Management is a containerized web application developed to demonstrate Docker concepts, networking, storage, and container orchestration. The project follows a multi-container architecture consisting of a React frontend, Express.js backend, PostgreSQL database, and Nginx reverse proxy.

---

## Technologies Used

- Docker
- Docker Compose
- Kubernetes
- React (Vite)
- Node.js
- Express.js
- PostgreSQL
- Nginx

---

## Project Structure

```
Smart_Inventory_Docker/
│
├── frontend/
├── backend/
├── database/
├── nginx/
├── kubernetes/
├── scripts/
├── docker-compose.yml
├── .env
└── README.md
```

---

## Features

- Inventory Dashboard
- Product Management
- Order Management
- PostgreSQL Database
- Dockerized Services
- Nginx Reverse Proxy
- Kubernetes Deployment Files

---

## Docker Commands

Build all containers

```bash
docker-compose build
```

Start containers

```bash
docker-compose up -d
```

View running containers

```bash
docker ps
```

Stop containers

```bash
docker-compose down
```

View logs

```bash
docker-compose logs
```

---

## Kubernetes Deployment

```
kubectl apply -f kubernetes/
```

---

## Services

| Service | Port |
|---------|------|
| Frontend | 5173 |
| Backend | 5000 |
| PostgreSQL | 5432 |
| Nginx | 80 |

---

## Learning Outcomes

- Docker Images
- Docker Containers
- Docker Networking
- Docker Storage
- Docker Compose
- Docker Engine
- Kubernetes Deployment
- Container Orchestration

---

## Author

Developed as part of the Cognizant Deep Skilling Module 13 – Containerization using Docker.