#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> array, int n) {
    int answer = count(begin(array), end(array), n);
    return answer;
}