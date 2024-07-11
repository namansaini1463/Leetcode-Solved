class Solution {
public:
    string reverseParentheses(string s) {
        stack<char> st;

        for(const auto &ch : s){
            if(ch == ')'){
                string temp = "";
                while(st.top() != '('){
                    temp += st.top();
                    st.pop();
                }

                cout << temp << endl;
                st.pop();

                for(const auto &t : temp){
                    st.push(t);
                }

            } else {
                st.push(ch);
            }
        }

        string result = "";
        while(!st.empty()){
            result += (st.top());
            st.pop();
        }

        reverse(result.begin(), result.end());

        return result;
    }
};