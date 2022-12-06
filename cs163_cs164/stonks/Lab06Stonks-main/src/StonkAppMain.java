/*
 * go
public void go()
Main controller for program.
walletInitializer

public void walletInitializer()
Initializes the wallet, either default or with custom values based on user input.
parseAction
public void parseAction(String action)
Parses through user input and performs correlated action.
Parameters:
action - Desired action to be performed by user

purchaseFazCoin
public void purchaseFazCoin(int numFazCoin)
Adds FazCoin to the wallet and removes appropriate USD amount
When buying FazCoin:

Check if there is enough money in your wallet to buy the desired number of FazCoin.
If you can, then add the purchased FazCoin to your wallet and subtract the cost of the purchased FazCoin from your total USD.
Otherwise, if the desired amount of FazCoin costs more than you currently have in USD, print a statement such as "You do not have enough money to buy that much FazCoin."
Parameters:
numFazCoin - Number of FazCoin you are trying to buy

sellFazCoin
public void sellFazCoin(int numFazCoin)
Removes FazCoin from the wallet and adds appropriate USD amount
When selling FazCoin:

Check if there is enough FazCoin in your wallet to sell the desired number of FazCoin.
If you can, then subtract the sold FazCoin from your wallet and add the price of the sold FazCoin to your total USD.
Otherwise, if the desired amount of FazCoin to sell exceeds your current amount of FazCoin, print a statement such as "You do not have enough FazCoin to sell."
Parameters:
numFazCoin - Number of FazCoin that you are trying to sell
 */

public class StonkAppMain {

    StonkMarket sm = new StonkMarket();
    StonksAppView view = new StonksAppView();
    Wallet w;

    public void go(){
        view.startScreen();
        walletInitializer();
        view.printMenu();
        view.walletInfo(w, sm);
        String action = view.getAction("What would you like to do? ");
        while(!action.startsWith("x")) {
            parseAction(action);
            view.walletInfo(w, sm);
            action = view.getAction("What would you like to do? ");
        }
    }

    public void walletInitializer(){
        String walletChoice = view.getAction("Would you like to start with the default wallet, or enter your own?\n" +
                "Enter [d]efault or [c]ustom: ");
        if(walletChoice.startsWith("d")){
            w = new Wallet();
        }
        else{
            int fazCoin = Integer.parseInt(view.getAction("So you want to invest more!\n"
                    + "How much FazCoin do you already own? "));
            double usd = Double.parseDouble(view.getAction("How much money in USD do you plan to work with? "));
            w = new Wallet(fazCoin, usd);
        }
    }


    public void parseAction(String action) {
        if (action.startsWith("b")) {
            int num = Integer.parseInt(view.getAction("How much FazCoin would you like to buy? "));
            purchaseFazCoin(num);
        } else if (action.startsWith("s")) {
            int num = Integer.parseInt(view.getAction("How much FazCoin would you like to sell? "));
            sellFazCoin(num);
        } else if (action.startsWith("n") || action.startsWith("d")) {
            //Don't do anything
        } else {
            System.out.println("Please enter a valid command.");
        }
    }

    public void purchaseFazCoin(int numFazCoin){
        double price = sm.getFazCoinPrice();
        double totalCost = numFazCoin * price;
        if(w.getUsd() >= totalCost){
            w.setFazCoin(w.getFazCoin() + numFazCoin);
            w.setUsd(w.getUsd() - totalCost);
            System.out.println("You have purchased " + numFazCoin + " FazCoin for $" + totalCost + ".");
        }
        else{
            System.out.println("You do not have enough money to purchase " + numFazCoin + " FazCoin.");
        }
    }

    public void sellFazCoin(int numFazCoin){
        double price = sm.getFazCoinPrice();
        double totalCost = numFazCoin * price;
        if(w.getFazCoin() >= numFazCoin){
            w.setFazCoin(w.getFazCoin() - numFazCoin);
            w.setUsd(w.getUsd() + totalCost);
            System.out.println("You have sold " + numFazCoin + " FazCoin for $" + totalCost + ".");
        }
        else{
            System.out.println("You do not have enough FazCoin to sell " + numFazCoin + ".");
        }
    }



    public static void main(String[] args) {
        StonkAppMain m = new StonkAppMain();
        m.go();
    }

}
