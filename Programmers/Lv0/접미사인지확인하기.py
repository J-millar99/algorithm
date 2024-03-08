def solution(my_string, is_suffix):
    suffix_position = my_string.rfind(is_suffix)

    if suffix_position != -1 and suffix_position == len(my_string) - len(is_suffix):
        return 1
    else:
        return 0
