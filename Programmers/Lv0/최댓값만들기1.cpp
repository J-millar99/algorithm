#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> numbers) {
    sort(numbers.begin(), numbers.end());
    int num = numbers.back();
    numbers.pop_back();
    num *= numbers.back();
    return num;
}