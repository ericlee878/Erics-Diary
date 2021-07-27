package com.example.hellocoding;

import android.view.View;
import android.widget.TextView;

import com.kizitonwose.calendarview.ui.ViewContainer;

public class DayViewContainer extends ViewContainer {
    public TextView textView;
    public DayViewContainer(View view) {
        super(view);
        textView = view.findViewById(R.id.calendarDayText);
    }

    // With ViewBinding
        // val textView = CalendarDayLayoutBinding.bind(view).calendarDayText
        }