str = input()
answer = ""
for ch in str:
    if 'a' <= ch <= 'z':
        ch = ch.upper()
    else:
        ch = ch.lower()
    answer += ch
print(answer)