package com.jonathanedgecombe.cluedo;

import java.util.ArrayList;
import java.util.List;

public final class ListUtil {
	public static <T> boolean equal(List<T> a, List<T> b) {
		for (T o : a) if (!b.contains(o)) return false;
		for (T o : b) if (!a.contains(o)) return false;
		return true;
	}

	public static <T> List<T> union(List<T> a, List<T> b) {
		List<T> union = new ArrayList<>();

		for (T o : a) {
			if (b.contains(o)) union.add(o);
		}

		return union;
	}
}
