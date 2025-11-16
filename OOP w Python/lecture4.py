from datetime import date, timedelta
import calendar

r = range(10)

print( list(r) )

month_selected = int(input("Enter the integer of the month you want: ") )
year_selected = int(input("Enter the 4 digit integer of the year you want: ") )
date_selected = date(year_selected, month_selected, 1)
eom = calendar.monthrange(year_selected,month_selected)[1] #returns last day of month

print(date_selected)

print(eom)

next_day = timedelta(days=1)
while date_selected.weekday() != 5:
    date_selected += next_day

print(date_selected)
print(f"The first Saturday is {date_selected.strftime('%B %d, %Y')}")

for i in range(date_selected.day, eom + 1, 7):
    date_selected = date(year_selected, month_selected, i)
    print(f"{date_selected.strftime('%B %d, %Y')}" )
    
