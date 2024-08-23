class Solution {
public:
    string fractionAddition(string expr) {
        int nume = 0;
        int deno = 1;

        int i = 0;
        int n = expr.length();
        while(i < n) {
            int currNume = 0;
            int currDeno = 0;

            bool isNeg = (expr[i] == '-');
            
            if(expr[i] == '+' || expr[i] == '-') {
                i++;
            }

            //Build the current numerator
            while(i < n && isdigit(expr[i])) {
                int val = expr[i] - '0';
                currNume = (currNume*10) + val;
                i++;
            }

            i++; //numerator / denominator //skipiing the division character '/'

            if(isNeg == true) {
                currNume *= -1;
            }

            //Build the current denominator
            while(i < n && isdigit(expr[i])) {
                int val = expr[i] - '0';
                currDeno = (currDeno * 10) + val;
                i++;
            }

            nume = nume * currDeno + currNume * deno;
            deno = deno * currDeno;
        }

        int GCD = abs(__gcd(nume, deno)); //3

        nume /= GCD; 
        deno /= GCD; 

        return to_string(nume) + "/" + to_string(deno); 
    }
};