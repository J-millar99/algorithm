def solution(s):
    sum = 0
    temp = 0
    num_data = s.split()
    for numStr in num_data:
        if numStr == "Z":
           sum -= temp 
        else:
            temp = int(numStr)
            sum += temp
    return sum