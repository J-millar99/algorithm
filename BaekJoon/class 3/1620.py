# 나는야 포켓몬 마스터 이다솜
import sys
input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
pokemonDict = {}
indexDict = {}

for i in range(n):
    name = input().rstrip()
    pokemonDict[name] = i + 1
    indexDict[i + 1] = name

problem = [input().rstrip() for _ in range(m)]
ret = []

for pro in problem:
    if pro.isdigit(): # 인덱스
        ret.append(indexDict[int(pro)])
    else: # 이름
        ret.append(str(pokemonDict[pro]))

print("\n".join(ret))
        