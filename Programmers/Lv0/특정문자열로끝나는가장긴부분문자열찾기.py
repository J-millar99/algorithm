def solution(myString, pat):
    found = myString.rfind(pat)
    return myString[:found + len(pat)]