class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new LinkedList<>();

        int len = students.length;
        for (int i=0; i<len; i++){
            s.push(sandwiches[(len-1)-i]);
            q.offer(students[i]);
        }
        while (true){
            if(q.isEmpty()) break;
            if(!q.contains(s.peek())) break;
            if (q.peek() == s.peek()){
                q.poll();
                s.pop();
            } else {
                q.offer(q.poll());
            }
        }

        return q.size();
    }
}