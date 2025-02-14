# 체스판 다시 칠하기
def printD(array):
    for row in array:
        print(" ".join(map(str, row)))

def _slice(arr, x, y):
    return [row[y: y + 8] for row in arr[x: x + 8]]

def mapW():
    wmap1 = []
    for a in range(8):
        wmap2 = []
        for b in range(8):
            if (a + b) % 2 == 0:
                wmap2.append("B")
            else:
                wmap2.append("W")
        wmap1.append(wmap2)
    return wmap1

def mapB():
    bmap1 = []
    for a in range(8):
        bmap2 = []
        for b in range(8):
            if (a + b) % 2 == 0:
                bmap2.append("W")
            else:
                bmap2.append("B")
        bmap1.append(bmap2)
    return bmap1

def diffMap(m1, m2):
    diff_count = 0
    for i in range(len(m1)):
        for j in range(len(m1[i])):
            if m1[i][j] != m2[i][j]:
                diff_count += 1
    return diff_count

a, b = map(int, input().split())

data1 = []
for i in range(a):
    data2 = list(input())
    data1.append(data2)

ret = []
for i in range(a - 7):
    for j in range(b - 7):
        temp = _slice(data1, i, j)
        ret.append(diffMap(temp, mapW()))
        ret.append(diffMap(temp, mapB()))

print(min(ret))