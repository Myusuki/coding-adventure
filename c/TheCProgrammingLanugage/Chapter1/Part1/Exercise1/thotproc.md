Exercise: 
- Run the "hello, world" program on your system. Experiment with leaving out parts of the program to see what error messages you get. 

* Warning: main function is missing a type specifier int
- probably a standards change that leads to such a warning

Q: What would happen if the # of the preprocessor was preprocessor?
A: '=', ',' , ';', 'asm', or '__attribute__' expected before '<' token

Q: What would happen if I forgot the include keyword?
A: Preprocessing directive is invalid. printf is implicitly declared and is incompatible.

Q: What would happen if the code ran without a main function?
A: Expected a declaration of specifiers or '...' before string constant.

Q: What would happen if no directory was argued to #include?
A: #include expects a filename and other functions that are called from other files are incompatible-implicitly declared.

Q: What if there was just a string constant and no printf?
A: ';' was expected before '}'
Q: And what if I do comply to the error message?
A: It does compile but when you run the executable it outputs nothing. 
