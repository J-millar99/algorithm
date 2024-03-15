#include <string>
#include <vector>

using namespace std;

int solution(vector<int> numbers, int k) {
    int cnt = 1;
    int idx = 0;
    while (cnt != k) {
        idx += 2;
        if (idx > numbers.size() - 1)
            idx -= numbers.size();
        cnt++;
    }
    return numbers[idx];
}