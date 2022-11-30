package chainResponsibility;

import gameObjects.Configuration;

public abstract class Middleware {

	private Middleware next;
	
	public static Middleware link(Middleware first, Middleware...chain) {
		Middleware head=first;
		for(Middleware nextInChain:chain) {
			head.next=nextInChain;
			head=nextInChain;
		}
		return first;
	}
	public abstract boolean check(Configuration conf);
	
	public boolean checkNext(Configuration conf) {
		if(next==null) {
			return true;
		}
		return next.check(conf);
	}
}
