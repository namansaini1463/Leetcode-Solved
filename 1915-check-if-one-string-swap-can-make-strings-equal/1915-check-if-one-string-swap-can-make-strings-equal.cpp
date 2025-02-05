class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        if (s1 == s2) return true;

        vector<int> diff;

        for (int i = 0; i < s1.size(); i++) {
            if (s1[i] != s2[i]) {
                diff.push_back(i);
            }
        }


        if (diff.size() != 2) return false;

        // Hum ye check krr rhe hain ki jin jin indexs pr match ni hora hai kya unnke characters same hain ki nahi
        // Agar difference 2 hai aur wo dono characters same hain, to swap krne ke baad strings same ban jaayengi, warna nahi
        return (s1[diff[0]] == s2[diff[1]] and s1[diff[1]] == s2[diff[0]]);
    }
};
