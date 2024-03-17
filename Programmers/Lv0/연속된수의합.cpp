#include <string>
#include <vector>
#include <numeric>
using namespace std;

vector<int> solution(int num, int total) {
    vector<int> vec;
    for (int n = total - num + 1; n < total + 1; n++)
        vec.push_back(n);
    int sum = accumulate(vec.begin(), vec.end(), 0);
    if (sum != total)
        for (int &inum : vec)
            inum -= ((sum - total) / num);
    return vec;
}