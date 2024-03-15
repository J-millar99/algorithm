#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    for (vector<int> querie : queries)
        for (int i = querie[0]; i <= querie[1]; i++)
            if (i % querie[2] == 0)
                arr[i] += 1;
    return arr;
}