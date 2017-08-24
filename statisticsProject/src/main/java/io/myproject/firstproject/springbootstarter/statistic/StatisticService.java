package io.myproject.firstproject.springbootstarter.statistic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

import org.springframework.stereotype.Service;

@Service
public class StatisticService
{
	private Statistic stat;
	private List<Integer> numberList = new ArrayList<>();

	public void calcAvg()
	{
		double sum = 0;
		for(Integer num : numberList)
		{
			sum += num;
		}
		Double avg = sum/numberList.size();
		
		stat.setAverage(avg.toString());
	}
	
	public void calcMedian()
	{
		Double medianValue = null;
		Integer[] numbersArr = numberList.toArray(new Integer[numberList.size()]);
		Arrays.sort(numbersArr);
		int median = numbersArr.length /2;
		if (numbersArr.length % 2 == 1) {
			medianValue = (double)numbersArr[median];
			stat.setMedian(medianValue.toString());
	    } else {
	    	medianValue = (numbersArr[median - 1] + numbersArr[median]) / 2.0;
	    	stat.setMedian(medianValue.toString());
	    }
	}
	
	public void calcSum()
	{
		int sum = 0;
		for(Integer num : numberList)
		{
			sum += num;
		}
		stat.setSum(Integer.toString(sum));
	}
	
	public void calcPercentiles()
	{		
		int nInts = numberList.size();
		List<Long> longs = new ArrayList<Long>(nInts);
		for (int i=0;i<nInts;++i) {
		    longs.add(numberList.get(i).longValue());
		}
		Long[] numbersArr = longs.toArray(new Long[longs.size()]);

		long[] result = percentiles(numbersArr ,0.1, 0.25 ,0.5 ,0.75 ,0.9 ,0.95 ,0.99);
		
		stat.setPercentile10(Long.toString(result[0]));
		stat.setPercentile25(Long.toString(result[1]));
		stat.setPercentile50(Long.toString(result[2]));
		stat.setPercentile75(Long.toString(result[3]));
		stat.setPercentile90(Long.toString(result[4]));
		stat.setPercentile95(Long.toString(result[5]));
		stat.setPercentile99(Long.toString(result[6]));		
	}
	
	  public static long[] percentiles(Long[] latencies, double... percentiles) {
		    Arrays.sort(latencies, 0, latencies.length);
		    long[] values = new long[percentiles.length];
		    for (int i = 0; i < percentiles.length; i++) {
		      int index = (int) (percentiles[i] * latencies.length);
		      values[i] = latencies[index];
		    }
		    return values;
		  }

	public String getSpecificStatistic(String id)
	{
		stat = new Statistic();
		if ("average".equals(id))
		{
			calcAvg();
			return stat.getAverage().toString();
		}
		if ("sum".equals(id))
		{
			calcSum();
			return stat.getSum().toString();
		}
		if ("median".equals(id))
		{
			calcMedian();
			return stat.getMedian().toString();
		}
		return "input value is not correct";
	}

	public Statistic getStatistic()
	{
		stat = new Statistic();
		calcSum();
		calcAvg();
		calcMedian();
		calcPercentiles();
		stat.setNumberList(numberList);
		return stat;
		
	}

	public void addNumber(String number)
	{
		numberList.add(Integer.valueOf(number));
	}

	public List<Integer> getAllNumbers()
	{
		return numberList;
	}

	public String getNumberCount()
	{
		return Integer.toString(numberList.size());
	}

//	public void addNumbers(List<String> numbers)
//	{
//		for(String num : numbers)
//		{
//			numberList.add(Integer.valueOf(num));
//		}
//	}
}
