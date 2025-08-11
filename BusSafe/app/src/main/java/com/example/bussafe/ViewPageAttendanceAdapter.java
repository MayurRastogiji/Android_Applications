package com.example.bussafe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPageAttendanceAdapter extends FragmentPagerAdapter {
    public ViewPageAttendanceAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AttendanceFragment();
        } else if (position == 1) {
            return new MapsFragment();
        } else {
            return new CalenderFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Attendance";
        } else if (position == 1) {
            return "Maps";
        } else {
            return "Calender";
        }
    }
}
