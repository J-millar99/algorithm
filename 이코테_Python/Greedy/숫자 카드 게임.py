n, m = map(int, input().split())
cards = []

for _ in range(n):
    cards.append(list(map(int, input().split())))

ret = []
for card in cards:
    ret.append(min(card))

print(max(ret))