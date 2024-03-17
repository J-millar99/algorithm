#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(string A, string B) {
    int cnt = 0;
    while (cnt <= B.length()) {
        if (A == B)
            return cnt;
        A = A.back() + A.substr(0, A.length() - 1);
        ++cnt;
    }
    return -1;
}