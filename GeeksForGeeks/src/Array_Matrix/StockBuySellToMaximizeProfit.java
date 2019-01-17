package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/stock-buy-sell/
 */
 
class PriceInterval{
	int buy;
	int sell;
}

public class StockBuySellToMaximizeProfit {

	public void stockBuySell(int price[]){
		int n = price.length;
		// Prices must be given for at least two days
		if (n == 1)	return;

		int count = 0; // count of solution pairs

		// solution vector
		PriceInterval sol[] = new PriceInterval[n/2 + 1];

		// Traverse through given price array
		int i = 0;
		while (i < n-1){
			// Find Local Minima. Note that the limit is (n-2) as we are comparing present element to the next element. 
			while ((i < n-1) && (price[i+1] <= price[i]))	i++;
			// If we reached the end, break as no further solution possible
			if (i == n-1)	break;
			// Store the index of minima
			sol[count] = new PriceInterval();
			sol[count].buy = i++;

			// Find Local Maxima.  Note that the limit is (n-1) as we are comparing to previous element
			while ((i < n) && (price[i] >= price[i-1]))		i++;
			// Store the index of maxima
			sol[count].sell = i-1;
			// Increment count of buy/sell pairs
			count++;
		}

		// print solution
		if (count == 0)		System.out.println("There is no day when buying the stock will make profit\n");
		else{
			for (i = 0; i < count; i++)
				System.out.println("Buy on day:"+sol[i].buy+" Sell on day: "+sol[i].sell);
		}
		return;
	}

	public static void main(String[] args) {
		StockBuySellToMaximizeProfit obj = new StockBuySellToMaximizeProfit();
		// stock prices on consecutive days
		int price[] = {100, 180, 260, 310, 40, 535, 695};
		// fucntion call
		obj.stockBuySell(price);
	}
}
