from itertools import combinations

def fsum(list): #중복조합 리스트를 만드는 함수
    r = []
    for i in range(len(list)):
        n = sum(list[i])
        r.append(n)
    return (r)

n = int(input())
data = sorted(list(map(int, input().split())))
min_value = data[0]
r = []

if min_value > 1: #가장 작은 수가 1보다 크면 1이 만들 수 없는 최솟값
    print(1)
else:
    for i in range(1, n):
        result = list(combinations(data, i)) #합을 만드는 모든 경우를 리스트에 담는다.
        d = fsum(result)
        for i in d:
            r.append(i) #리스트 합치기
r = set(r) #중복제거
for i in range(1, 1000001): #범위 만큼 순회하며 없는 값 찾기
    if i not in r:
        print(i)
        break;