def solution(id_pw, db):
    for pair in db:
        if (id_pw[0] == pair[0] and id_pw[1] == pair[1]):
            return "login"
    for pair in db:
        if (id_pw[0] == pair[0] and id_pw[1] != pair[1]):
            return "wrong pw"
    return "fail"