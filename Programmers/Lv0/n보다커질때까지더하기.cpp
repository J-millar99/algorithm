#include <string>
#include <vector>

using namespace std;

int solution(vector<int> numbers, int n) {
    int sum = 0;
    for (int num : numbers)
        if (sum <= n)
            sum += num;
    return sum;
}