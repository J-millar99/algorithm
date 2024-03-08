def solution(n, control):
    for cmd in control:
        if cmd == 'w':
            n = n + 1
        elif cmd == 's':
            n = n - 1
        elif cmd == 'a':
            n = n - 10
        elif cmd == 'd':
            n = n + 10
    return n