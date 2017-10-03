package io.myproject.firstproject.springbootstarter.statistic;

import java.util.List;

public class Statistic {
  private final List<Long> numberList;
  private final Double average;
  private final long sum;
  private final Long median;

  private final long[] percentiles;

  public Statistic(StatisticBuilder sb) {
    super();
    this.average = sb.average;
    this.sum = sb.sum;
    this.median = sb.median;
    this.percentiles = sb.percentiles;
    this.numberList = sb.numberList;
  }

  public Double getAverage() {
    return average;
  }

  public long getSum() {
    return sum;
  }

  public Long getMedian() {
    return median;
  }

  public List<Long> getNumberList() {
    return numberList;
  }

  public Integer getNumberCount() {
    return numberList.size();
  }

  public long[] getPercentiles() {
    return percentiles;
  }

  public void clear() {
    if(numberList!=null){
      numberList.clear();
    }
  }
}