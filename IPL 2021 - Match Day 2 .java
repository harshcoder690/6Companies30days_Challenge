class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
       ArrayList<Integer> ans = new ArrayList<>();
       Deque<Integer> q=new LinkedList<>();
		
		int i;
		for (i=0;i<k;i++) {
			
			while(!q.isEmpty() && arr[i]>arr[q.getLast()]) {
				q.removeLast();
			}
			q.addLast(i);
		}
		
		for ( ;i<arr.length;i++) {
			System.out.print(arr[q.getFirst()]+" ");
			
			
			while(!q.isEmpty() && q.getFirst()<=i-k) {
				q.removeFirst();
			}
			while(!q.isEmpty() && arr[i]>arr[q.getLast()]) {
				q.removeLast();
			}
			q.addLast(i);
		}
		ans.add(arr[q.getFirst()]);
		return ans;
		
    }
}