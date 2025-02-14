# 카드2
import queue
n = int(input())
q = queue.Queue()

for i in range(1, n + 1):
    q.put(i)

while True:
    ret = q.get()
    if q.empty():
        break
    ret = q.get()
    if q.empty():
        break
    q.put(ret)

print(ret)