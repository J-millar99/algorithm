#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> array, int height) {
    array.push_back(height);
    sort(array.begin(), array.end());
    reverse(array.begin(), array.end());
    auto it = find(array.begin(), array.end(), height);
    return distance(array.begin(), it);
}