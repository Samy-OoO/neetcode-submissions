class Twitter {
private:
    int count;
    unordered_map<int, vector<pair<int, int>>> tweetMap;
    unordered_map<int, vector<int>> followMap;

public:
    Twitter() {
        count = 0;
    }
    
    void postTweet(int userId, int tweetId) {
        tweetMap[userId].push_back({count++, tweetId});
    }
    
    vector<int> getNewsFeed(int userId) {
        priority_queue<
            pair<int, int>, 
            vector<pair<int, int>>,
            greater<pair<int, int>>
        > minH;
        
        vector<int>& followees = followMap[userId];
        if (find(followees.begin(), followees.end(), userId) == followees.end()) {
            followees.push_back(userId);
        }

        for (int followee : followees) {
            vector<pair<int, int>>& tweets = tweetMap[followee];
            for (pair<int, int> tweet : tweets){
                minH.push(tweet);
                if (minH.size() > 10) minH.pop();
            }
        }

        vector<int> newsFeed;
        while (!minH.empty()) {
            newsFeed.push_back(minH.top().second); minH.pop();
        }
        reverse(newsFeed.begin(), newsFeed.end());

        return newsFeed;
    }
    
    void follow(int followerId, int followeeId) {
        vector<int>& followees = followMap[followerId];
        if (find(followees.begin(), followees.end(), followeeId) == followees.end()) {
            followMap[followerId].push_back(followeeId);
        }
    }
    
    void unfollow(int followerId, int followeeId) {
        vector<int>& followees = followMap[followerId];
        if (find(followees.begin(), followees.end(), followeeId) != followees.end()) {
            erase(followees, followeeId);
        }
    }
};
