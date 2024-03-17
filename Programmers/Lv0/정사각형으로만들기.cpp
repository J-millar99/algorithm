#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arrs) {
    int rowCnt = arrs.size(), colCnt = arrs[0].size();
    if (rowCnt > colCnt) {
        int diff = rowCnt - colCnt;
        for (vector<int> &arr : arrs)
            for (int i = 0; i < diff; i++)
                arr.push_back(0);
    }
    else if (rowCnt < colCnt) {
        int diff = colCnt - rowCnt;
        for (int j = 0; j < diff; j++)
            arrs.push_back(vector<int>(colCnt));
    }
    return arrs;
}