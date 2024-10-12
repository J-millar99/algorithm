def printm(arr):
    # 각 행의 요소를 출력하기 전에, 가장 긴 문자열의 길이를 찾음
    col_widths = [max(len(str(item)) for item in col) for col in zip(*arr)]
    
    # 배열을 출력
    for row in arr:
        print("  ".join(f"{str(item).ljust(col_widths[i])}" for i, item in enumerate(row)))