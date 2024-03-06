def solution(s1, s2):
    answer = 0
    for str in s1:
        if str in s2:
            answer += 1
    return answer

# 중복을 허용하지 않는 set에 특징을 이용해서 두 개의 집합을 합집합으로 만들어 중복 갯수를 세는 방법
def solution(s1, s2):
    return len(set(s1)&set(s2))