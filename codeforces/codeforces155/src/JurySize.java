import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class JurySize {
	static class Olympiads {

		int day, month, numJury, daysNeeded;
		Calendar startDate, freeDate;

		public Olympiads(String string) {
			String[] strs = string.split(" ");
			day = Integer.parseInt(strs[0]);
			month = Integer.parseInt(strs[1]);
			numJury = Integer.parseInt(strs[2]);
			daysNeeded = Integer.parseInt(strs[3]);
			startDate = freeDate = new GregorianCalendar(2013, month, day);
			startDate.roll(Calendar.DAY_OF_MONTH, -daysNeeded);
		}
	}

	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			int num = Integer.parseInt(in.readLine());
			PriorityQueue<Olympiads> pq = new PriorityQueue<JurySize.Olympiads>(
					1, new Comparator<Olympiads>() {

						@Override
						public int compare(Olympiads o1, Olympiads o2) {
							return o1.startDate.compareTo(o2.startDate);
						}
					});
			List<Olympiads> list = new ArrayList<Olympiads>();

			for (int i = 0; i < num; i++) {
				pq.offer(new Olympiads(in.readLine()));
			}

			int currentJuryNeeded = 0;
			int currentFreeJury = 0;
			PriorityQueue<Olympiads> nextFrees = new PriorityQueue<JurySize.Olympiads>(
					1, new Comparator<Olympiads>() {

						@Override
						public int compare(Olympiads o1, Olympiads o2) {
							return o1.freeDate.compareTo(o2.freeDate);
						}
					});
			Olympiads nextFree = nextFrees.poll();
			for (Iterator<Olympiads> it = pq.iterator(); it.hasNext();) {
				Olympiads olympiad = it.next();
				// start before the next olympiads are free
				while (nextFree != null
						&& !olympiad.startDate.before(nextFree.freeDate)) {
					currentFreeJury += nextFree.numJury;
					nextFree = nextFrees.poll();
				}
				if (olympiad.numJury > currentFreeJury) {
					currentJuryNeeded += olympiad.numJury - currentFreeJury;
					currentFreeJury = 0;
				} else {
					currentFreeJury -= olympiad.numJury;
				}
			}
			System.out.println(currentJuryNeeded);

		} catch (IOException e1) {
		}

	}
}
