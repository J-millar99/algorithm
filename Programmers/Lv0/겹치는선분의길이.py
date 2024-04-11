def remove_all(lst, value):
    return [x for x in lst if x != value]

def solution(lines):
    alline = []
    answer = 0
    for line in lines:
        for i in range(line[1] - line[0]):
            alline.append([line[0] + i, line[0] + i + 1])

    for line in alline:
        if alline.count(line) > 1:
            answer += 1
            alline = remove_all(alline, line)

    return answer