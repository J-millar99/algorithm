def solution(chicken):
    coupon = chicken
    answer = 0
    while coupon >= 10:
        answer += coupon // 10
        coupon = coupon // 10 + coupon % 10
    return answer