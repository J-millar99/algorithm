n = int(input())

count = 0
vals = set()
if n % 3 == 0:
    vals.add(n//3)
if n % 2 == 0:
    vals.add(n//2)
vals.add(n-1)
count = 1

while True:
    ret = set()
    if 1 in vals:
        break
    for v in vals:
        if v % 3 == 0:
            ret.add(v//3)
        if v % 2 == 0:
            ret.add(v//2)
        ret.add(v-1)
    count += 1
    vals = ret

if n == 1:
    print(0)
else:
    print(count)