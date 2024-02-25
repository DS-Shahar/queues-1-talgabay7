class Main {
  public static <T> boolean q1_isIn(Queue<T> q,T x) {
		boolean flag=false;
		Queue<T> q2=new Queue<>();
		while(!q.isEmpty()) {
			if(x.equals(q.head()))
				flag=true;
			q2.insert(q.remove());
		}
		while(!q2.isEmpty())
			q.insert(q2.remove());
		return flag;
	}
	public static <T> boolean q2_isIn(Queue<T> q,T x) {
		boolean flag=false;
		q.insert(null);
		while(q.head()!=null) {
			if(x.equals(q.head()))
				flag=true;
			q.insert(q.remove());
		}
		q.remove();
		return flag;
	}
	public static <T> boolean q3_isIn(Queue<T> q,T x) {
		if(q.isEmpty())
			return false;
		T a =q.remove();
		boolean found=q3_isIn(q,x);
		q.insert(a);
		return found||a==x;
	}
	public static Queue<Integer> q6_streakQueue(Queue<Character> q){
		Queue<Character> q2 = new Queue<Character>();
		Queue<Integer> streaks = new Queue<Integer>();
		int count=1;
		char x=q.remove();
		q2.insert(x);
		while(!q.isEmpty()) {
			if(q.head().equals(x))
				count++;
			else {
				streaks.insert(count);
				count=1;
			}
			x=q.remove();
			q2.insert(x);
		}
		streaks.insert(count);
		while(!q2.isEmpty())
			q.insert(q2.remove());
		return streaks;
	}
	public static boolean q7_repeats(Queue<String> q) { //O(n*n)
		Queue<String> q2=new Queue<String>();
		boolean flag=false;
		String s=q.remove();
		q2.insert(s);
		while(!q.isEmpty()) {
			if(q1_isIn(q,s))
				flag=true;
			s=q.remove();
			q2.insert(s);
		}
		while(!q2.isEmpty())
			q.insert(q2.remove());
		return flag;
	}
	public static void q8_eraseSec(Queue<Integer> q) {//O(n*n)
		Queue<Integer> q2=new Queue<Integer>();
		int x=q.remove();
		while(!q.isEmpty()) {
			if(!q1_isIn(q2,x))
				q2.insert(x);
			x=q.remove();
		}
		q2.insert(x);
		while(!q2.isEmpty())
			q.insert(q2.remove());
	}
	public static int length(Queue<Integer> q) {
		Queue<Integer> q2=new Queue<>();
		int count=0;
		while(!q.isEmpty()) {
			count++;
			q2.insert(q.remove());
		}
		while(!q2.isEmpty())
			q.insert(q2.remove());
		return count;
	}
	public static int numAmount(Queue<Integer> q,Integer x) {
		int count=0;
		Queue<Integer> q2=new Queue<>();
		while(!q.isEmpty()) {
			if(q.head()==x)
				count++;
			q2.insert(q.remove());
		}
		while(!q2.isEmpty())
			q.insert(q2.remove());
		return count;
	}
	public static void q9_sort(Queue<Integer> q) {
		Queue<Integer> sorted=new Queue<>();
		Queue<Integer> q2=new Queue<>();
		int len=length(q);
		int min;
		while(len!=length(sorted)) {
			min=2147483647;
			while(!q.isEmpty()) {
				if(min>q.head()&&!q1_isIn(sorted,q.head())) {
					min=q.head();
				}
				if(!q.isEmpty())
					q2.insert(q.remove());
			}
			while(!q2.isEmpty())
				q.insert(q2.remove());
			for(int i=0;i<numAmount(q,min);i++)
				sorted.insert(min);
		}
		while(!q.isEmpty())
			q.remove();
		while(!sorted.isEmpty())
			q.insert(sorted.remove());
	}
	public static boolean q1_numStreak(Queue<Integer> q,int x) {
		Queue<Integer> q2=new Queue<>();
		boolean flag=false;
		int y=q.head();
		q2.insert(q.remove());
		while(!q.isEmpty()) {
			if(y==x&&q.head()==x)
				flag=true;
			y=q.head();
			q2.insert(q.remove());
		}
		while(!q2.isEmpty())
			q.insert(q2.remove());
		return flag;
	}
  public static void main(String[] args) {
    System.out.println("Hello World!");
  }
}
