import random
from collections import defaultdict
from pathlib import Path
import shutil
random.seed(1234)
d = {'a':1, 'b':2, 'c':3}
print(d)

t = (('first', 11), ('second', 22), ('third', 33))

english_words = ['Monday', 'Tuesday', 'Wednsday']
spanish_words = ['Lunes', 'Martes', 'Miercoles']

translator = zip(english_words, spanish_words)
print(dict(translator))

t_d = dict(translator)
# print(t_d['Monday']) # spelling and case-sensitive
print(t_d.get('Tuesday', 'No data found')) # more lenient than the previous method as it returns None or an error when it can't find anything

# t_d['Thursday'] = 'Jueves'
# print(t_d)

# del t_d['Monday']

# word_popped = t_d.pop('Wednsday')
# print(t_d)

weekends = {'Saturday':'Sabado', 'Sunday':'Domingo'}

all_words = t_d | weekends
print(all_words)

for k in all_words.keys():
    print(k)

for v in all_words.values():
    print(v)

for k,v in all_words.items():
    print(k,v)

d_nums = {random.randint(1,20):i for i in range(1,11)}
print(d_nums)

print(dict(sorted(d_nums.items())))

dd = defaultdict(int)
dd['a']
dd['b'] = 'test'
dd['c']
print(dd)

curr_dir = Path.cwd()
print(curr_dir)
home_dir = Path.home()
print(home_dir)

for item in curr_dir.iterdir():
    if item.is_file():
        print(item.stem)
    elif item.is_dir():
        print(item)

for item in curr_dir.rglob("[hH]*"):
    print(item)

dickens_file = curr_dir/"dickens.txt"
dickens_copy = curr_dir/"dickens_backup.txt"
shutil.copy(dickens_file, dickens_copy)

with open(dickens_file, mode='r') as file:
    content = file.read()
print(content)
