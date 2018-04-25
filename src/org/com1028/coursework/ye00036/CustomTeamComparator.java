package org.com1028.coursework.ye00036;

import java.util.Comparator;

//Custom comparator class used to compare points and goals between teams in order to sort them by points and then by goal difference.
public class CustomTeamComparator implements Comparator<Team> {

	@Override
	public int compare(Team t1, Team t2) {
		if (t1.getPoints() > t2.getPoints())
			return -1;

		else if (t1.getPoints() < t2.getPoints())
			return 1;

		else {
			if (t1.getGoalDifference() > t2.getGoalDifference())
				return -1;

			else if (t1.getGoalDifference() < t2.getGoalDifference())
				return 1;
			else
				return 0;
		}
	}
}