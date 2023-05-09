food_times = list(map(int, input().split()))
k = int(input())

def solution(food_times, k):
    while True:
        for i in range(len(food_times)): #음식 인덱스를 확인
            if food_times[i] > 0:
                food_times[i] = food_times[i] - 1 #음식이 남아있으면 섭취
                k -= 1 #시간초 흐름
            if k == 0: #0초에 도달하면 멈춤
                break;
        if k == 0: #0초에 도달하면 멈춤
            break;
    return (food_times)


print(solution(food_times, k))