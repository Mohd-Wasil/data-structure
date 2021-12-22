package com.data.structure.v2.excercises.greedy.activityselection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ActivitySelection {

    public void activitySelection(ArrayList<Activity> activities) {
        //sort based on finish time
        Collections.sort(activities, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.getFinishTime() - o2.getFinishTime();
            }
        });
        Activity selectedActivity = activities.get(0);
        System.out.println("Activity selected : " + selectedActivity);

        for (int i = 1; i < activities.size(); i++) {
            if (selectedActivity.getFinishTime() <= activities.get(i).getStartTime()) {
                selectedActivity = activities.get(i);
                System.out.println("Activity selected : " + selectedActivity);
            }
        }
    }

}
