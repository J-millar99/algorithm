#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<string> picture, int k)
{
    vector<string> answer;
    for (string str : picture) {
        string retStr;
        for (char ch : str)
            retStr += std::string(k, ch);
        for (int i = 0; i < k; i++)
            answer.push_back(retStr);
    }
    return answer;
}