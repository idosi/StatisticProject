package io.myproject.firstproject.springbootstarter.statistic;

import java.util.List;

public interface StatServiceInterface
{
	public Statistic getStatistic();
	public String getSpecificStatistic(String specificStats);
	public void addNumber(String number);
	public List<Long> getAllNumbers();
	public int getNumberCount();
	public void addNumbers(NumbersWrapper numbers);
}
