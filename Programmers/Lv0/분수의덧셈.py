from fractions import Fraction
def solution(numer1, denom1, numer2, denom2):
    denom = denom1 * denom2 #통분
    numer1 *= denom2
    numer2 *= denom1
    numer = numer1 + numer2 #덧셈진행
    ret = Fraction(numer, denom)
    return [ret.numerator, ret.denominator]