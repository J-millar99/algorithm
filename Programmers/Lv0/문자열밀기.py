def solution(A, B):
    cnt = 0
    while cnt <= len(B):
        if A == B:
            return cnt
        A = A[len(A) - 1] + A[:len(A) - 1]
        cnt += 1
    return -1
