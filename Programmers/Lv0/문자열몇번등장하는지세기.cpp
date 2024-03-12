#include <string>
#include <vector>
#include <cstring>
using namespace std;

// c스타일
int solution(string myString, string pat) {
    int cnt = 0;
    while (strstr(myString.c_str(), pat.c_str())) {
        cnt++;
        myString = strstr(myString.c_str(), pat.c_str()) + 1;
    }
    return cnt;
}

// c++스타일
int solution(string myString, string pat) {
    int answer = 0;
    int pos = 0;    
    while(true)
    {
        pos = myString.find(pat,pos);
        if(pos == string::npos)
            break;
        answer++;
        pos++;
    }
    return answer;
}