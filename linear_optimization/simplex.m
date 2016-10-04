% { a function to conpute the optimal solution of a given linear program                                         
%}
function ret = simplex (input)
% Input matrix 

[row column] = size(input);
% Print out the initial tableau
fprintf('Initial table\n'),disp(input);
% Loop counter
count = 1;
% {This loop counter counts up to 100,000. I deliberately choose this large
% number to simulate an infinity loop, a loop that will be executed as long
% as there is a negative value in the object function row vector. %} 

while count < 100000
% Return the most negative number in the objective function row vector
[min_value, pivot_column] = min(input(row,:));
% If min_value is less than zero, compute the pivot, pivot row, turn the
% pivot into 1 and turn all the numbers in the pivot column, except the
% pivot, into zero. finally, return the updated tableau. Otherwise, skip
% all these operations, go ahead and return the last simplex tableau.
if min_value < 0
% The calculate_Pivot_row and update_Table functions are invoked. When these
% functions return, the updated simplex tableau is displayed. 
     pivot_Row = calculate_Pivot_row(input,pivot_column);
% Execute this block of code only when the pivot_Row is greater than zero, 
% in other words, if there are some positive values in the pivot column.
% Otherwise, report that there is no Solution. 
 if pivot_Row > 0
     input = update_Table(input,pivot_column,pivot_Row);
     result = strcat('Simplex tableau :',num2str(count));
     disp(result);
     disp(input);
    
 else
     fprintf('\n There is no solution')
     
 end
% As discussed above,this block of code will be executed when there is no 
%longer a negative value in the objective function row vector.  
 else 
        fprintf('\n Optimal solution has been reached')
        fprintf('\n Last table :')
        fprintf('\n-------------\n'),disp(input);
        display_finalresult(input);
        
        return;
 end
    count = count +1;
end
% This function returns the pivot row
%@param: input: the current simplex tableau
%@param: pivot_coulmn: the pivot coulmn as its name indicates. 
function pivot_Row_Returned = calculate_Pivot_row(input,pivot_column)
[row, column] = size(input);
% The pivot_row is initialized to zero and it will eventually store the
% pivot row, if there are some positive values in the pivot coulumn.
pivot_row = 0; 
% The reference_Varibale is used to help me keeping track of the row with the least number
% in the last column of the matrix being manipulated. This row will be the
% pivot row. Note: its initial value was randomly chosen. 
reference_Variable = 5000;
% loop through all the rows
for count = 1: row
% Execute this block of code only when there are some positive values in the
% pivot column. 
    if input(count,pivot_column) > 0
        row = input(count,column)/input(count,pivot_column);
        if row < reference_Variable
            reference_Variable = row;  pivot_row = count;
        end
    end
end
% If pivot_row is equal to zero, inform the user what's wrong with the
% input matrix and return from the function. 
if pivot_row == 0
    fprintf('Not positive numbers in pivot column ')
    return;
end
 pivot_Row_Returned = pivot_row;
% This function returns the updated simplex tableau
%@param: input: the current simplex tableau
%@param: pivot_coulmn: pivot column
%@param: pivot_row: pivot row
 function updated_Table = update_Table(input,pivot_column,pivot_row)
[row, column] = size(input);
% This line of code divides the entire pivot row by the pivot, which
% results in the pivot being turned into one. 
 input(pivot_row,:) = input(pivot_row,:)/input(pivot_row,pivot_column);
% Loop through all the rows
for count = 1: row
% Turn all the values in the pivot coulmn, other than the pivot, into zero.
% The formula used here is -m*Rpivot_row + Rm where m is the number that is
% to be turned into zero, Rpivot_row is the pivot row and Rm is the row
% where m resides. 
    if (count ~= pivot_row)
        input(count,:) = input(count,:) - input(count,pivot_column)*input(pivot_row,:);
    end
    
end
updated_Table = input;
% This function takes the final tableau as input 
% @param: input: final tableau
%  This function has two loops, one loop that loops through the first column
% , in other words it loops through the values of x while searching where x
% is equal to one, if one is found the value in the rightmost column in
% this row is displayed, otherwise x is equal to one. 
% It does pretty much the same for column 2, in this case searching in the y
% values. 
function result = display_finalresult(input)
 [row, column] = size(input);

     if sum(input(1:end,1)) == 1
          for count = 1: row
          if input(count,1) == 1
              result = input(count,column);
              result1 = strcat('x=',num2str(result));
              disp(result1);
              
          end
          end
     else
         result2 = strcat('x=',num2str(0));
         disp(result2);
         
         
     end 
       if sum(input(1:end,2)) == 1
          for count = 1: row
          if input(count,2) == 1
              result3 = input(count,column);
              result4 = strcat('Y=',num2str(result3));
              disp(result4);
              
          end
          end
       else
         result5 = strcat('Y=',num2str(0));
         disp(result5);
         
         
       end 
          if column == 7
          if sum(input(1:end,3)) == 1
          for count = 1: row
          if input(count,3) == 1
              result3 = input(count,column);
              result4 = strcat('z=',num2str(result3));
              disp(result4);
              
          end
          end
       else
         result5 = strcat('z=',num2str(0));
         disp(result5);
         
         
          end 
          end
            if  column == 8
          if sum(input(1:end,3)) == 1
          for count = 1: row
          if input(count,3) == 1
              result3 = input(count,column);
              result4 = strcat('z=',num2str(result3));
              disp(result4);
              
          end
          end
       else
         result5 = strcat('z=',num2str(0));
         disp(result5);
         
         
          end 
         
          if sum(input(1:end,4)) == 1
          for count = 1: row
          if input(count,4) == 1
              result3 = input(count,column);
              result4 = strcat('w=',num2str(result3));
              disp(result4);
              
          end
          end
       else
         result5 = strcat('w=',num2str(0));
         disp(result5);
         
         
          end 
           end
          
          
      
   result01 = input(3,column);
   result6 = strcat('P=',num2str(result01));
   disp(result6);

 

