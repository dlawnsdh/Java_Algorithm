def is_leap(year):
    leap = 0
    if year%400==0:
        leap = 1
    elif year%100!=0 and year%4==0:
        leap = 1
    return leap
year = int(input())
print(is_leap(year))