class Solution {
    class Task {
        char task;
        int time;
        public Task(char task, int time) {
            this.task = task;
            this.time = time;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char t : tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        PriorityQueue<Character> readyTasks = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (Character task : map.keySet()) {
            readyTasks.offer(task);
        }
        Queue<Task> waitingTasks = new LinkedList<>();
        int time = 0;
        while (!waitingTasks.isEmpty() || !readyTasks.isEmpty()) {
            time++;
            if (!readyTasks.isEmpty()) {
                char task = readyTasks.poll();
                int freq = map.get(task);
                map.put(task, freq - 1);
                if (freq - 1 > 0) {
                    waitingTasks.offer(new Task(task, time + n));
                }
            }

            if (!waitingTasks.isEmpty() && waitingTasks.peek().time == time) {
                Task task = waitingTasks.poll();
                readyTasks.offer(task.task);
            }

        }

        return time;

        
    }
}
