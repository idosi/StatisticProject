package io.myproject.firstproject.springbootstarter.statistic;

import java.util.List;

public interface StatisticsService {
  Statistic getStatistic();

  String getSpecificStatistic(String specificStats);

  void addNumber(Long number);

  List<Long> getAllNumbers();

  int getNumberCount();

  void addNumbers(NumbersWrapper numbers);

  void clear();
}
