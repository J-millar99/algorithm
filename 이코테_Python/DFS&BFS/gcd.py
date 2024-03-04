a, b = map(int, input().split())

def get_gcd(a, b):
    if a % b == 0:
        return(b)
    else:
        return(get_gcd(b, a%b))
        
print(get_gcd(a, b))