#include <string>
#include <vector>
#include <sstream>
using namespace std;


// c++스타일로 split 함수 역할을 내는 방법 반드시 유용하니 기억할 것
vector<string> solution(string my_string) {
    std::istringstream iss(my_string);
    std::vector<std::string> word_vector(std::istream_iterator<std::string>{iss},
                                         std::istream_iterator<std::string>());
    return word_vector;
}