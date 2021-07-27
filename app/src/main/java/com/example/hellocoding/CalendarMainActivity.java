package com.example.hellocoding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.example.hellocoding.databinding.ActivityCalendarMainBinding;
import com.kizitonwose.calendarview.model.CalendarDay;
import com.kizitonwose.calendarview.model.CalendarMonth;
import com.kizitonwose.calendarview.ui.DayBinder;
import com.kizitonwose.calendarview.ui.MonthHeaderFooterBinder;
import com.kizitonwose.calendarview.ui.MonthViewHolder;
import com.kizitonwose.calendarview.ui.ViewContainer;

import java.time.DayOfWeek;
import java.time.YearMonth;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class CalendarMainActivity extends AppCompatActivity {
    ActivityCalendarMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityCalendarMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.calendarView.setDayBinder(new DayBinder<DayViewContainer>() {
            @Override
            public DayViewContainer create(View view) {
                return new DayViewContainer(view);
            }

            @Override
            public void bind(DayViewContainer viewContainer, CalendarDay calendarDay) {
                viewContainer.textView.setText(calendarDay.getDate().getDayOfMonth() + "");
            }
        });
        YearMonth currentMonth = YearMonth.now();
        YearMonth firstMonth = currentMonth.minusMonths(10);
        YearMonth lastMonth = currentMonth.plusMonths(10);
        DayOfWeek firstDayOfWeek = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();
        binding.calendarView.setup(firstMonth, lastMonth, firstDayOfWeek);
        binding.calendarView.scrollToMonth(currentMonth);


        binding.calendarView.setMonthHeaderBinder(new MonthHeaderFooterBinder<MonthHeaderFooterBinder>()
        {
            @Override
            public MonthHeaderFooterBinder create(View view) {
                return null;
            }

            @Override
            public void bind(MonthHeaderFooterBinder monthHeaderFooterBinder, CalendarMonth calendarMonth) {

            }
        });
        new MonthHeaderFooterBinder<ViewContainer>() {
            @Override
            public ViewContainer create(View view) {
                return null;
            }

            @Override
            public void bind(ViewContainer viewContainer, CalendarMonth calendarMonth) {

            }
        };
    }
}