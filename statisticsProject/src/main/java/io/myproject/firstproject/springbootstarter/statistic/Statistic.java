package io.myproject.firstproject.springbootstarter.statistic;

import java.util.List;

public class Statistic
{
	private List<Integer> numberList;
	private String average;
	private String sum;
	private String median;
	
	private String percentile10;
	private String percentile25;
	private String percentile50;
	private String percentile75;
	private String percentile90;
	private String percentile95;
	private String percentile99;
	
	
	public Statistic()
	{

	}
	public Statistic(String average, String sum, String median)
	{
		super();
		this.average = average;
		this.sum = sum;
		this.median = median;
	}
	public String getAverage()
	{
		return average;
	}
	public void setAverage(String average)
	{
		this.average = average;
	}
	public String getSum()
	{
		return sum;
	}
	public void setSum(String sum)
	{
		this.sum = sum;
	}
	public String getMedian()
	{
		return median;
	}
	public void setMedian(String median)
	{
		this.median = median;
	}
	public List<Integer> getNumberList()
	{
		return numberList;
	}
	public void setNumberList(List<Integer> numberList)
	{
		this.numberList = numberList;
	}
	public String getPercentile10()
	{
		return percentile10;
	}
	public void setPercentile10(String percentile10)
	{
		this.percentile10 = percentile10;
	}
	public String getPercentile25()
	{
		return percentile25;
	}
	public void setPercentile25(String percentile25)
	{
		this.percentile25 = percentile25;
	}
	public String getPercentile50()
	{
		return percentile50;
	}
	public void setPercentile50(String percentile50)
	{
		this.percentile50 = percentile50;
	}
	public String getPercentile75()
	{
		return percentile75;
	}
	public void setPercentile75(String percentile75)
	{
		this.percentile75 = percentile75;
	}
	public String getPercentile90()
	{
		return percentile90;
	}
	public void setPercentile90(String percentile90)
	{
		this.percentile90 = percentile90;
	}
	public String getPercentile95()
	{
		return percentile95;
	}
	public void setPercentile95(String percentile95)
	{
		this.percentile95 = percentile95;
	}
	public String getPercentile99()
	{
		return percentile99;
	}
	public void setPercentile99(String percentile99)
	{
		this.percentile99 = percentile99;
	}
}