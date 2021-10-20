# Notes App
#### Video Demo:
#### Access at: http://notes.ecdb.com.br/

## Description
This is a basic web app via which you can sign up, login and create notes for you, and eventually delete the notes you don't want displayed anymore.

## Created with 
Summary:
-> Design Pattern: API REST
-> Backend: Kotlin + Spring Boot
-> Postgre Database
-> Frontend: React.js (frontend)
-> JWT to authenticate
-> Deployed at Heroku both frontend and backend separated because it is a REST application

To create this application I took the time (around 2 months) to learn technologies and design patterns that we don't see during CS50 to further develop myself as a programmer. In my researches I found that the API REST Design Pattern is very popular in the industry, which relies in the HTTP protocol, and separates the frontend from the backend, via which the frontend makes RESTful calls to endpoints in the backend. The calling client (frontend) can perform predefined operations using the Restful service.

I used also the JWT (Json Web Token) to authenticate the user on my website, a technology that is well known in the industry as well. JWT relies on other JSON-based standards: JSON Web Signature and JSON Web Encryption and is a open standard used to share security information between two parties — a client and a server.

Mainly we have two schemas (models) in the database that are relational: Users and Notes. In the Users schema there is a field that is a LIST of their own Notes, so it's from there that we take the data to show in the /notes endpoint of each user.

To build the backend I chose to learn Kotlin because it is a versatile programming language, used to Server Side Development with Spring Boot and also Mobile Development (Android). 

# Usage 
It's a subscribing page that asks for the user's first and last name as well as their e-mail.

If signing up is succesfully proceeded a "success" HTML page will be rendered. If it's not, then a "failure" HTML page will be rendered with a "Try again" button that returns to the signing up page.

This is a toy app just for practice and I have not implemented a whole lot of security features.

# What I learned
Mainly to work with Node.js and the Express.js Framework for the back-end development.

Further learning of: JavaScript, JSON, HTML, CSS, Bootstrap, MVC, Heroku, Unix commands, GIT and version control, as well as API authentication and usage.

I also learned how to deploy an web app on Heroku via their CLI using GIT and version control. 

It was a great experience in which I was able to learn new technologies and reinforce previously learned concepts!
