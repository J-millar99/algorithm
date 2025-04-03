#!/bin/bash

# n을 1에서 10 사이의 랜덤한 자연수로 설정
n=$((RANDOM % 20 + 1))
echo "$n" | tee 안녕

# n개의 난수를 생성하여 첫 번째 줄에 출력
for ((i=0; i<n; i++)); do
    printf "%d " $((RANDOM % 101)) | tee -a 안녕
done
echo "" | tee -a 안녕

# n개의 난수를 생성하여 두 번째 줄에 출력
for ((i=0; i<n; i++)); do
    printf "%d " $((RANDOM % 101)) | tee -a 안녕
done
echo "" | tee -a 안녕
