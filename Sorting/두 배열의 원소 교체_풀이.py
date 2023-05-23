N, K = map(int, input().split())
a_list = list(map(int, input().split()))
b_list = list(map(int, input().split()))

for i in range(K):
    a_min = min(a_list)
    b_max = max(b_list)
    if a_min < b_max:
        a_list.remove(a_min)
        b_list.remove(b_max)
        a_list.append(b_max)
    else:
        break

print(sum(a_list))