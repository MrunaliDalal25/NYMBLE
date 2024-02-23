package com.example.demo;

public class Destination {
private String name;
private List<Activity> activities;

public Destination(String name) {
    this.name = name;
    this.activities = new ArrayList<>();
}

public void addActivity(Activity activity) {
    activities.add(activity);
}

public List<Activity> getActivities() {
    return activities;
}

public Activity findActivityByName(String activityName) {
    for (Activity activity : activities) {
        if (activity.getName().equals(activityName)) {
            return activity;
        }
    }
    return null; // Activity not found
}

public boolean removeActivity(Activity activity) {
    return activities.remove(activity);
}

public String getName() {
	// TODO Auto-generated method stub
	return null;
}
}