#include <string>
#include <vector>

using namespace std;

string solution(vector<string> id_pw, vector<vector<string>> db)
{
    for (vector<string> pair : db)
        if (id_pw[0] == pair[0] && id_pw[1] == pair[1])
            return "login";
    for (vector<string> pair : db)
        if (id_pw[0] == pair[0] && id_pw[1] != pair[1])
            return "wrong pw";
    return "fail";
}