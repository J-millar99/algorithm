def solution(my_string):
    sum = 0
    for ch in my_string:
        if ch in "123456789":
            sum += int(ch) 
    return sum