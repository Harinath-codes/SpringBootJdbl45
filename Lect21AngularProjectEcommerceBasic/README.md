# MyStore Website

## Description
This project is about an ecoomerce website called  MyStore. Through this application a person will be able to view and purchase items of their choice on the click of the mouse. 
The functionalities offered by this application are:-

Website
The website contains the following components, cart, confirmation, product-item, product-item-detail and product-list

1. Product list - 
The user will be able to view all products that the site sales. It will have the name, price, picture and quantity to purchase.


2. Confirmation - 
The user will receive a confirmation dialog when they add an item to the cart. 

3. Product item - 
Provides the information that each product in the list will display to the customer.

4. Product item detail - 
Provides the detail description of the product when a customer selects the product from the product list. 

5. Cart - 
Provides a summary of the items in the cart along with the total price. Additionally, takes the customers, name, address and credit card to complete the order. 

When a customer submits a cart they are provided with the summary of the cart. The submit button will send the order to the backend. 



## Installations

* Make sure Java 11 is installed on your system to run the backend.
* Make sure to install [Node.js and npm](https://nodejs.org/en/download/) and then [Angular Cli](https://angular.io/cli)

## Structure
There will be two layers of the application.

1. The back-end with Spring Boot
2. The front-end with Angular


## Running the Backend

1. Load the application into InteliJ
2. Right click on StoreApplication and select run or from the cmd line use `mvn spring-boot:run`
3. The application will be running on  `http://localhost:8080/`

## Running the frontend 

1. Navigate to /webapp/angular-frontend
2. Install dependencies with `npm install`.
3. Run `ng serve` for a dev server.
4. Navigate to `http://localhost:4200/`.






