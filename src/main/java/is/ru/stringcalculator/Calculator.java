package is.ru.stringcalculator;
import java.util.ArrayList;

public class Calculator
{
	public static int add(String text)
	{
		if(text.equals(""))	
			return 0;
		else
		{
			if(text.contains(",") | text.contains("\n"))
			{
				String numbers[] = text.split(",|\n");
				return sum(numbers);
			}
			return 1;
		}
	}

	private static int toInt(String number)
	{
		return Integer.parseInt(number);
	}

	private static int sum(String[] numbers)
	{
		ArrayList<Integer> negatives = new ArrayList<Integer>();
		int total  = 0;
		for(String number : numbers)
		{
			if(toInt(number) < 0)
			{
				negatives.add(toInt(number));
			}
			else if(toInt(number) < 1001)
			{
				total = total + toInt(number);
			}
			else
			{
			}
		}

		if(!negatives.isEmpty())
			{
				String messageAddOn = "";
				for(int negative : negatives)
				{
					int lastElementIndex = negatives.size() - 1;
					if(negative == negatives.get(lastElementIndex))
					{
						messageAddOn = messageAddOn + String.valueOf(negative);
					}
					else
					{
						messageAddOn = messageAddOn + String.valueOf(negative) + ",";
					}
				}
				throw new IllegalArgumentException ("Negatives not allowed: " + messageAddOn);
			}
		return total;
	}
}