class ProductOfNumbers {
public:
    vector<int> prefixProducts;

    ProductOfNumbers() {
        prefixProducts.push_back(1);  
    }
    
    void add(int num) {
        if (num == 0) {
            prefixProducts.clear();
            prefixProducts.push_back(1);  // Reset the prefix product sequence on 0.
        } else {
            prefixProducts.push_back(prefixProducts.back() * num);
        }
    }
    
    int getProduct(int k) {
        int n = prefixProducts.size();
        if (k >= n) return 0;  
        return prefixProducts[n - 1] / prefixProducts[n - k - 1];
    }
};
