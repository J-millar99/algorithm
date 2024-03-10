def solution(myString):
    myString = sorted(myString.split('x'))
    while "" in myString:
        myString.remove("")
    return myString