class BrowserHistory {

    private Stack<String> backHistory;
    private Stack<String> frontHistory;

    public BrowserHistory(String homepage) {
        backHistory = new Stack<>();
        frontHistory = new Stack<>();
        backHistory.push(homepage);
    }
    
    public void visit(String url) {
        backHistory.push(url);
        frontHistory = new Stack<>();
    }
    
    public String back(int steps) {
        while(steps>0 && backHistory.size()>1){
            frontHistory.push(backHistory.pop());
            steps--;
        }
        return backHistory.peek();
    }
    
    public String forward(int steps) {
        while(steps>0 && !frontHistory.isEmpty()){
            backHistory.push(frontHistory.pop());
            steps--;
        }
        return backHistory.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */