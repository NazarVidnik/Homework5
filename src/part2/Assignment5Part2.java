package part2;

import java.util.Scanner;
public class Assignment5Part2 {

    public static void Shareholders_assistant ( int current_shares,float purchase_price, float market_price, float available_funds){

        if(market_price<purchase_price) {
            if (worth_buying(purchase_price,market_price,available_funds)!=0||available_funds>10){
                System.out.print ("Buy "+ worth_buying(purchase_price,market_price,available_funds) + " shares\n");
            }else System.out.printf("Hold\n");

        }else if (market_price==purchase_price){
            System.out.printf("Hold\n");
        }else if (market_price>purchase_price){
            if (worth_selling(current_shares, purchase_price,market_price)!=0){
                System.out.print ("Sell "+ worth_selling(current_shares, purchase_price,market_price) + " shares\n");
            }else System.out.printf("Hold\n");
        }
    }
    public static int worth_buying(float purchase_price, float market_price, float available_funds){
        float new_shares=(available_funds-10)/market_price;
        int new_shares_int =(int )new_shares;
        if ((purchase_price-market_price)*new_shares_int >10){
            return new_shares_int;
        }else return 0;
    }
    public static int worth_selling(int current_shares, float purchase_price, float market_price){
        if ((market_price-purchase_price)*current_shares >10){
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

        Shareholders_assistant(current_shares,purchase_price,market_price,available_funds);

    }
}
