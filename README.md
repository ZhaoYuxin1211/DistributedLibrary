
# Library Management System [Group 6]

## Overview
The application domain for the system is library management. It focuses on creating a digital library platform where various services related to library operations will interact and function together, such as borrow books, return books, book services, review, and message processing.

## Features
The application is designed to manage a library system using a microservices architecture, incorporating elements of distributed systems. It handles user management book catalogs, borrower records, inventory, and notifications. Employing Spring Boot and Spring Cloud, the system features service discovery, centralized configuration, and distributed database. This setup, integrated with a distributed system approach, ensures robust and scalable library operations, facilitating both synchronous and asynchronous communications among microservices.

## Technologies
- **Back-End:** Spring Boot, Spring Cloud
- **Database:** PostgreSQL
- **Messaging:** Kafka
- **Service Discovery:** Eureka

## Architecture
The system uses a microservices architecture, ensuring scalability and fault tolerance. Key components include service discovery, centralized configuration, and distributed tracing.
![Diagram](https://github.com/ZhaoYuxin1211/DistributedLibrary/assets/74203373/d6bbb502-6912-49d7-92c8-a9e2a25f0a9c)


## Challenges
We faced and overcame several challenges related to system scalability, integration of different technologies, and ensuring reliable communication between services.

## Team Contributions

#### [Yuxin Zhao](https://github.com/ZhaoYuxin1211)
- **Microservices Architecture Design:** Instrumental in developing the overall microservices architecture. This involved planning and structuring the system's core services, ensuring scalability and fault tolerance.
- **User Service:** Played a key role in the creation and implementation of the User Service, focusing on efficient user operations handling.
- **Book Service:** Contributed significantly to the Book Service, which involved managing the library's books and handling operations such as stock availability and transactional processes.
- **Database Design:** Led the design and implementation of the database structures, ensuring robust and scalable data management across services.

#### [Ruiqi Zhao](https://github.com/ZRQ-rikkie)
- **User Service and Book Service:** Worked alongside Yuxin Zhao in developing and fine-tuning the User and Book Services, focusing on functionality and integration within the microservices architecture.
- **Database Design:** Collaborated in the database design process, ensuring the database's scalability and effective integration with various services.
- **Report Writing:** Responsible for compiling and writing the project report, detailing the system's architecture, functionalities, and design rationale.

#### [Miaomiao Shi](https://github.com/MiaomiaoShi1004)
- **Message Service:** Key contributor to the Message Service, managing asynchronous communication and event-driven processes using Kafka. This involved setting up and maintaining message flow for various system events.
- **Front-end Implementation:** Played a significant role in implementing the front-end components of the system using react, ensuring seamless user interaction and interface design.

#### [Judith Smolenski](https://github.com/jsmo998)
- **Review Service:** Led the development of the Review Service, focusing on creating and retrieving book reviews. This involved database interactions and integration with the microservices architecture.
- **Front-end Implementation:** Collaborated with Miaomiao Shi in front-end development, focusing on user experience and interface functionality, ensuring the front end aligns with the system's microservices architecture.
- **Project Video Recording:** Took the initiative in recording a comprehensive video of the entire project. This involved capturing the system's functionalities, demonstrating the architecture's flow, and showcasing the team's collaborative efforts.



   
## Project Report
[Group Project](https://github.com/ZhaoYuxin1211/DistributedLibrary/blob/main/TeamReport.pdf)


## Project Video
[Video link](https://drive.google.com/file/d/1Jg-y6Hhwo--ILkxyk9aGR7yoYPfKEZwR/view?usp=sharing)


## How to run the Application
First start the back-end server and services. Navigate into the project root folder, containing the docker-compose.yml file, and run:

``` docker compose up ```

Then navigate to the React project ([Github link](https://github.com/MiaomiaoShi1004/distributedlibrary)) on your computer to launch the interface. In the React projects root folder run:

``` npm start ```

Access the user interface on [localhost:3000](http://localhost:3000).