# CSC301 Assignment 2 - Pizza Delivery App

## Getting Started

This application is a Command Line Interface, where you can order Pizza!

This project uses Maven. I have used IntelliJ IDE for this assignment, so instructions will be based on IDE users.

Follow these steps :

1) Run command
        
        git clone https://github.com/csc301-winter-2019/pair03-Succarst-leehamin.git

2) In Eclipse, you can select  Import -> Maven -> Existing Maven Project

3) In IntelliJ, you can find the information [here](https://www.jetbrains.com/help/idea/maven-support.html)

## How to Use
Normally you will be using Maven.

1) Run 

        mvn build

2) Then, run

        java -cp target/a2-paired-0.0.1-SNAPSHOT.jar a2.PizzaParlour
        
However, the maven project would'nt let me set Main Class using "manifest", so I'll tell you how to run it on IDEs.

1) Open

        cd /src/main/java/a2
2) Right click on PizzaParlour.java, then run

        Ctrl + Shift + F10
        or
        Right click and select Run PizzaParlour.main()



## Pair Programmed Features
The features we pair programmed are "Ask for pick up or delivery" and "Cancel order". We chose these features because 
it was relatively shorter than other features thus could be done in the restricted time we had together. The APIs and basic
functionality of the product was implemented at the time of pair programming and this enhanced our efficiency as well as saved 
us a lot of time initially. 

## Process

### Feature 1
Ask for pick up or delivery, which allows users to select the type of delivery. Delivery options are Pick Up, Delivery, Uber
Eats, and Foodora. The options are displayed as they are asked the delivery options. We have implemented specifications 
defined in the A2 handout. Peer programming came handy when the Navigator(Steven) was able to find out how to store JSON
and CSV data. 

#### Link to Commit
[Commit History](https://github.com/csc301-winter-2019/pair03-Succarst-leehamin/commit/fbabb395c14c965e75bab95d1d58ced554225e4d
)
#### Driver 
Hamin Lee

#### Navigator
Steven Succar

### Feature 2
Cancel order, which allows users to cancel their current order. Our design was such that the customer will get an option
to cancel the order at the end of the pizza order. We decided on implementing the cancel function this way so that we could 
reduce the rate of order cancellation. Pair programming helped the Driver to implement features without the hassle of learning
the API because the Navigator has written the API. Also, the Navigator was able to see more points of improvements which 
led to cleaner coherent code.

#### Link to Commit
[Commit History](https://github.com/csc301-winter-2019/pair03-Succarst-leehamin/commit/fa1642e614a27bfe0e302f69fcbbc7da731c101d
)

[Issue #7 Link](https://github.com/csc301-winter-2019/pair03-Succarst-leehamin/issues/7)

#### Driver 
Steven Succar

#### Navigator
Hamin Lee

## Reflection
### Pairing Variation
In our case we had an Expert(Hamin)-Novice(Steven) pairing variation, which was beneficial for the Novice to learn from the
Expert. However, due to time restriction, there were many times where Expert had to take over some part of the coding of 
the Novice. Overall, both of us learned from this experience as well as saved time, we expected this feature to take 2 hours
but only took 1.5 hours as we pair programmed. This means more programmer time, but still less time was consumed.

### What we liked
As mentioned above, features took less time to implement by having two brains working on one problem.
Having someone constantly check our code that keeps us vigilant and alert thus resulted in a cleaner code. While navigating,
we were able to slow down and suggest possible implementations that will enhance the quality of the code. In result,
we were able to write a code that has high coherence, and minimal duplicate codes. If we were to code by ourselves,
it would've been much harder to achieve high quality code. 

Also, we both have different roles in our respective teams, thus that brought fresh perspectives of each roles.

### What we disliked
We had different prior experiences as well as different ways of interpreting the task at hand. Thus, the Expert(Hamin) in
many times, had to take over for some part of coding for feature 2. This might of reduced the amount of material Novice could
learn. Also, by pair programming, we were working at only one feature while we could have worked on two. If only thinking of
time efficiency, I would way pair programming is not the right workflow. If the expert did not take over, the pair programming
process would have been much longer resulting in increased programmer time. This is not optimal if you are a business that's
willing to make profit.
Also, it was hard finding a time where we were both able to work on the assignment at the exact same time.



## Program Design
### Design Pattern
We chose to use the Abstract Factory Method design pattern for the implementation. 
It was optimal to have a factory interface that defines multiple methods. 
The interface can be found at Pizza.java. 
This way it was much easier to plan out what to code and thus led to a clearer architecture. 
Also, since there is two class PizzaOrder and PizzaStore, 
it was optimal to store a central interface where both classes can access the interface. 


## Tools Used
Hamin - I have used IntelliJ IDE which helped me stay consistent with my code as well as achieve high cohesion.
IntelliJ IDE highlights the code that is being used, to ensure high cohesion or even maximal cohesion.
It made my code cleaner because it underlined all the codes that were duplicated, thus I was able to implement helper functions
to reduce lines of codes.
It increased my efficiency immensely compared to working with standard editor like VSCode. 
IntelliJ IDE has many integrated options such as running main class for each .java class which helped me save time testing the CLI. 
Also, many built-in functions came in handy when developing this product.



