import random, statistics
from faker import Faker
random.seed(5)
rand_nums = [random.randint(1,10) for _ in range(3) ]

print(rand_nums)

# unpack rand_nums
first_num, second_num, third_num = rand_nums
print(first_num)
print(second_num)
print(third_num)

# unpacking using *
first_num, *middle_nums, last_num = rand_nums
print(first_num)
print(last_num)
print(middle_nums)

def sum_nums(*args):
    return sum(args)

print(sum_nums(*rand_nums) )

def user_form(**kwargs):
    return {k:v for k,v in kwargs.items() }

data = user_form(first_name = 'x', last_name = 'y', city = 'z')

a = lambda x,y:x+y
print(a(5,6) )

fake = Faker()
names_list = [fake.name() for _ in range(15) ]
print(sorted(names_list,key = lambda name:name.split[-1]) )

avg = statistics.mean(rand_nums)
print(avg)

above_avg = filter( lambda num:num > avg, rand_nums)
print(list(above_avg) )

new_nums = map( lambda num:num ** 2, rand_nums)
print(list(new_nums) )
