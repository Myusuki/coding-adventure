## Question 1
- Run Listing 4.1 again, but this time give your first and last name when it asks you for your first name. What happens? Why?
- **Answer**: It prints out your first name and skips the rest of the procedure. Reason being that scanf only read my first name and then left the rest of the input for the next read. The next read is reading for a float number. Through testing what happens when you try and have a `char` printed as a float, you'd get 0.0 as an output. `scanf` read my first name up to space and then read the initial of my last name as a float resulting in 0 for the rest of my input and the rest of my last name never read or used. 

## Question 2
- Assuming that each f teh following examples is part of a complete program, what will each one print?
    - a. `printf( "He sold the painting for %2.2f.\n", 2.345e2 )`  
    - b. `printf( "%c%c%c\n", 'H', 105, '\41' )`  
    - c. 
    ```C
    #define Q "His Hamlet was funny without being vulgar."
        printf( "%s\nhas %d characters.\n", Q, strlen(Q) );
    ```
    - d. `printf( "Is %2.2e the same as %2.2f?\n", 1201.0, 1201.0)`
- **Answer**:
    - a. 234.5
    - b. Hi!
    - c. 
    ```
    His Hamlet was funny without being vulgar.
    has 42 characters.
    ```
    - d. 1.20e3 1201.00

## Question 3
- In Question 2c, what changes could you make so that string `Q` is printed out enclosed in double quotation marks?
- **Answer**: "\"His Hamlet was funny without being vulgar.\""

## Question 4
- It's find the error time!
```C
define B booboo
define X 10

main(int)
{
    int age;
    char name;
    printf( "Please enter your frist name." );
    scanf( "%s", name );
    printf( "All right, %c, what's your age?\n", name );
    scanf( "%f", age );
    xp = age + X;
    printf( "That's a %s! You must be at least %d.\n", B, xp );
    return 0;
}
```
- **Answer**: 
