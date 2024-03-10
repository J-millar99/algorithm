#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(int n) {
    vector<vector<int>> vecs;
    for (int i = 0; i < n; i++) {
        vector<int> vec;
        for (int j = 0; j < n; j++) {
            if (i == j)
                vec.push_back(1);
            else
                vec.push_back(0);
        }
        vecs.push_back(vec);
    }
    return vecs;
}

// 생성자로 먼저 생성해 놓고 main diagnoal을 1로 초기화
vector<vector<int>> solution(int n) {
    vector<vector<int>> answer(n, vector<int>(n, 0));

    for(int i = 0; i < n; ++i)
        answer[i][i] = 1;
    return answer;
}