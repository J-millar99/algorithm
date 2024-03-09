def solution(myString, pat):
    chString = ""
    for ch in myString:
        if ch == 'A':
            chString += 'B'
        elif ch == 'B':
            chString += 'A'
    if pat in chString:
        return 1
    return 0