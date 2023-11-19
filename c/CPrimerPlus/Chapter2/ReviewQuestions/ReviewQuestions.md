## Question 1
- What are the basic modules of a C program called?
- **Answer**: A function

## Question 2
- What is a syntax error? Give an example of one in English and one in C.
- **Answer**: A syntax error is an error that deals with the grammatical side of things like the structure of a sentence or simple spelling mistakes. In English, a syntax error would be a mistake like spelling or placing a punctuation mark in the wrong place. In C, it would be typing a keyword wrong or putting it in an incorrect location.

## Question 3
- What is a semantic error? Give an example of one in English and one in C.
- **Answer**: A semantic error is an error that deals more with the logic side of things. In English, it'll be more placing a sentence in the wrong place or not making much sense at all even though it is correct English. In C, it'll be a program that does run but outputs something you weren't expecting it to. 

## Question 4 
- Indiana sloth has prepared the following program and brought it to you for approval. Please help him out.
```C
include studio.h
int main{void} /* this prints the number of weeks in a year
(
    int s

    s := 56;
    print(There are s weeks in a year.);
    return 0;
)
```
- **Answer**:  
    - The include line should be `#include <stdio.h>` and not `include studio.h`. You need the `<>` and `studio.h` is not a valid header file.  
    - `void` should be surrounded with `()` and not `{}`. The `{}` are reserved for delimiting a function or body of code.  
    - End the line */ so that /* has an end pair to stop the rest of the code from being considered comment code. 
    - The `main` function should be delimited with `{}` and not `()`.  
    - There should be a `;` at the end of `int s`.  
    - `s := 56` should be `s = 56`. The `:` does nothing and will only cause syntax errors.  
    - `print(There are s weeks in a year.);` should be `printf("There are %d weeks in a year.", s );`. 

## Question 5
- Assuming that each of the following examples is part of a complete program, what will each one print?
- **Answer**:   
    - a. Baa Baa Black Sheep.Have you any wool?  
    - b. Begone  
        &nbsp; O creature of lard!  
    - c. What?  
        &nbsp; No/nfish?  
    - d. 2 + 2 = 4

## Question 6
- Which of the following are C keywords? `main`, `int`, `function`, `char`, `=`
- **Answer**: `int` & `char` are keywords while `main`, `function` & `=` are not.

## Question 7 
- How would you print the values of the variables `words` and `lines` so they appear in the following form:
`There were 3020 words and 350 lines.`  
Here, 3020 and 350 represent the values of the two variables.
- **Answer**: `printf( "There were %d words and %d lines.\n", words, lines );`

## Question 8
- Consider the followinig program:  
```C
#include <stdio.h>
int main(void)
{
    int a, b;
        a = 5;
        b = 2; /* line 7 */
        b = a; /* line 8 */
        a = b; /* line 9 */
        
        printf( "%d %d\n", b, a );
        return 0;
}
```
- **Answer**: Program state at line 7: `a = 5, b = 2`. Program State at line 8: `a = 5, b = 5`. Program State at line 9: `a = 5, b = 5`

## Question 9
- Consider the following program:
```C
#include <stdio.h>
int main(void)
{
    int x,y;

    x = 10;
    y = 5; /* line 7 */
    y = x + y; /* line 8 */
    x = x*y; /* line 9 */
    printf( "%d %d\n", x, y );
    return 0;
}
```
- **Answer**: Program State at line 7: `x = 10, y = 5`. Program State at line 8: `x = 10, y = 15`. Program State at line 9: `x = 150, y = 15`.
