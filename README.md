# URL Shortener

This is a simple URL shortener service built with Spring Boot for the backend and a basic HTML + CSS frontend.

## Features

- Create short URLs from long URLs
- Set expiration time (in minutes) for each short URL
- Redirect from short URL to the original URL
- Simple and clean frontend interface to input URLs and get shortened links

## How it works

1. User inputs a long URL and an optional expiration time.
2. Backend generates a unique short code and stores it along with the original URL and expiration.
3. User receives a short URL.
4. When visiting the short URL, the service redirects to the original URL if it hasn't expired.

## Technologies Used

- Java 17+
- Spring Boot (REST Controller)
- Maven
- HTML & CSS (static resources served by Spring Boot)

## Running the project

1. Build and run the Spring Boot application.
2. Open your browser at `http://localhost:8080/index.html`.
3. Enter the URL you want to shorten and expiration time.
4. Click the button and get your short URL.

## API Endpoints

- `POST /api/urls` - Creates a short URL.  
  Request body JSON example:  
  ```json
  {
    "originalUrl": "https://www.example.com",
    "expiration": "120"
  }

Made by Isaac Almeida dos Reis
