## Devlog

### Session 1 - [19/10/2026]
* **What I worked on:** Setting up environment, seeing if things worked with HackClub integration. 
* **Challenges**: Nothing, didn't do much. 
* **Next Steps:** Make an equation interpreter that can take text (eg: 2x+1) and parse it and perform operations, if possible. 

### Session 2 - [19/10/2026]
* **What I worked on:** Planned how a parser would work
* **Challenges** How to make the parser, store output intuitively, and use it during runtime. 
* **Next Steps** Make the parser as a loop, and set it up so args[] can work directly with it. To test, I will probably set up a program that inputs a value at the variable and check if it is correct. 

### Session 3 - [20/10/2026]
* **What I worked on:** Set parser to identify numbers, works with multiple digits and decimals
* **Challenges:** Get parser to identify various functions, and how to store them. 
* **Next Steps:** Determine if ArrayList should be double, String, or something else. Also get it to identify 7 basic symbols (+, -, *, /, ^, '(', ')')

### Session 4 - [20/10/2026]
* **What I worked on:** Changed ArrayList to a token system
* **Challenges:** Changing between char, double, String, and Token
* **Next Steps:** Still need to get it to identify 7 basic symbols, possibly apply PEMDAS to equations without variables. 

### Session 5 - [23/10/2026]
* **What I worked on:** Started making a basic operations solver. Haven't tested, but should be able to find parenthesis and solve it independently (though the code isn't there to solve it yet)
* **Challenges:** Order of operations, trying to be efficient with code
* **Next Steps:** Add the 5 other operations, explore more efficient methods

### Session 6 - [24/10/2026]
* **What I worked on:** Finished simple equation solver
* **Challenges:** Nested parenthesis, also code might not be the most efficient
* **Next Steps:** Explore more efficient methods, implement more functions, and variables in regular parsing
