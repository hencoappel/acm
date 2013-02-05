package one;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MultiThreadedHarness {
	private final TestCase func;
	private final BufferedReader in;
	private final BufferedWriter out;
	private final int linesPerCase;

	ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime()
			.availableProcessors());

	public MultiThreadedHarness(final TestCase func, final int linesPerCase,
			final BufferedReader in, final BufferedWriter out) {
		this.func = func;
		this.in = in;
		this.out = out;
		this.linesPerCase = linesPerCase;
	}

	public void execute() throws IOException {
		int numTests = Integer.parseInt(in.readLine());
		@SuppressWarnings("unchecked")
		Future<String>[] futures = new Future[numTests];
		for (int i = 1; i <= numTests; i++) {
			final String[] args = new String[linesPerCase];
			for (int j = 0; j < linesPerCase; j++) {
				args[j] = in.readLine();
			}
			final int j = i;
			futures[i - 1] = pool.submit(new Callable<String>() {
				@Override
				public String call() {
					return func.solveTestCase(j, args);
				}
			});
		}
		try {
			pool.shutdown();
			pool.awaitTermination(1L, TimeUnit.DAYS);
			for (Future<String> future : futures) {
				try {
					out.write(future.get() + "\n");
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
			out.flush();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
