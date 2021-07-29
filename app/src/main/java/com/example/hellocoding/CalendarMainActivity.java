package com.example.hellocoding;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import com.example.hellocoding.databinding.ActivityCalendarMainBinding;
import com.example.hellocoding.databinding.CalendarDayLayoutBinding;
import com.example.hellocoding.databinding.MonthViewContainerBinding;
import com.example.hellocoding.sample.SecondActivity;
import com.kizitonwose.calendarview.model.CalendarDay;
import com.kizitonwose.calendarview.model.CalendarMonth;
import com.kizitonwose.calendarview.model.DayOwner;
import com.kizitonwose.calendarview.ui.DayBinder;
import com.kizitonwose.calendarview.ui.MonthHeaderFooterBinder;
import com.kizitonwose.calendarview.ui.ViewContainer;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class CalendarMainActivity extends AppCompatActivity {
    ActivityCalendarMainBinding binding;
    LocalDate selectedDate = null;
    LocalDate today = LocalDate.now();
    private String day;
    private String month;
    private String year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityCalendarMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        YearMonth currentMonth = YearMonth.now();
        YearMonth firstMonth = currentMonth.minusMonths(10);
        YearMonth lastMonth = currentMonth.plusMonths(10);
        DayOfWeek firstDayOfWeek = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();
        binding.calendarView.setup(firstMonth, lastMonth, firstDayOfWeek);
        binding.calendarView.scrollToMonth(currentMonth);

        binding.calendarView.setDayBinder(new DayBinder<DayViewContainer>() {
            @Override
            public DayViewContainer create(View view) {
                return new DayViewContainer(view);
            }

            @Override
            public void bind(DayViewContainer container, CalendarDay day) {
                container.day = day;
                TextView textView = container.textView;
                textView.setText(day.getDate().getDayOfMonth() + "");

                if (day.getOwner() == DayOwner.THIS_MONTH) {
                    textView.setVisibility(View.VISIBLE);
                    if (day.getDate() == selectedDate) {
                        textView.setTextColor(getColor(R.color.white));
                        textView.setBackgroundResource(R.drawable.selected_bg);
                    } else if (day.getDate() == today) {
                        textView.setTextColor(getColor(R.color.purple_700));
                        textView.setBackground(null);
                    } else {
                        textView.setTextColor(getColor(R.color.black));
                        textView.setBackground(null);
                    }
                } else {
                    textView.setVisibility(View.GONE);
                }
            }
        });


        binding.calendarView.setMonthHeaderBinder(new MonthHeaderFooterBinder<MonthViewContainer>() {
            @Override
            public MonthViewContainer create(View view) {
                return new MonthViewContainer(view);
            }

            @Override
            public void bind(MonthViewContainer viewContainer, CalendarMonth calendarMonth) {
                viewContainer.textView.setText(calendarMonth.getYearMonth().getMonth().toString() + calendarMonth.getYear());
                month = calendarMonth.getYearMonth().getMonth().toString();
                year = String.valueOf(calendarMonth.getYear());
            }
        });
    }

    public class DayViewContainer extends ViewContainer {
        public CalendarDay day;
        public TextView textView = CalendarDayLayoutBinding.bind(getView()).calendarDayText;
        public DayViewContainer(View view) {
            super(view);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), DiaryActivity.class);
                    startActivity(intent);
//                    if (day.getOwner() == DayOwner.THIS_MONTH) {
//                        if (selectedDate == day.getDate()) {
//                            selectedDate = null;
//                            binding.calendarView.notifyDayChanged(day);
//                        } else {
//                            LocalDate oldDate = selectedDate;
//                            selectedDate = day.getDate();
//                            binding.calendarView.notifyDateChanged(day.getDate());
//                            if (oldDate != null) {
//                                binding.calendarView.notifyDateChanged(oldDate);
//                            }
//                        }
//                        menuItem.isVisible = selectedDate != null

                    Intent intent1 = new Intent(getApplicationContext(), SecondActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(DiaryActivity.DAY, String.valueOf(day));
                    bundle.putString(DiaryActivity.MONTH, month);
                    bundle.putString(DiaryActivity.YEAR, year);
                    intent.putExtra(SecondActivity.BUNDLE, bundle);
                    startActivity(intent);
                }
            });
        }
    }

    public class MonthViewContainer extends ViewContainer {
        public TextView textView = MonthViewContainerBinding.bind(getView()).exTwoHeaderText;

        public MonthViewContainer(View view) {
            super(view);
        }
    }

}