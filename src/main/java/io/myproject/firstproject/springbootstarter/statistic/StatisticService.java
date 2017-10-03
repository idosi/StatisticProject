package io.myproject.firstproject.springbootstarter.statistic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StatisticService implements StatServiceInterface {
  private Statistic stat;
  private List<Long> numberList = new ArrayList<>();

  @Value("${base.module.percentileArray}")
  private String[] percentileArray;

  private Double getAvg() {
    double sum = getSum();
    if (sum > 0) {
      Double avg = sum / numberList.size();
      return avg;
    } else {
      return sum;
    }
  }

  private Long getMedian() {
    Long medianValue = null;
    Long[] numbersArr = numberList.toArray(new Long[numberList.size()]);
    Arrays.sort(numbersArr);
    int median = numbersArr.length / 2;
    if (numbersArr.length % 2 == 1) {
      medianValue = numbersArr[median];
      return medianValue;
    } else {
      medianValue = (numbersArr[median - 1] + numbersArr[median]) / 2;
      return medianValue;
    }
  }

  private Double getSum() {
    double sum = 0;
    for (long num : numberList) {
      sum += num;
    }
    return sum;
  }

  private long[] getPercentiles() {
    Long[] numbersArr = numberList.toArray(new Long[numberList.size()]);
    Double[] percentiles = getDoubleArray(percentileArray);
    long[] percentilesResult = percentiles(numbersArr, percentiles);
    return percentilesResult;
  }

  private Double[] getDoubleArray(String[] percentileArray) {
    Double[] percentilesLongArr = new Double[percentileArray.length];
    for (int i = 0; i < percentileArray.length; i++) {
      percentilesLongArr[i] = Double.parseDouble(percentileArray[i]);
    }
    return percentilesLongArr;
  }

  private static long[] percentiles(Long[] latencies, Double... percentiles) {
    Arrays.sort(latencies, 0, latencies.length);
    long[] values = new long[percentiles.length];
    for (int i = 0; i < percentiles.length; i++) {
      int index = (int) ((percentiles[i]/100) * latencies.length);
      values[i] = latencies[index];
    }
    return values;
  }

  @Override
  public String getSpecificStatistic(String specificStats) {
    if (StatisticType.AVERAGE.toString().toLowerCase().equals(specificStats)) {
      Double avg = getAvg();
      return "Average = " + avg.toString();
    }
    if (StatisticType.SUM.toString().toLowerCase().equals(specificStats)) {
      Double sum = getSum();
      return "Sum = " + sum.toString();
    }
    if (StatisticType.MEDIAN.toString().toLowerCase().equals(specificStats)) {
      Long median = getMedian();
      return "Median = " + median.toString();
    }

    return "input value is not correct";
  }

  @Override
  public Statistic getStatistic() {
    if (numberList.isEmpty()) {
      return null;
    }
    Double sum = getSum();
    Double avg = getAvg();
    Long median = getMedian();
    long[] percentiles = getPercentiles();
    stat = new StatisticBuilder(numberList).setSum(sum).setAverage(avg).setMedian(median)
        .setPercentiles(percentiles).setNumberCount(numberList.size()).build();
    return stat;
  }

  @Override
  public void addNumber(Long number) {
    numberList.add(number);
  }

  @Override
  public List<Long> getAllNumbers() {
    return numberList;
  }

  @Override
  public int getNumberCount() {
    return numberList.size();
  }

  @Override
  public void addNumbers(NumbersWrapper numbers) {
    List<Long> numberslist = numbers.getNumbers();
    for (long num : numberslist) {
      numberList.add(num);
    }
  }
}
