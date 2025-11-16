from collections import namedtuple
str = 'Hello this is me'

print(str[0:10:2] )

print(str * 3) # duplication of str
print( str.count('i') )
print(str.index('o') )

tup = 1,2,3.14,True,'Mark'

print(tup)
print( tuple(tup[4]) )

list = [ 1,2,3.14,True,'Mark' ]

print(str.split() ) # each word becomes it's own element 

# list comprehension
squares = [ i ** 2 for i in range(10) ]
# or
squares1 = []
for i in range(1, 10):
    squares.append(i ** 2)

nestlist = [ 1, 2, 3, 4, [11, 22, 33, 44], 100 ]
print( nestlist[4][-1] )

# unpacking
addr = 'Mark', 'Segal', '1 main st', 'mytown', 'nj', '0807'
fname, lname, street, city, state_nm, zip_code = addr
print( f"{fname} {lname} lives at {city.title()}, {state_nm.upper()} {zip_code}" )

address_collector = namedtuple('address_collector', ['first_name', 'last_name', 'street', 'city', 'state', 'zip_code'])
print(address_collector)
addr1 = address_collector('Mark', 'Segal', '1 main st', 'mytown', 'nj', '0807')
print(addr1)
