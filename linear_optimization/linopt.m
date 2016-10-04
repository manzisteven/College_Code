
% This function takes a text file which contains a linear optimization problem as input
% param: example2: a text file that contains the linear optimization
% problem. 
  function in = linopt(example2)
% Split the file content line by line and store the result in S
    s = regexp(fileread(example2), '\n', 'split');
% Access the first element in S and remove all spaces
    a = strrep(s{1,1},' ','');
% Match the expression defined in the regular expression 
    [q,w,e,r,t,y,u]=regexp(a,'ObjectFunction:[A-Za-z]+=');
    %disp (u{1,2});
% The unmatched content is stored in u. then match again the expression
% defined in the regular expression. 
    [q,w,e,r,t,y,g]=regexp(u{1,2},'[A-Za-z]+');
    len = (size (g,2)-1);
    g{1,3} = 0;
% Store the value on the right hand side of the objective function in a
% separate variable (RHS3). 
    RHS3 = g {1,3};
% Store the values on the left hand side of the objective function in V
    for i=1:len
    v(i)=str2double(g{1,i});
     if  isnan (v(i)) == 1;
         v(i) = 1;
     end 
    end
    object_function = -v;
% Acess both contraint equations stored in s(1,2) and s (1,3), use the
% expressions defined in the regular expressions to remove all characters
% and symbols. finally store the values on the left hand side and right
% hand side of the constraint equations in separate variables. 
    b = strrep(s{1,2},' ','');
    
    [q,w,e,r,t,y,u]=regexp(b,'Constraint:');
    [q,w,e,r,t,y,g]=regexp(u{1,2},'<=');
    RHS1 = str2double((g{1,2}));
    [q,w,e,r,t,y,k]=regexp(g{1,1},'[A-Za-z]+');
    len = (size (k,2)-1);
    for i=1:len
    j(i)=str2double(k{1,i});
    if  isnan (j(i)) == 1;
    j(i) = 1;
    end
    end
    constraint1 = j;
    c = strrep(s{1,3},' ','');
    [q,w,e,r,t,y,u]=regexp(c,'Constraint:');
    [q,w,e,r,t,y,g]=regexp(u{1,2},'<=');
    RHS2 = str2double((g{1,2}));
    [q,w,e,r,t,y,k]=regexp(g{1,1},'[A-Za-z]+');
    %disp (k);
    len = (size (k,2)-1);
    for i=1:len
    j(i)=str2double(k{1,i});
    if  isnan (j(i)) == 1;
    j(i) = 1;
    end
    end
    constraint2 = j;
    xy = [constraint1; constraint2; object_function];
    I = double(zeros(1));
    len = size(xy,1)-1;
    s = [RHS1; RHS2; 0];
  
  
   
   % Form the matrix that represents the initial simplex tableau. 
    
    input = [xy,[eye(len);zeros(1,len)],[zeros(1,len)';1],s];
  
   
    simplex (input);
   

end

