# SearchAPI for Videos

## Overview

This project implements search functionality to search amongst a huge collection of videos.

## Setup

1. Clone the repository


## API Documentation

### Add Video

- **Endpoint**: `/api/addVideo`
- **Method**: `POST`
- **Request Body**:
    ```json
    {
       "title": "DDLJ",
       "description": "Shah Rukh Khan",
       "tags": "drama , thriller , love , comedy"
    }
    ```

### Get All Videos

- **Endpoint**: `/api/allVideos`
- **Method**: `GET`


### Search for title , description or tags

- **Endpoint**: `/api/search?query={to_be_searched}`
- **Method**: `GET`
  
### Delete using title

- **Endpoint**: `/api/delete?title={to_be_deleted}`
- **Method**: `DELETE`

  

## Swagger Documentation

Open your web browser and navigate to http://localhost:8080/swagger-ui.html

## Docker Run

- mvn clean package 
- docker-compose up --build
