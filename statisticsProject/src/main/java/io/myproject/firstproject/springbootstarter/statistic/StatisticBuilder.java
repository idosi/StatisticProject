package io.myproject.firstproject.springbootstarter.statistic;

import java.util.List;

public class StatisticBuilder
{
	protected List<Long> numberList;
	protected Double average;
	protected Double sum;
	protected Long median;
	protected Integer numberCount;

	protected Long[] percentiles;
	
	public StatisticBuilder(Double average, Double sum, Long median, Long[] percentiles, List<Long> numberList, Integer numberCount)
	{
		super();
		this.average = average;
		this.sum = sum;
		this.median = median;
		this.percentiles = percentiles;
		this.numberList = numberList;
		this.numberCount = numberCount;
	}
	
    public Statistic build() {
    	Statistic stat =  new Statistic(this);
        return stat;
    }
}
