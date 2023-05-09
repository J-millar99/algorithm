S = input()
Slen = len(S)
result = int(S[0])

if Slen == 1:
    print(result)
else:
    for i in range(Slen - 1):
        n = int(S[i + 1])
        if result + n > result * n:
            result += n
        else:
            result *= n
print(result)