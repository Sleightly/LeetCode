/*
Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.

You are given several projects. For each project i, it has a pure profit Pi and a minimum capital of Ci is needed to start the corresponding project. Initially, you have W capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.

To sum up, pick a list of at most k distinct projects from given projects to maximize your final capital, and output your final maximized capital.
*/

class IPO {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        //greedy solution 
        PriorityQueue<int[]> pqCapital = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> pqProfits = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        
        int total = W;
        int counter = 0;
        
        //sort captial
        for (int i = 0; i < Capital.length; i++) {
            pqCapital.add(new int[]{Capital[i], Profits[i]});
        }
        
        //sort profit by W
        for (int i = 0; i < Profits.length; i++) {
            while (pqCapital.size() > 0 && pqCapital.peek()[0] <= W) {
                pqProfits.add(pqCapital.poll());
            } 
            
            if (pqProfits.size() == 0) {
                return total;
            }
            
            total += pqProfits.poll()[1];
            W = total;
            counter++;
            
            if (counter == k) {
                return total;
            }
        }
        return total;
    }
}
