#include <string>
#include <algorithm>
#include <unordered_map>

long long solution(std::string numbers) {
    std::unordered_map<std::string, std::string> eng_dict = {
        {"zero", "0"}, {"one", "1"}, {"two", "2"}, {"three", "3"}, {"four", "4"},
        {"five", "5"}, {"six", "6"}, {"seven", "7"}, {"eight", "8"}, {"nine", "9"}
    };

    for (auto& pair : eng_dict) {
        size_t pos = 0;
        while ((pos = numbers.find(pair.first, pos)) != std::string::npos) {
            numbers.replace(pos, pair.first.length(), pair.second);
            pos += pair.second.length();
        }
    }
    return stoi(numbers);
}