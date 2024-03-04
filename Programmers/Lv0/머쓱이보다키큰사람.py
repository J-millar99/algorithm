def solution(array, height):
    cnt = 0
    for heig in array:
        if height < heig:
           cnt += 1 
    return cnt

# 삽입과 정렬을 통한 방법
def solution(array, height):
    array.append(height)
    array.sort(reverse=True)
    return array.index(height)