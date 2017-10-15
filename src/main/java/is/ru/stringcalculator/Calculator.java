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
			if(shouldSplit(text))
			{
				String numbers[];
				numbers = splitIntoNumbers(text);
				return sum(numbers);
			}
			else
			{
				return toInt(text);
			}
		}
	}

	private static String[] splitIntoNumbers(String text)
	{
		String numbers[];
		if(!text.startsWith("//"))
		{
			numbers = text.split(",|\n");
		}
		else
		{
			String delimiter = "";
			int endOfDelimiterIndex = text.indexOf("\n");
					
			delimiter = text.substring(2, endOfDelimiterIndex);
			String newText = text.substring(endOfDelimiterIndex + 1, text.length());
			numbers = newText.split(delimiter);
		}
		return numbers;
	}

	private static boolean shouldSplit (String text)
	{
		return text.contains(",") | text.contains("\n") | text.contains("//");
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
		negativeCheck(negatives);
		return total;
	}

	private static void negativeCheck(ArrayList<Integer> negatives)
	{
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
	}
}