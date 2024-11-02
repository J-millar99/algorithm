# 잃어버린 괄호 (정규표현식 주의)
import re
expression = list(input().split("-"))
result = 0
for ex in expression:
    rex = re.sub(r'\b0+(\d)', r'\1', ex)
    result -= eval(rex)

result += eval(re.sub(r'\b0+(\d)', r'\1', expression[0])) << 1
print(result)