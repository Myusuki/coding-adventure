## Question 1
- Which data type would you use for each oft he following kinds of data (sometimes more than one type could be appropriate)?  
**Answer**:   
    - a. The population of East Simpleton - unsigned int-long long depending on expectations  
    - b. The cost of a movie on DVD - double-long double depending on how expensive it is  
    - c. The most common letter in this chapter - char   
    - d. The nmuber of times that the ltter occurs in this chapter - unsigned int-long 

## Question 2
- Why would you use a type `long` variable instead of type `int`?  
**Answer**: If the number that you want to display or hold is larger than what an `int` can hold. Also to make the program more portable.

## Question 3
- What portable types might you use to get a 32-bit signed integer, and what would the rationale be for each choice?  
**Answer**: 
    - `int32_t`: for an exact bit-width of 32-bits
    - `int_least32_t` for at least 32-bits 
    - `int_fast32_t` for fastest computation of 32-bits

## Question 4
- Identify the type and meaning, if any, of each of the following constants:  
    - a. '\b'  
    - b. 1066  
    - c. 99.44  
    - d. 0XAA  
    - e. 2.0e30  
**Answer**:
    - a. char, backspace
    - b. int
    - c. float
    - d. hexadecimal int, 170
    - e. double 

## Question 5
- Dottie Cawm has concocted an error-laden program. Help her find the mistakes.
```C
include <stdio.h>
main
(
        float g; h;
        float tax, rate;
        
        g = e21;
        tax = rate*g;
)
```
**Answer**: 
```C
#include <stdio.h>

int main(void)
{
    float g, h;
    float tax, rate;

    g = e21; // needs a real number before the exponential component
    tax = rating;
}
```

## Question 6
- Identify the data type (as used in declaration statements) and the printf() format specifier for each of the following constants:
    - a. 12
    - b. 0x3 
    - c. 'C'
    - d. 2.34E07 
    - e. '\040'
    - f. 7.0
    - g. 6L
    - h. 6.0f
    - i. 0x5.b6p12  
**Answer**:
    - a. int, %d
    - b. hexadecimal int, %#X 
    - c. char, %c
    - d. exponential float, %e
    - e. char, %c
    - f. float, %f
    - g. long int, %ld
    - h. float, %f
    - i. hexadecimal float, %a

## Question 7
- Identify the data type (as used in declaration statements) and the print() format specifier for each of the following constants (assume a 16-bit int):
    - a. 012
    - b. 2.9e05L
    - c. 's'
    - d. 100000
    - e. '\n'
    - f. 20.0f
    - g. 0x44
    - h. -40  
**Answer**: 
    - a. octal int, %#o
    - b. long double, %Le
    - c. char, %c
    - d. long int, %ld
    - e. char, %c
    - f. float, %f
    - g. hexadecimal int, %x
    - h. int, %d

## Question 8
- Suppose a program begins with these declarations:
```C
int imate = 2;
long shot = 53456;
char grade = 'A';
float log = 2.71828;
```
Fill in the proper type specifiers in the following print() statements:
```C
printf( "The odds against the %_ were %_ to 1.\n", imate, shot );
printf( "A score of %_ is not an %_ grade.\n", log, grade );
```
**Answer**: d, ld, f, c

## Question 9
- Suppose that `ch` is a type `char` variable. Show how to assign the carriage-return character to `ch` by using an escape sequence, a decimal value, an octal character constant, and a hex character constant. (Assume ASCII code values.)
**Answer**:
    - escape sequence: `ch = '\r';`
    - decimal value: `ch = 13;`
    - octal value: `ch = '\015'`
    - hexadecimal value: `ch = '\xd'`

## Question 10
- Correct this silly progrm. (The / in C means division)
```C
void main(int) / this program is perfect / 
{
    cows, legs integer;
    printf( "How many cow legs did you count?\n);
    scanf( "%c", legs );
    cows = legs / 4;
    printf( "That implies there are %f cows.\n", cows )
}
```
**Answer**:
```C
#include <stdio.h>
void main() /* this program is perfect */
{
    int cows, legs;
    printf( "How many cow legs did you count?\n" );
    scanf( "%d", &legs );
    cows = legs / 4;
    printf( "That implies there are %d cows.\n", cows );
}
```

## Question 11
- Identify what each of the following escape sequences represents:
    - a. \n
    - b. \\\
    - c. \"
    - d. \t
**Answer**:
    - a. new line
    - b. backslash \
    - c. quotation mark "
    - d. horizontal tab
