import math
str = 'hello'
print( str.upper() )
print( str.lower() )
print( str.title() )

for i in range( len(str) ):
    print( str[i] )

print( str.count('l') )

print( str.find('l') )

num = 9
print( math.sqrt(num) )

# code to take the name and radius and develop solutions
username = input( "Enter your name: " )

radius = float( input( "Enter the radius of a circle: " ) )

print( radius )
print( username.upper() )
print( username.lower() )
print( username.title() )
print( f"The length of your name is {len(username)}!" )
print( username[0] )
print( username[-1] )
circumference = 2 * math.pi * radius
area = math.pi * (radius ** 2)
print( f"The circumference of the circle is { circumference: .2f}, and the area is {area: .2f}, {username}!" )
