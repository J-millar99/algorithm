s = input()
lstr = []
sum = 0
for c in s:
    if 'A' <= c <= 'Z':
        lstr.append(c)
    else:
        sum += int(c)
lstr.sort()

for i in range(len(lstr)):
    print(lstr[i], end = '')
if sum != 0:
    print(sum)