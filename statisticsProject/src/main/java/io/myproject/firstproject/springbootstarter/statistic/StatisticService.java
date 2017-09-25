package io.myproject.firstproject.springbootstarter.statistic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StatisticService implements StatServiceInterface
{
	private Statistic stat;
	private List<Long> numberList = new ArrayList<>();
	
	@Value("${base.module.percentileArray}")
	private String[] percentileArray;

	private Double getAvg()
	{
		double sum = getSum();
		if (sum>0)
		{
			Double avg = sum/numberList.size();
			return avg;
		}
		else{
			return sum;
		}
	}

	private Long getMedian()
	{
		Long medianValue = null;
		Long[] numbersArr = numberList.toArray(new Long[numberList.size()]);
		Arrays.sort(numbersArr);
		int median = numbersArr.length /2;
		if (numbersArr.length % 2 == 1) {
			medianValue = (long)numbersArr[median];
			return medianValue;
		} else {
			medianValue = (numbersArr[median - 1] + numbersArr[median]) / 2;
			return medianValue;
		}
	}

	private Double getSum()
	{
		double sum = 0;
		for(long num : numberList)
		{
			sum += num;
		}
		return sum;
	}

	private Long[] getPercentiles()
	{		
		Long[] numbersArr = numberList.toArray(new Long[numberList.size()]);
		Double[] percentiles = getDoubleArray(percentileArray);
		Long[] percentilesResult = percentiles(numbersArr , percentiles);
		return percentilesResult;	
	}

	private Double[] getDoubleArray(String[] percentileArray)
	{
		Double[] percentilesLongArr = new Double[percentileArray.length];
		for (int i = 0; i < percentileArray.length; i++) {
			percentilesLongArr[i] = Double.parseDouble(percentileArray[i]);
		}
		return percentilesLongArr;
	}

	private static Long[] percentiles(Long[] latencies, Double... percentiles) {
		Arrays.sort(latencies, 0, latencies.length);
		Long[] values = new Long[percentiles.length];
		for (int i = 0; i < percentiles.length; i++) {
			int index = (int) (percentiles[i] * latencies.length);
			values[i] = latencies[index];
		}
		return values;
	}

	public String getSpecificStatistic(String specificStats)
	{
		if (StatisticEnum.AVERAGE.toString().toLowerCase().equals(specificStats))
		{
			Double avg = getAvg();
			return "Average =  " + avg;
		}
		if (StatisticEnum.SUM.toString().toLowerCase().equals(specificStats))
		{
			Double sum = getSum();
			return  "Sum = " + sum;
		}
		if (StatisticEnum.MEDIAN.toString().toLowerCase().equals(specificStats))
		{
			Long median = getMedian();
			return "Median = " + median;
		}

		return "input value is not correct";
	}
	
	public Statistic getStatistic()
	{
		if (numberList.isEmpty())
		{
			return null;
		}
		Double sum = getSum();
		Double avg = getAvg();
		Long median = getMedian();
		Long[] percentiles = getPercentiles();
		stat = new StatisticBuilder(avg,sum,median,percentiles,numberList,numberList.size()).build();
		return stat;
	}

	public void addNumber(String number)
	{
		numberList.add(Long.valueOf(number));
	}

	public List<Long> getAllNumbers()
	{
		return numberList;
	}

	public int getNumberCount()
	{
		return numberList.size();
	}

	public void addNumbers(NumbersWrapper numbers)
	{
		List<Integer> numberslist = numbers.getNumbers();
		for(long num : numberslist)
		{
			numberList.add(num);
		}
	}
}
