#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> array, int n) {
    array.push_back(n);
    sort(array.begin(), array.end());
    auto it_max = max_element(array.begin(), array.end());
    auto it_min = min_element(array.begin(), array.end());

    if (*it_max == n)
        return array[array.size() - 2];
    else if (*it_min == n)
        return array[1];
    else {
        auto it_mid = find(array.begin(), array.end(), n);
        if (*(it_mid + 1) - *it_mid >= *it_mid - *(it_mid - 1))
            return *(it_mid - 1);
        else
            return *(it_mid + 1);
    }
}