package Blatt6;

public class Interval implements Comparable<Interval> {
	private int start;
	private int end;

	public Interval(int start, int end) {

		this.start = start;
		this.end = end;

	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public String toSrting() {
		return "[" + start + "," + end + "]";
	}

	public int compareTo(Interval other) {
		if (this.end > other.end) {
			return 1;
		}
		if (this.end == other.end) {
			return 0;
		}
		return -1;
	}

}
