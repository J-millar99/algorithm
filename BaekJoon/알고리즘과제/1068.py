def dfs(matrix, v, visited):
    global count
    visited[v] = True
    if checkLeaf(matrix[v], len(matrix[v])):
        count += 1
        return

    for i in range(len(matrix[v])):
        if matrix[v][i] == 1 and not visited[i]:
            dfs(matrix, i, visited)

def checkLeaf(array, size):
    for i in range(size):
        if array[i] == 1:
            return False
    return True

# get input
n = int(input())
node = list(map(int, input().split()))
del_index = int(input())
root = 0
visited = [False] * n
count = 0

# init map
matrix = [[0 for _ in range(n)] for _ in range(n)]

# set map
for idx in range(len(node)):
    if node[idx] == -1:
        root = idx
        continue
    if node[idx] == del_index or idx == del_index: 
        continue
    matrix[node[idx]][idx] = 1

dfs(matrix, root, visited)
if del_index == root:
    print(0)
else:
    print(count)