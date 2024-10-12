def z_order(n, row, col):
    z = 0
    size = 2 ** n
    def cord(n, x, y):
        nonlocal z
        if n == 1:
            return z

        n //= 2 # row : 3 col : 1 n = 2
        if row < n + x and col < n + y:     # Left-Top
            return cord(n, x, y)
            
        elif row < n + x and col >= n + y:   # Right-Top
            z += n * n
            return cord(n, x, y + n)
            
        elif row >= n + x and col < n + y:   # Left-Bottom
            z += 2 * n * n
            return cord(n, x + n, y)
            
        elif row >= n + x and col >= n + y:   # Right-Bottom
            z += 3 * n * n
            return cord(n, x + n, y + n)
            
    cord(size, 0, 0)
    return z

n, r, c = map(int, input().split())
print(z_order(n, r, c))