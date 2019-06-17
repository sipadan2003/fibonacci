package tv.minato.fibonacci;

import java.util.Map;
import java.util.TreeMap;

public class Fibonacci {
	private static int counter;
	private static final Map<Integer, Long> values = new TreeMap<>();
	private static long[] array;
	
	public static void main(String[] args) {
		final int n = Integer.valueOf(args[0]);
		array = new long[n+1];

//		counter = 0;
//		final long t1 = System.nanoTime();
//		System.out.println("第"+n+"項:"+fib1(n)+": elapsed="+(System.nanoTime()-t1)+": count="+counter);

		counter = 0;
		final long t2 = System.nanoTime();
		System.out.println("第"+n+"項:"+fib2(n)+": elapsed="+(System.nanoTime()-t2)+": count="+counter);

		counter = 0;
		final long t3 = System.nanoTime();
		System.out.println("第"+n+"項:"+fib3(n)+": elapsed="+(System.nanoTime()-t3)+": count="+counter);

		counter = 0;
		final long t4 = System.nanoTime();
		System.out.println("第"+n+"項:"+fib4(n)+": elapsed="+(System.nanoTime()-t4)+": count="+counter);
	}

	static long fib1(int n) {
//		System.out.println("fib1("+n+")");
		counter++;
		if(n<=0) {
			return 0L;
		}else if(n==1 || n==2) {
			return 1L;
		}
		return (fib1(n-1) + fib1(n-2));
	}
	
	static long fib2(int n) {
		if(n<=0) {
	    	return 0;
		}else if(n==1 || n==2) {
			return 1;
		}
		long f = 1;
		long fn1 = 1;
		long fn2;
		for(int i=3; i<=n; i++) {
			counter++;
			fn2 = fn1;
			fn1 = f;
			f = fn1 + fn2;
		}
		return f;
	}

	//Memo化
	static long fib3(int n) {
		counter++;
		if(n<=0) {
	    	return 0;
		}else if(n==1 || n==2) {
			return 1;
		}
		Long f = values.get(n);
		if(f != null) {
			return f;
		}
		f = fib3(n-1) + fib3(n-2);
		values.put(n, f);
	    return f;
	}

	//Memo化
	static long fib4(int n) {
		counter++;
		if(n<=0) {
	    	return 0;
		}else if(n==1 || n==2) {
			return 1;
		}
		long f = array[n];
		if(f > 0) {
			return f;
		}
		f = fib4(n-1) + fib4(n-2);
		array[n] = f;
	    return f;
	}

}
