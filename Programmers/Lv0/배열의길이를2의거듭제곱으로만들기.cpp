#include <string>
#include <vector>
#include <cmath>
using namespace std;

// 1은 2의 0거듭제곱이다
vector<int> solution(vector<int> arr) {
    int i = 1;
    if (arr.size() == 1)
        return arr;
    while (arr.size() > pow(2, i))
        i++;
    while (arr.size() < pow(2, i))
        arr.push_back(0);
    return arr;
}