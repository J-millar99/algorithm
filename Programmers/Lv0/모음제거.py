def solution(my_string):
    return my_string.replace("a", "").replace("e", "").replace("i", "").replace("o", "").replace("u", "")

# join사용하기
def solution(my_string):
    return "".join([i for i in my_string if not(i in "aeiou")])