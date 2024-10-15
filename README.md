<a href="https://git.io/typing-svg">
  <img src="https://readme-typing-svg.herokuapp.com?font=Fira+Code&weight=600&size=50&pause=1000&center=true&vCenter=true&color=D8BFD8&width=835&height=70&lines=POS+SYSTEM+BACKEND" alt="pos" />
</a>

# AAD-02nd Phase-Assignment-POS-BackEnd
## Project Description
The POS System Backend is a RESTful API that supports the frontend operations of a Point of Sale system. This backend service manages customer, order, and inventory data, providing essential functionalities such as creating, reading, updating, and deleting records.

## Table of Contents
- [Project Description](#project-description)
- [Features](#features)
- [Technologies](#technologies)
- [Installation](#installation)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [License](#license)

## Features
- Manage customer records
- Process orders and track inventory
- Update item quantities
- Apply discounts and calculate totals
- Secure endpoints with authentication

## Technologies
- **Backend Framework**: Spring framework
- **Database**: MySQL
- **Build Tool**: Maven
- **Application Server**: Apache Tomcat 10
- **JDK**: OpenJDK 17

## Installation

### Prerequisites
- Java 17 (OpenJDK 17)
- Maven
- MySQL
- Apache Tomcat 10

### API Endpoints

<h3>Customer Endpoints</h3>
<ul>
    <li>GET /customer: Retrieve all customers.</li>
    <li>POST /customer: Create a new customer.</li>
    <li>PUT /customer: Update an existing customer.</li>
    <li>DELETE /customer/{id}: Delete a customer by ID.</li>
</ul>

<h3>Item Endpoints</h3>
<ul>
    <li>GET /item: Retrieve all items.</li>
    <li>POST /item: Create a new item.</li>
    <li>PUT /item: Update an existing item.</li>
    <li>DELETE /item/{id}: Delete a item by ID.</li>
</ul>

<h3>Order Endpoints</h3>
<ul>
    <li>GET /order: Retrieve all order.</li>
    <li>POST /order: Create a new order.</li>
</ul>

### Documentation
-postman documentation - https://documenter.getpostman.com/view/35385634/2sAXxTcqgf

### MIT License 
https://github.com/sachiniwathudura/POS-System-Backend-Spring/blob/main/LICENSE