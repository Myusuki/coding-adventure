'''
A Class Grading program that generates random grades 
for 25 students. Prints out the student with the highest grade 
and the student with the lowest grade along with the class average.
'''
import random
from pathlib import Path


# random generate grades for 25 students
rngGrades = [ (i * 0) + random.randint(50,101) for i in range(0, 25) ]

# retrieve names from names_list.txt and split them up into a list 
namesFile = Path.cwd()/"names_list.txt"
with open(namesFile, mode = 'r') as file:
    fileContent = file.read()
    namesList = fileContent.split(', ')

# create dictionary with names as keys and grades as values
nameGradeDict = dict(zip(namesList, rngGrades) )

'''
create names_and_grades.txt in current working directory
and fill it with student names and grades
'''
namesGradeFile = Path.cwd()/"names_and_grades.txt"
Path.touch(namesGradeFile)
with open(namesGradeFile, mode = 'a') as file:
    for k,v in nameGradeDict.items():
        file.write( f"{k} received a grade of {v}.\n" )

# find the student with the highest grade 
topGrade = 0
topStudent = ""
for k,v in nameGradeDict.items():
    if v > topGrade:
        topGrade = v
        topStudent = k
#find the student with the lowest grade
bottomGrade = topGrade
bottomStudent = ""
for k,v in nameGradeDict.items():
    if v < bottomGrade:
        bottomGrade = v
        bottomStudent = k
# find the class average 
avgGrade = float(0)
for grade in nameGradeDict.values():
    avgGrade += float(grade)
avgGrade /= float(25)

# print top, lowest, and class avg grade 
print( f"The student with the top grade of {topGrade} is {topStudent}." )
print( f"The student with the bottom grade of {bottomGrade} is {bottomStudent}." )
print( f"The average grade is {avgGrade:.1f}." )
