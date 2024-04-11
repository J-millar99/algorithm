def solution(a, b, c, d):
    diceMap = [0, 0, 0, 0, 0, 0, 0]
    dupMap = [0, 0, 0, 0, 0]
    diceMap[a] += 1; diceMap[b] += 1; diceMap[c] += 1; diceMap[d] += 1

    for i in range(1, 7):
        if diceMap[i] != 0:
            dupMap[diceMap[i]] += 1
    print(diceMap)
    print(dupMap)
    if dupMap[4] == 1:
        return 1111 * a
    elif dupMap[3] == 1:
        n1 = diceMap.index(3)
        n2 = diceMap.index(1)
        return (10 * n1 + n2) * (10 * n1 + n2)
    elif (dupMap[2] == 2):
        n1 = diceMap.index(2)
        n2 = len(diceMap) - diceMap[::-1].index(2) + 1
        return (n1 + n2) * (abs(n1 - n2))
    elif (dupMap[2] == 1):
        n1 = diceMap.index(1)
        n2 = len(diceMap) - diceMap[::-1].index(1) + 1
    elif (dupMap[1] == 4):
        return min(a, b, c, d)
