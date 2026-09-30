package part2;

import java.util.Scanner;
public class Assignment5Part2 {

    public static void Shareholders_assistant ( int current_shares,float purchase_price, float market_price, float available_funds){
//There are only three market states: the current price is higher, the current price is lower, or they are the same.
        if (worth_buying(purchase_price,market_price,available_funds)!=0||available_funds>10){//If the current price is lower, we must buy—but only if we have the funds and it is profitable. A special function checks for profitability. And the condition in the `if` statement is that we can't buy anything if we have less than 10 money.
            if(market_price<purchase_price) {
                System.out.print ("Buy "+ worth_buying(purchase_price,market_price,available_funds) + " shares\n");
            }else System.out.printf("Hold\n");
            }else if (market_price==purchase_price){//The simplest option—to hold on in any case.
                System.out.printf("Hold\n");
            }else if (market_price>purchase_price){
            if (worth_selling(current_shares, purchase_price,market_price)!=0){
                System.out.print ("Sell "+ worth_selling(current_shares, purchase_price,market_price) + " shares\n");
            }else System.out.printf("Hold\n");
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
