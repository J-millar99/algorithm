#!/bin/zsh

# 사용자에게 문자열을 입력 받기
echo "문자열을 입력하세요"
read input_string

# 파일 이름 생성
py_file="${input_string}.py"
cpp_file="${input_string}.cpp"

# 파일 생성
touch $py_file
touch $cpp_file
