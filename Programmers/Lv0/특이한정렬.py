# 내 풀이
def solution(numlist, n):
    answer = []
    distance = []
    numlist.sort()
    for i in range(len(numlist)):
        distance.append(abs(n - numlist[i]))
    while len(answer) != len(numlist):
        min_value = min(distance)
        if distance.count(min_value) >= 2:
            min_indices = [i for i, x in enumerate(distance) if x == min_value]
            min_indices.sort(reverse=True)
            for i in min_indices:
                answer.append(numlist[i])
                distance[i] = 10001
        else :
            answer.append(numlist[distance.index(min_value)])
            distance[distance.index(min_value)] = 10001
    return answer

# 추가할 것
def solution(numlist, n):
    answer = sorted(numlist, key = lambda x : (abs(x - n), n - x))
    return answer


'''
    sorted(numlist,key = lambda x: [abs(x-n), -x])
    sorted(numlist, key = lambda x : (abs(x - n), n - x))

    두 함수 모두 정렬의 기준을 2개를 가져간다는 것이다.
    첫 번째 정렬기준으로 정렬을 한 뒤, 만약 중복되는 값이 있다면 그 값이 다음 기준을 따르는 것이다

    문제는 비교값 n에 대하여 거리를 오름차순으로 정렬시킨다.
    1, 2, 3, 4, 5, 6 배열은 n에 대하여
    4, 3, 5, 2, 6, 1 배열이 된다. 앞에서 탐색하는 자료구조로 앞 인덱스가 먼저 등장하는 것이다. ( 3 - > 5)
    이제 (3, 5), (2, 6)은 첫 번째 기준으로는 중복 값을 가져서 정렬이 올바르게 되지 못했으니 다음 조건을 추가하는 것이다.
    -x는 큰 값이 더 큰 음수를 갖기 때문에 5가 3보다 작은 값으로 오름차순 정렬에서 앞에 올 수 있게 된다.
    n - x는 n에서 더 크게 값이 차감될수록 더 작은 값을 가져서 배열에서 앞에 올 수 있게 된다.
'''