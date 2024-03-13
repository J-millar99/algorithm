def solution(array):
    string = ""
    for numstr in array:
        string += "".join(str(numstr))
    return string.count('7')