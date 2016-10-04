Author: Manzi steven

Both my simplex ADT and test harness are implemented in Matlab
Matlab version: MATLAB R2013a

Here are guidlines on how to use my simplex ADT 
My simplex ADT can be used in two different ways

Fist way: using my simplex ADT by calling linopt.m file
Anyone who wish to use my simplex ADT can follow the following steps:

- run both the simplex.m and linopt.m files 
- call linopt with the name of the text file that contains the linear optimation equations. 
for example:
Assume we have our linear optimization equations stored in a text file called example1.txt.
To use my simplex ADT with this file, you can just call linopt like this 
linopt ('example.txt')
Note: Because I used some specific regular expressions in the linopt.m file, your linear optimization problem must stick to 
this format:

Object Function: p = 2x + 6y+ z + 10w
Constraint: x + y + 2z + 5w <= 40
Constraint: 2x + y + 3z + 5w <= 10

Second way: 
Construct the initial simplex tableau according to the format that is discussed in the report.pdf file in part3.
Call the linopt with the matrix produced by the initial simplex tableau

Either way you can choose to use my ADT, the following outputs are expected:

- all intermidiate tableau and the final tableau
- the opmized values 
