package io.myproject.firstproject.springbootstarter.statistic;

import java.util.List;

public class StatisticBuilder
{
	protected List<Integer> numberList;
	protected Double average;
	protected Double sum;
	protected Long median;
	protected Integer numberCount;
	protected int[] percentiles;
	
	public StatisticBuilder(List<Integer> numberList)
	{
		super();
		this.numberList = numberList;
	}
	
	public StatisticBuilder setAverage(Double average)
	{
		this.average = average;
		return this;
	}
	
	public StatisticBuilder setSum(Double sum)
	{
		this.sum = sum;
		return this;
	}
	
	public StatisticBuilder setMedian(Long median)
	{
		this.median = median;
		return this;
	}
	
	public StatisticBuilder setPercentiles(int[] percentiles)
	{
		this.percentiles = percentiles;
		return this;
	}
	
	public StatisticBuilder setNumberCount(Integer numberCount)
	{
		this.numberCount = numberCount;
		return this;
	}
	
    public Statistic build() 
    {	
    	return new Statistic(this);
    }
}
