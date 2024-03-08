def solution(num_list):
    last = num_list[len(num_list) - 1]
    lastev = num_list[len(num_list) - 2]
    if last > lastev:
        num_list.append(last - lastev)
    else:
        num_list.append(last * 2)
    return num_list