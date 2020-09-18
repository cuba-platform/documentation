package com.company.sampler.web.screens;

import com.company.sampler.entity.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@UiController("sampler_PivotSampleScreen")
@UiDescriptor("pivot-sample-screen.xml")
public class PivotSampleScreen extends Screen {

   @Inject
   private CollectionContainer<Tip> tipsDc;

   @Subscribe
   protected void onInit(InitEvent event) {
       List<Tip> items = new ArrayList<>();
       items.add(tips(1, 16.99, 1.01, Sex.FEMALE, Smoker.NO, Day.FRI, Time.DINNER, 2));
       items.add(tips(2, 10.34, 1.66, Sex.FEMALE, Smoker.YES, Day.THU, Time.LUNCH, 3));
       items.add(tips(3, 21.01, 3.5, Sex.MALE, Smoker.YES, Day.FRI, Time.LUNCH, 3));
       items.add(tips(4, 23.68, 3.31, Sex.FEMALE, Smoker.NO, Day.MON, Time.DINNER, 2));
       items.add(tips(5, 24.59, 3.61, Sex.MALE, Smoker.NO, Day.TUE, Time.LUNCH, 4));
       tipsDc.setItems(items);
   }
   
   private Tip tips(int row, double totalBill, double tip, Sex sex, Smoker smoker, Day day, Time time, int size) {
       Tip tips = new Tip();
       tips.setRow(row);
       tips.setTotalBill(totalBill);
       tips.setTip(tip);
       tips.setSex(sex);
       tips.setSmoker(smoker);
       tips.setDay(day);
       tips.setTime(time);
       tips.setSize(size);
       return tips;
   }
}
