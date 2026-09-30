package part2;

import java.util.Scanner;
public class Assignment5Part2 {

    public static void Shareholders_assistant(int current_shares, float purchase_price, float market_price, float available_funds) {
        int sharesToBuy = worth_buying(purchase_price, market_price, available_funds);
        int sharesToSell = worth_selling(current_shares, purchase_price, market_price);

        if (market_price < purchase_price && sharesToBuy > 0) {
            System.out.printf("Buy %d shares\n", sharesToBuy);
        } else if (market_price > purchase_price && sharesToSell > 0) {
            System.out.printf("Sell %d shares\n", sharesToSell);
        } else {
            System.out.printf("Hold \n");
        }
    }
    public static int worth_buying(float purchase_price, float market_price, float available_funds){//A function to evaluate the profitability of a purchase, returning zero if it is not profitable, or the quantity if it is.
        float new_shares=(available_funds-10)/market_price;
        int new_shares_int =(int )new_shares;
        if ((purchase_price-market_price)*new_shares_int >10){//calculating whether the benefit of the purchase will cover the commission
            return new_shares_int;
        }else return 0;
    }
    public static int worth_selling(int current_shares, float purchase_price, float market_price){//A function to check the profitability of a sale, returning zero if unprofitable or the quantity if profitable.
        if ((market_price-purchase_price)*current_shares >10){//calculation of whether the proceeds from the sale will cover the commission
            return current_shares;
        }else return 0;
    }


    static void main(String[] args) {

        Scanner cin = new Scanner(System.in); //scanner initialization

        System.out.print("Test 1 \n");
        System.out.print("current_shares: ");
        int current_shares= cin.nextInt();
        System.out.print("\npurchase_price: ");
        float purchase_price= cin.nextFloat();
        System.out.print("\nmarket_price: ");
        float market_price= cin.nextFloat();
        System.out.print("\navailable_funds: ");
        float available_funds= cin.nextFloat();

        Shareholders_assistant(current_shares,purchase_price,market_price,available_funds);//function call
/*This could have been put into an infinite loop with a prompt
 to exit after each iteration, but the professor said that using
 infinite loops is discouraged, so I didn't do it that way. :/ */
    }
}
