def solution(my_string, letter):
    answer = ""
    for i in my_string:
        if i != letter:
            answer += i
    return answer

# 함수를 이용하는 방법
def solution(my_string, letter):
    return my_string.replace(letter, '')