# Audrey Kim 
# Censio Intern Programming Assessment

# Write a query that...

# returns all posts posted in the past 24 hours
SELECT post_id FROM LoveCouch.Posts
WHERE time_posted >= DATE_SUB(NOW() - INTERVAL 1 DAY);


# returns all posts grouped by topic
SELECT post_id FROM LoveCouch.Posts
GROUP BY topic


# returns all anonymous posts posted in the last week, sorted by most recent to least recent
SELECT post_id FROM LoveCouch.Posts
WHERE is_anonymous IS TRUE
AND time_posted >= DATE_SUB(NOW() - INTERVAL 1 WEEK);
ORDER BY time_posted DESC;


# return all posts that have the word “Love” in the title
SELECT post_id FROM LoveCouch.Posts
WHERE title LIKE '*[Ll]ove*'

