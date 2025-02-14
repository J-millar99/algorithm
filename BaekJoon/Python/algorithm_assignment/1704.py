# Z
def z_order(size, r, c):
    Z = 0
    n = 2 ** size

    def _recurse(n, x, y):
        nonlocal Z
        if n == 1:
            return Z

        n //= 2
        if r < x + n and c < y + n:
            return _recurse(n, x, y)  # Top-left
        elif r < x + n and c >= y + n:
            Z += n * n
            return _recurse(n, x, y + n)  # Top-right
        elif r >= x + n and c < y + n:
            Z += 2 * n * n
            return _recurse(n, x + n, y)  # Bottom-left
        else:
            Z += 3 * n * n
            return _recurse(n, x + n, y + n)  # Bottom-right

    return _recurse(n, 0, 0)

size, r, c = map(int, input().split())
print(z_order(size, r, c))
