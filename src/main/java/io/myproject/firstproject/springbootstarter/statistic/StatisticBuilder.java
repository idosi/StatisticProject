package io.myproject.firstproject.springbootstarter.statistic;

import java.util.List;

public class StatisticBuilder {
  protected List<Long> numberList;
  protected Double average;
  protected long sum;
  protected Long median;
  protected long[] percentiles;

  public StatisticBuilder(List<Long> numberList) {
    super();
    this.numberList = numberList;
  }

  public StatisticBuilder setAverage(Double average) {
    this.average = average;
    return this;
  }

  public StatisticBuilder setSum(long sum) {
    this.sum = sum;
    return this;
  }

  public StatisticBuilder setMedian(Long median) {
    this.median = median;
    return this;
  }

  public StatisticBuilder setPercentiles(long[] percentiles) {
    this.percentiles = percentiles;
    return this;
  }

  public Statistic build() {
    return new Statistic(this);
  }
}
