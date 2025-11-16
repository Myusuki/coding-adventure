import random
print(True)
print(False)

x = 10
if x < 20:
    print(x)

a = 0
print(a)
print( bool(a) )

str = ''
print(str)
print( bool(str) )

z = 10
y = 20
if z > 5 and y < 50:
    print( "This is good to go!" )
elif z < 5 or y > 50:
    print( "This is good to go!" )

rng = random.randint(1,10)
print(rng)
rng = random.random()
print(rng)
