def solution(dots):
    answer = 0
    xlist = [dot[0] for dot in dots]
    ylist = [dot[1] for dot in dots]
    return (max(xlist) - min(xlist)) * (max(ylist) - min(ylist))