# IOIOI
n = int(input())
l = int(input())
s = input()

i = 0
cnt, ret = 0, 0
while i < l:
    if s[i:i+3] == "IOI":
        cnt += 1
        if cnt == n:
            ret += 1
            cnt -= 1
        i += 2
    else:
        cnt = 0
        i += 1

print(ret)