Code documentation for a Rube Goldberg Machine

Compiler:codeBlocks IDE with GNU GCC compiler

Instructions on how to use my program 

-	Put the folder named “assignment4” in a particular location on your computer. 
        This folder contains all the source, header files and the executable file as well as the input files. 
-	Launch your favorite C++ compiler, go to file menu, choose open and browse to the assignment4 folder. 
-	Select the C++ assignment4 project
-	Compiler and run the program. 


Expected outputs: 
6 text files will be created and placed in the assignment4 folder; these files are named output1.dat through output6.dat. 
The content of these files is what the assignment states they should contain. 

Note: the program creates 6 output text files instead of 7 as it is stated in the assignment. 
This is because the output6.dat file contains the sorted list of element objects from both the InputFile and more-input text files. 
After running the program, the first lines of the output6.dat file will be contain single quotation marks, 
but despite this, just scroll down and you will see a sorted list of object elements from both the InputFile and more-input text files. 
I tried to solve this issue, but I couldn’t. I think the reason why this happened, 
it’s because I used a loop to loop through the array of sorted elements and this loop does more iterations than it is supposed to do. 
It’s hard to get the size of an array in C++, you can’t use size() or length() as it is in Java unless you use the vector container. 
