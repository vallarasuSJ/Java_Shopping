Java_Shopping
--------------
 
This java console application for E-Commerce has the following sections:
------------------------------------------------------------------------
    1. Login - Existing User and Admin
    2. Register - New User
    3. Home - User
        * View Categories 
            - View products based on category.
        * View all Products 
        * View Cart 
            - Add products to cart.
            - Check out products from cart.
        * View Order 
        * Logout
-> Java for coding 
-> 'CSV' file for storing and retrieving data.
 
Files used for each sections:
-----------------------------
    1. "credentials" file for storing user data.
    2. "category" file for storing categories.
    3. "products" file for storing Products.
    4. "cart" file for storing user cart details.
    5. "orders" file for storing user order details.
    6. "Tcart" file for checkout purpose.
 
Steps used and challenges faced to build this application:-
-----------------------------------------------------------
 
    Steps:
    ------
    1. Used MVC (Model, View, Controller) architecture for developing the console application.
    2. Added the required Models, Views and Controller along with Interface implementation to achieve abstraction.
    3. Added user-defined exceptions to catch anf handle the exceptions.
    4. Used encapsulation to hide data and used getter and setter for getting and setting the data for the models.
    5. Used "ArrayList" to store and manipulate data according to the user preferrences.
    6. Used "CSV" Files for handling data.
    7. Stored the file path, Scanner class other sensitive information in a separate Utility folder.
    8. Used Singleton pattern to avoid creating objects.
    9. Handled exceptions for invalid choices.
 
    Challenges:
    -----------
    1. Had a problem while trying to show difference between show products and show products based on category.
        -> solved it by using method overriding, created two methods with the same name with different arguments.
    
    2. Faced "StackOverFlow" - Caught this while creating parallel objects through constructor.
        -> Solved it by passing the instance "this" to other constructor.
   
    3.Had a problem while cart checkout for specific user using csv file. 
        ->Solved it by creating a temporary csv file to store the user's cart except loggedUser And overwritten the existing csv file with temporary existing csv file
          using FileInputStream and FileOutputStream. 

 
 
Working on the following sections 
---------------------------------
 
 1.Trying to update the count of the cart product.
 2.To Display the total price of the user order.
 3.Admin 
     -Add product
     -View product 
     -Delete product  
    
Credentials 
-----------
  -> For Login use the following credentials
      *Email = "a" | Password = "a"
