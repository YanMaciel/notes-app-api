# Notes App
#### Video Demo:
#### Access at: http://notes.ecdb.com.br/

## Description
This is a web app via which you can sign up, login and create notes for you, and eventually delete the notes you don't want displayed anymore. 

## Created with 
Summary:
- Design Pattern: API REST
- Backend: Kotlin + Spring Boot
- Postgre Database
- Frontend: React.js (frontend)
- JWT to authenticate
- Deployed at Heroku both frontend and backend separated because it is a REST application
- Git and GIthub for version control

To create this application I took the time (around 2 months) to learn technologies and design patterns that we don't see during CS50 to further develop myself as a programmer. In my researches I found that the API REST Design Pattern is very popular in the industry, which relies in the HTTP protocol, and separates the frontend from the backend, via which the frontend makes RESTful calls to endpoints in the backend. The calling client (frontend) can perform predefined operations using the Restful service.

I used also the JWT (Json Web Token) to authenticate the user on my website, a technology that is well known in the industry as well. JWT relies on other JSON-based standards: JSON Web Signature and JSON Web Encryption and is a open standard used to share security information between two parties — a client and a server.

Mainly we have two schemas (models) in the database that are relational: Users and Notes. In the Users schema there is a field that is a LIST of their own Notes, so it's from there that we take the data to show in the /notes endpoint of each user.

To build the backend I chose to learn Kotlin because it is a versatile programming language, used to Server Side Development with Spring Boot and also Mobile Development (Android). Kotlin, Spring Boot and Maven was used because is a well known powerful combo used in many companies, so I took the time to learn it and use it at my Final Project always visualizing a potential interview, showcasing it in my portfolio. Although the app is a simple Notes App, I tried to use techs, design patterns and practices that are used in the industry.

To build the frontend I took almost 1 month to further learn JavaScript and the React Framework enough so that I could render my pages with it. Again, why I chose React? Because it is in a hotspot right now in the industry, with many job opportunities requiring it. Basically I separated the pages in components: Home, Notes page, Login and Sign Up, also with a CreateArea in the Notes page and a component for the NOTES. It is a good practice using React to separate things as much as we can (maintaining order) to simplify and improve the development and maintenance of our application. The app has a simple frontend design because my focus was mainly in the backend.

It was just amazing! CS50 gave me a solid foundation and the courage to learn new things and techonologies to apply in my Final Project!!!

I will always be grateful for this amazing course and staff.

## Usage 
Make your notes and don't forget things!

It's as simple as it gets:

- You sign up (register)
- Log in
- Create your notes or delete the ones already created as you wish

## What I learned

I Learned so many things doing this project!

Mainly to work with Kotlin, Spring Boot, React, JWT and GIT for version control.

It was a great experience in which I was able to learn new technologies and reinforce previously learned concepts from the amazing CS50 course!
