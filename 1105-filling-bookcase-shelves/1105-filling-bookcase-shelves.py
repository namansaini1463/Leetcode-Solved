class Solution(object):
    def minHeightShelvesHelper(self, idx, remainingWidth, currentShelfHeight, shelfWidth, books, memo):
        if(idx == len(books)):
            return currentShelfHeight

        if (idx, remainingWidth, currentShelfHeight) in memo:
            return memo[(idx, remainingWidth, currentShelfHeight)]

        bookWidth = books[idx][0]
        bookHeight = books[idx][1]

        placeInCurrentShelf = 1e9
        if(bookWidth <= remainingWidth) :
            placeInCurrentShelf = self.minHeightShelvesHelper(idx + 1, remainingWidth - bookWidth, max(currentShelfHeight, bookHeight), shelfWidth, books, memo)
        

        placeInNextShelf = currentShelfHeight + self.minHeightShelvesHelper(idx + 1, shelfWidth - bookWidth, bookHeight, shelfWidth, books, memo)

        memo[(idx, remainingWidth, currentShelfHeight)] = min(placeInCurrentShelf, placeInNextShelf)
        return memo[(idx, remainingWidth, currentShelfHeight)]
        

    def minHeightShelves(self, books, shelfWidth):
        """
        :type books: List[List[int]]
        :type shelfWidth: int
        :rtype: int
        """
        n = len(books)
        memo = {}
        return self.minHeightShelvesHelper(0, shelfWidth, 0, shelfWidth, books, memo)

        