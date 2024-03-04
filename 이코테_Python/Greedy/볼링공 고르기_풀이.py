from itertools import combinations

n, m = map(int, input().split())
k = list(map(int, input().split()))
r = list(combinations(k, 2)) # 순서를 생각하지 않고 볼링공을 2개 뽑는다.
cnt = 0
for i in r:
    if i[0] != i[1]: # 두개의 무게가 다르면 카운트한다.
        cnt += 1

print(cnt)