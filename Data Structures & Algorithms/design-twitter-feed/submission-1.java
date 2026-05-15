class Twitter {
     // tweetId and time
    //Map of userId to heap  of size 10
    //follower() -> userid
    public class Tweet{
        int tweetId;
        int time;
        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public class Feed{
        int time;
        int index;
        int userId;
        int tweetId;
        public Feed(int time, int index, int userId, int tweetId) {
            this.userId = userId;
            this.time = time;
            this.index = index;
            this.tweetId = tweetId;
        }
    }
    

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Tweet>> tweetMap;
    int time;
    public Twitter() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, time++);
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }
        tweetMap.get(userId).add(tweet);
    }
    

    public List<Integer> getNewsFeed(int userId) {
        if (!followMap.containsKey(userId)) {
            followMap.put(userId, new HashSet<>());
        }
        followMap.get(userId).add(userId);
        
        Set<Integer> followees = followMap.get(userId);
        PriorityQueue<Feed> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        
        for (Integer followee : followees) {
            if (!tweetMap.containsKey(followee)) {
                continue;
            }
            List<Tweet> tweets = tweetMap.get(followee);
            int index = tweets.size() - 1;
            Tweet tweet =  tweets.get(index);
            pq.offer(new Feed(tweet.time, index, followee, tweet.tweetId));

        }

        List<Integer> res = new ArrayList<>();    
        while (!pq.isEmpty() && res.size() < 10) {
            Feed feed = pq.poll();
            res.add(feed.tweetId);
            int index = feed.index;
            if (index - 1 >= 0) {
                List<Tweet> tweets = tweetMap.get(feed.userId);
                Tweet prevTweet = tweets.get(index - 1);
                pq.offer(new Feed(prevTweet.time, index - 1, feed.userId, prevTweet.tweetId));
            }

        }
        return res;

        
    }
    
    public void follow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
        
    }
}
