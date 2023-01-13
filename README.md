PasswordGenerator
This project is a Java Console Application to generate Random passwords and performing a password strength check.

I adapted this project from github user KZarzour. This was intended to be a straightforward project. I lacked
experience and decided to copy his code. I went through and typed line for line from his project into my own.
However, once I finished I noticed some errors that went unchecked in his code. What was supposed to be a simple 
project turned into a complex debugging program. It provided me with much needed experience, experience I believe
will translate better into the workplace and for my projects going forward.
Here is the link to KZarzour's Project (https://github.com/KZarzour/Password-Generator) All glory to him

The purpose of this project can be broken down into three functionalities: 
1.) To Generate a Password
2.) To Check a Password's Strength
3.) To Provide Password Tips

Below the functionalities are futher described
1.) To Generate a Password
-The user must answer by yes or no to a series of questions to decide what they will allow
in the password. This includes upper/lower case, numbers, and characters
-The user enters the desired length
-According to what the user specified in the questions and length a password is randomly
generated to meets his criteria and displayed to him

2.) To Check a Password's Strength
The strength of the password is tested based on the inlcusion of the following criteria.
Each criteria meet awards the system a point, the max is 5, the min is 0.
Depending on the score a message is displayed to the user on a range from weak-great password.
-Upper/Lowercase letters
-Numbers
-Characters
-Length 0 <= N >= 8
-Length 9 <= N >= 16

3.) To Provide Password Tips
A tiny little function that when called upon displays tips to boost the user's password
strength score. For example, some tips look like this:
-Use a minimum password length of 8
-Avoid character repition
-Avoid using info that is well-known to collegues and friends

I have already known the basics of OOP, but this was a great opportunity to apply them.
In other words, I developed my skills further. I placed a large emphasis on commmenting,
debugging, as well as some refactoring. Also, I added new junit tests. Still, I 
should've put a little more effort into creating more of them. 
