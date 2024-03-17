#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> arr, int k) {
    vector<int> temp;
    for (int i : arr)
        if (find(temp.begin(), temp.end(), i) == temp.end())
            temp.push_back(i);
    if (temp.size() >= k)
        return vector<int>(temp.begin(), temp.begin() + k);
    while (temp.size() != k)
        temp.push_back(-1);
    return temp;
}