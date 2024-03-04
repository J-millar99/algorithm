s = input()
cnt = 0
start = s[0] #시작문자는 항상옳다
temp = start  #이전 문자가 뭐였는지 저장

for i in s:
    if start != i and temp != i: #start랑 현재 문자가 다르면 무조건 체크 and 이전 문자와 다르다면 바꿔주어야 하는 구간임
        cnt += 1
    temp = i #현재 문자를 저장하고 다음 문자를 확인
print(cnt) 