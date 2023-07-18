# IPMS
# Project Description
In this project, your task is to create a set of APIs that simulate a small stock market system with business logic and database queries. These APIs will enable users to buy and sell stocks, with share prices automatically adjusted based on transactions. The objective of this project is to assess your programming and logical skills. Each task comes with a predefined description and examples to guide you. To test your APIs, you are required to use either Swagger or Postman.

# Task 1: User Information Retrieval API Endpoint with JSON Response
The task is to create an API endpoint, '/users', that retrieves all users' information from the database and returns a JSON response. The response format should follow the example provided:

    [
        {         
            'id': 0,         
            'name': 'testname',         
            'email': 'test@email.com',         
            'balance': 2000 
        }
    ]

To complete this task, you need to implement the necessary backend logic to fetch the user data from the database. Ensure that the endpoint responds to GET requests by retrieving and formatting the user information into the specified JSON structure.

The JSON response should include relevant user details, such as 'id', 'name', 'email', and 'balance'. These attributes should correspond to the actual user records stored in the database.


# Task 2: User Information Retrieval API Endpoint by ID with JSON Response
The task involves creating an API endpoint, '/users/:id', that retrieves user information from the database based on the provided user ID. When a request is made to this endpoint, the server should respond with a JSON-formatted response containing the user details.

The JSON response will follow the structure outlined below:

    {        
        'id': 0,        
        'name': 'testname',        
        'email': 'test@email.com',        
        'balance': 2000 
    }

To complete this task, you will need to develop the necessary backend logic to query the database and retrieve the user's information based on the provided ID. The retrieved data should be formatted into a JSON response with attributes such as 'id', 'name', 'email', and 'balance'.

By successfully implementing this API endpoint, you will enable users to retrieve specific user information by ID, enhancing the functionality and usefulness of the application.


# Task 3: Stock Information Retrieval API Endpoint with JSON Response
The task is to develop an API endpoint, '/stocks', which fetches all stock information from the database and provides a JSON response. The response format should adhere to the provided example:

    [
        {        
            'id': 0,        
            'company': 'company',        
            'quantity': 100,        
            'price': 11.25,        
            'user_limit': 25, 
        }
    ]

To accomplish this task, you will need to implement the necessary backend logic to retrieve stock data from the database. The '/stocks' endpoint should respond to GET requests and format the retrieved information into a JSON structure as demonstrated.

The JSON response should include relevant attributes for each stock, such as 'id', 'company', 'quantity', 'price', and 'user_limit'. These attributes should correspond to the actual stock records stored in the database.

Successfully completing this task will showcase your ability to design and implement a functional API endpoint that retrieves stock information and delivers it in the specified JSON format.

# Task 4: Stock Information Retrieval API Endpoint by ID with JSON Response
The task at hand involves creating an API endpoint, '/stocks/:id', which retrieves stock information from the database based on the provided stock ID. Upon receiving a request to this endpoint, the server should respond with a JSON-formatted response containing the relevant stock details.

The JSON response should adhere to the following format:

    {        
        'id': 0,        
        'company': 'company',        
        'quantity': 100,        
        'price': 11.25,        
        'user_limit': 25, 
    }

To successfully complete this task, you will need to implement the necessary backend logic to query the database and retrieve the stock information based on the given ID. The retrieved data should then be transformed into a JSON response, incorporating attributes such as 'id', 'company', 'quantity', 'price', and 'user_limit'.

By successfully implementing this API endpoint, you will enable users to retrieve specific stock information based on the provided ID, enhancing the functionality and usefulness of the application.


# Task 5: Buy Stock API Endpoint with JSON Response

Your task is to develop a POST API endpoint, '/stocks/buy', that facilitates the purchase of shares for a specific company and user.

The endpoint should adhere to the following request JSON format:

    {        
        "stock_id": 0,        
        "user_id": 0,        
        "quantity": 0 
    }

The JSON response for the transaction entry should be in the following format:

    {    
        'id': 0,    
        'stock_id': 0,    
        'user_Id': 0,    
        'quantity': 0,    
        'price': 0,    
        'transaction_type': 'buy' 
    }

To successfully complete this task, you need to implement the following business logic:

Store/update the transaction in the 'user_transactions' and 'user_stock' tables.
Enforce the maximum stock limit for a single user as specified in the 'stocks->user_limit' table.
Update the share price for the company after the purchase.
Update the new share quantity for the company.
Debit the users balance with calculated total.
Restrict users from buying more shares than the available quantity.
In case any of the above validations fail, send a response with a 400 status code.
The response will include the details of the transaction, such as the 'stock_id', 'user_id', 'quantity' of shares bought, and the 'price' at which the shares were purchased. This JSON structure allows for easy retrieval and interpretation of the transaction information.

Explanation:

Consider the scenario where User ID 1 intends to purchase stocks from Google. Google currently has 95 available stocks priced at $10 per stock, with a maximum limit of 15 shares per user. The user wants to buy 5 shares of Google. Upon executing the transaction, the following actions should occur:

Record the transaction and update the 'user_stock' entry.

Increase the stock price by a certain percentage based on the number of shares bought. In this case, the new share price would be $10.52.

By implementing this functionality, users will be able to purchase stocks within the defined constraints, and the relevant transaction and pricing updates will be reflected accordingly.


# Task 6: Sell Stock API Endpoint with JSON Response
Your task is to develop a POST API endpoint, '/stocks/sell', that facilitates the selling of shares for a specific company and user.

The endpoint should adhere to the following request JSON format:

    {     
        "stock_id": 0,      
        "user_id": 0,     
        "quantity": 0
    }

The JSON response for the transaction entry should be in the following format:

    {  
        "id": 0,  
        "stock_id": 0,   
        "user_id": 0,   
        "quantity": 0,   
        "price": 0,   
        "transaction_type": "sell"
    }

To successfully complete this task, you need to implement the following business logic:

Store/update the transaction in the 'user_transactions' and 'user_stock' tables.
Enforce the minimum stock limit of 0 for a single user.
Update the share price for the company after the transaction.
Update the new share quantity for the company.
Credit the user's balance with the calculated total.
Restrict users from selling more shares than the available quantity.
In case any of the above validations fail, send a response with a 400 status code.
The response will include the details of the transaction, such as the 'stock_id', 'user_id', 'quantity' of shares sold, 'price' at which the shares were sold, and the 'transaction_type' set as 'sell'. This JSON structure allows for easy retrieval and interpretation of the transaction information.

Explanation:

Consider the scenario where User ID 1 intends to sell stocks from Google. Google currently has 95 available stocks priced at $10 per stock, with a maximum limit of 15 shares per user. The user wants to sell 5 shares of Google. Upon executing the transaction, the following actions should occur:

Record the transaction and update the 'user_stock' entry.

Subtract the stock price by a certain percentage based on the number of shares sold. In this case, the new share price would be $9.48.

By implementing this functionality, users will be able to sell stocks within the defined constraints, and the relevant transaction and pricing updates will be reflected accordingly.

# Task 7: Transaction Information Retrieval API Endpoint with JSON Response
The objective of this task is to develop an API endpoint, '/transactions', that retrieves all transaction information from the database and provides a JSON response. The response format should adhere to the following example:

    [
        {     
            'id': 0,     
            'stock_id': 0,     
            'user_id': 0,     
            'quantity': 0,     
            'price': 0.0,     
            'transaction_type': 'Buy/Sell',     
            'transaction_date': '2023-06-09 00:00:00' 
        }
    ]

To successfully complete this task, you will need to implement the necessary backend logic to retrieve transaction data from the database. The '/transactions' endpoint should respond to GET requests and format the retrieved information into a JSON structure as demonstrated.

The JSON response will include various attributes for each transaction, such as 'id', 'stock_id', 'user_id', 'quantity' of shares, 'price' at which the transaction occurred, 'transaction_type' indicating whether it was a buy or sell transaction, and 'created_at' representing the timestamp of the transaction.

By successfully implementing this API endpoint, users will be able to retrieve transaction details, allowing for analysis and tracking of buy and sell activities within the system.


# Task 8: API Endpoint for Retrieving Single Transaction Information with JSON Response
This task entails developing an API endpoint, '/transactions/:id', which retrieves information about a single transaction from the database and returns a JSON response. The response format should adhere to the following example:

    {     
        'id': 0,     
        'stock_id': 0,     
        'user_Id': 0,     
        'quantity': 0,     
        'price': 0.0,     
        'transaction_type': 'Buy/Sell',     
        'transaction_date': '2023-06-09 00:00:00' 
    }

To successfully complete this task, you need to implement the backend logic required to fetch the specific transaction identified by the provided ':id' parameter from the database. The '/transactions/:id' endpoint should handle GET requests and format the retrieved information into a JSON structure as demonstrated.

The JSON response will include various attributes of the transaction, including the 'id' (transaction ID), 'stock_id' (stock identifier), 'user_id' (user identifier), 'quantity' (number of shares involved in the transaction), 'price' (transaction price), 'transaction_type' (indicating whether it was a buy or sell transaction), and 'created_at' (timestamp of the transaction).

By successfully implementing this API endpoint, users will be able to retrieve detailed information about a specific transaction, enabling them to analyze and assess the details of individual buy and sell activities within the system.

# Task 9: API Endpoint for Retrieving User's Stock Information with JSON Response
The objective of this task is to develop an API endpoint, '/user-transaction/stocks', that retrieves stock information for each user from the database and provides a JSON response. The response format should adhere to the following example:

    [  
        {     
            'id': 0,     
            'user_id': 0,     
            stocks: [
                        {                   
                            'company': 'company name',                   
                            'quantity': 0               
                        }
                    ] 
        }
    ]

To successfully complete this task, you will need to implement the backend logic required to fetch stock information for each user from the database. The '/user-transaction/stocks' endpoint should handle GET requests and format the retrieved information into a JSON structure as demonstrated.

The JSON response will include an array of user objects, with each object containing attributes such as 'id' (user ID), 'user_id' (user identifier), and 'stocks' (an array of stock objects). Each stock object will include details like the 'company' name and the 'quantity' of stocks owned by the user.

By successfully implementing this API endpoint, users will be able to retrieve comprehensive information about the stocks owned by each user, facilitating analysis and tracking of their stock holdings within the system.
