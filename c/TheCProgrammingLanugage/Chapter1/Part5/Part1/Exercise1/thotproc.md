Exercise:
- Verify that the expression getchar() != EOF is 0 or 1.

Test the program in the text as is and see what happens.
A: Works as it was intended but doesn't give the answer we need.

Use printf and print it, don't use the while loop and just use the expression c = getchar() != EOF
A: it prints 1 after pressing enter and exits the proram 

Use a while loop around that statement and print 0 when the conditional statement is false 

All that I can come up with failed and searched up the solution online.
A: getchar() != EOF is a value that prints an int so you can print that expression out as is as an argument for printf.
