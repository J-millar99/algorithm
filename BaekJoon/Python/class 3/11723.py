# 집합
'''
    비트마스킹
    OR (|) 연산자
    _set = 0b0000  # 초기 값: 0000
    _set |= (1 << 2)  # 2번째 비트를 1로 설정 (결과: 0100)
    
    AND (&) 연산자
    _set = 0b0100  # 현재 값: 0100
    print(_set & (1 << 2))  # 2번째 비트가 1인지 확인 (결과: 0100, 즉 True)
    
    NOT (~) 연산자
    _set = 0b0100  # 현재 값: 0100
    _set &= ~(1 << 2)  # 2번째 비트를 0으로 설정 (결과: 0000)
    
    XOR (^) 연산자
    _set = 0b0100  # 현재 값: 0100
    _set ^= (1 << 2)  # 2번째 비트를 토글 (결과: 0000)
    _set ^= (1 << 2)  # 다시 토글 (결과: 0100)
'''
import sys
_set = 0
for _ in range(int(input())):
    cmd, *num = sys.stdin.readline().split()
    if cmd == "all":
        _set = (1 << 20) - 1
    elif cmd == "empty":
        _set = 0
    else:
        num = int(num[0]) - 1
        if cmd == "add":
            _set |= (1 << num)
        elif cmd == "remove":
            _set &= ~(1 << num)
        elif cmd == "check":
            print(int(bool(_set & (1 << num))))
        elif cmd == "toggle":
            _set ^= (1 << num)
