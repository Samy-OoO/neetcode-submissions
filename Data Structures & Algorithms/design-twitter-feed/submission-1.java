class Twitter {
    private Map<Integer, Queue<int[]>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;
    private int count = 0;

    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    private void createUser(int userId) {
        tweetMap.put(userId, new LinkedList<>());
        followMap.put(userId, new HashSet<>());
        followMap.get(userId).add(userId);
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)) createUser(userId);
        tweetMap.get(userId).offer(new int[]{++count, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> recentTweets = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        List<Integer> recentsList = new LinkedList<>();

        if (!followMap.containsKey(userId)) return recentsList;

        for (int followee : followMap.get(userId)) {
            for (int[] tweet : tweetMap.get(followee)) {
                recentTweets.offer(tweet);
            }
        }
        for (int i=0; i<10; i++) {
            if (recentTweets.isEmpty()) break;
            recentsList.add(recentTweets.poll()[1]);
        }

        return recentsList;        
    }
    
    public void follow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) createUser(followerId);
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
