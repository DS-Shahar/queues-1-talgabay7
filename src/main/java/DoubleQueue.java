public class DoubleQueue {
	private Queue<Integer> fast;
	private Queue<Integer> slow;
	int num=1;
	
	public DoubleQueue(Queue<Integer> fast, Queue<Integer> slow) {
		super();
		this.fast = fast;
		this.slow = slow;
	}
	public Queue<Integer> getFast() {
		return fast;
	}
	public void setFast(Queue<Integer> fast) {
		this.fast = fast;
	}
	public Queue<Integer> getSlow() {
		return slow;
	}
	public void setSlow(Queue<Integer> slow) {
		this.slow = slow;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "DoubleQueue [fast=" + fast + ", slow=" + slow + ", num=" + num + "]";
	}
	public Queue<Integer> ichzur(int act){
		if(act==1)
			return slow;
		return fast;
	}
	public void add(int num,int act) {
		if(act==1)
			slow.insert(num);
		else
			fast.insert(num);
	}
	public int next() {
		int user=0;
		if(fast.isEmpty())
			user=slow.remove();
		else if(num==0) {
			user=slow.remove();
			num=1;
		}
		else {
			user=fast.remove();
			num++;
		}
		if(num==6)
			num=0;
		return user;
	}
}
