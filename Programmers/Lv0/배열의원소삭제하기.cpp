#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> arr, vector<int> delete_list) {
    for (int num : delete_list)
    {
        auto it = find(arr.begin(), arr.end(), num);
        if (it != arr.end()) 
            arr.erase(it);
    }
    return arr;
}