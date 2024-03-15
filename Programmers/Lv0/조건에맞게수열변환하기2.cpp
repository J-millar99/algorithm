#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> arr) {
    vector<int> temp;
    int idx = 0;
    while (1) {
        for (int &arrNum : arr)
        {
            temp = arr; // 값을 변경하기전 상태 저장
            if (arrNum >= 50 && arrNum % 2 == 0)
                arrNum /= 2;
            else if (arrNum < 50 && arrNum % 2 == 1)
                arrNum = arrNum * 2 + 1;
        }
        if (equal(temp.begin(), temp.end(), arr.begin()))
            break ;
        idx++;
    }
    return idx;
}