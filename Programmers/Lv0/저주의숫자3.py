def solution(n):
    answer = 0
    for i in range(n):
        answer += 1 # 진짜 수를 더하여 만드는 곳
        while answer % 3 == 0 or '3' in str(answer): # 3을 쓸 수 없으니 1씩 더 더해주는 곳
            answer += 1
    return answer
