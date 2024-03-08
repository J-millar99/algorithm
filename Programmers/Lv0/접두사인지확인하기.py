def solution(my_string, is_prefix):
    suffix_position = my_string.find(is_prefix)
    if suffix_position == 0:
        return 1
    else:
        return 0