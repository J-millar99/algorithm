def solution(price):
    if price >= 500000:
        price *= 0.8
    elif price >= 300000:
        price *= 0.9
    elif price >= 100000:
        price *= 0.95
    return int(price) # 소수점이 버려질 수 있도록 주의