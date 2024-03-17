def solution(quizs):
    answer = []
    for quiz in quizs:
        expr = quiz.split() #expr의 크기는 항상 5. 1.피연산자1 2.연산자 3.피연산자2 4.등호 5.결과값
        num1 = int(expr[0])
        num2 = int(expr[2])
        if expr[1] == "+":
            num1 += num2
        else:
            num1 -= num2
        answer.append("O") if num1 == int(expr[4]) else answer.append("X")
    return answer