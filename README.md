# Agile Software Testing Project -  Ejunkie Shop
### *This project is for educational purposes and is intended to help participants test their own skills. E-junkie Shop project offers a comprehensive user management system for a webshop, including features such as order placement, bank card payments, and the ability to download billing statements.*

## Table of Contents
- [Project Overview](#project-overview)
- [Features Tested](#features-tested)
- [Team6 Practice Project](#team6-practice-project)
- [Technologies and Tools Used](#technologies-and-tools-used)
- [Prerequisites](#prerequisites)
- [Pull Request Rules](#pull-request-rules)
- [Contributors](#contributors)
- [License](#license)

## Project Overview

#### E-junkie Shop project, the system allows users to shop by adding products to their cart and offers convenient options for secure payment using email and accurate card information. 

## Features Tested
### The following user stories are tested in this project:

### 1- **Invalid Promotional Code Entry - (US_301)**

#### In this scenario, the user will add items to the cart and enter an invalid promo code. The screen will display an error message indicating that the code is invalid.

### 2- **Incorrect Payment Transaction - (US_302)**

#### In this scenario, the user will add an item to the cart, enter an invalid email, leave the card details blank, and view the error message.

### 3- **Failed Payment Check - (US_303)**

#### In this scenario, the user reaches the payment page, inputs their email and other information, and incorrectly enters the card number. The message ‘Your card number is invalid’ will be displayed.

### 4- **Successful Payment - (US_304)**

#### In this scenario, the user successfully completes the payment by entering all their details. A confirmation message will be displayed on the screen.

### 5- **Invoice Download Process - (US_305)**

#### In this scenario, the user is required to download and view their invoice after completing a successful payment transaction.

### 6- **Sending a Contact Message - (US_306)**

#### In this scenario, the user clicks the ‘Contact Us’ button and sends a message by filling out the required information (name, email, subject, message). The screen displays the message ‘Recaptcha did not match.’

### 7- **Access to Home Page - (US_307)** 

#### In this scenario, the user accesses the e-junkie homepage from Shopdemo.e-Junkie.com and verifies that the URL is ‘https://www.e-junkie.com/.’

### 8- **Information Access Video - (US_308)**

#### In this scenario, the user clicks on the ‘How It Works’ button on the main page of [E-junkie Shop](https://www.e-junkie.com/). The video opens in a YouTube window and can be watched successfully.

## Team6 Practice Project

- #### Domain:  [shopdemo.ejunkie.com](https://shopdemo.fatfreeshop.com/).

- #### Supported browsers: [Chrome](), [Safari](), [Firefox]()

## Technologies and Tools Used

The basic technologies and tools to be used in this project include:

- **Java** - Programming language
- **Selenium** - Web browser automation
- **Apache POI** - Library for reading and writing Excel files
- **Git & GitHub** - Version control Systems 
- **JIRA & Zephyr-Squad** - Test management Tools

## Prerequisites

- **Java Development Kit (JDK):** Installed on your system for writing and compiling Java code.

- **IDE (Integrated Development Environment):** Choose IntelliJ IDEA for Java development.

- **Git:** Installed for version control, it is essential for managing your project's source code on GitHub.

- **Selenium WebDriver:** Become familiar with its usage and basic automation techniques.

- **JIRA & ZEPHYR Test Management Tool:** If using the system, ensure access to and understanding of test case creation, management, and defect reporting.

 ## Pull Request Rules

 When contributing to this project, please adhere to the following guidelines:

1. **Create a Descriptive Pull Request Title**: Ensure that your pull request title clearly describes the changes you're making.

2. **Provide Detailed Descriptions**: In your pull request description, provide a clear and detailed explanation of the changes you've made and why they are necessary.

3. **One Pull Request per Feature**: If you're adding multiple features or making several changes, please submit each as a separate pull request.

4. **Follow Code Standards**: Maintain code cleanliness and adhere to the coding standards used in the project.

5. **Test Your Changes**: Before submitting a pull request, test your changes thoroughly to ensure they work as expected and do not introduce any regressions.

6. **Update Documentation**: If your changes impact any documentation, make sure to update it accordingly.

7. **Resolve Conflicts**: If there are any conflicts with the base branch, resolve them before submitting your pull request.

8. **Request Reviews**: Assign reviewers to your pull request to ensure that your changes are properly reviewed before merging.

9. **Be Responsive**: Respond promptly to any feedback or comments on your pull request.

10. **Ensure CI/CD Passes**: Ensure that all continuous integration (CI) checks pass before merging your pull request.


## Contributors

  
| Contributor                                               | Role                                  |
|-----------------------------------------------------------|---------------------------------------|
| [Ümmühan Teke](https://github.com/UmmuhanTeke)            | Project Lead & QA Automation Engineer |
| [Merve Kaya](https://github.com/kayyamervee)              | QA Automation Engineer                |
| [Abdulkerim Mutlu](https://github.com/AbdulkerimMutlu)    | QA Automation Engineer                |
| [Sefa Kahraman](https://github.com/SefaKahramann)         | QA Automation Engineer                |
| [Songül Çam](https://github.com/songulcam)                | QA Automation Engineer                |

## License  

This project is open-sourced software licensed under the [MIT license](https://opensource.org/licenses/MIT).
