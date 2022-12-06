public class Wallet {

    private int fazCoin;
    private double USDollars;

    /*
    Wallet
public Wallet()
Default constructor for the Wallet. Sets FazCoin to 500 and USDollars to 5.
Wallet
public Wallet(int fazCoin,
 double USDollars)
Overloaded constructor for the Wallet. Sets Wallet's FazCoin amount to argument fazCoin and Wallet USDollars to argument USDollars.
Parameters:
fazCoin - Amount of FazCoin to start off with in Wallet
USDollars - Amount of USD to start off with in Wallet
     * getFazCoin
public int getFazCoin()
Gets the amount of FazCoin you own
Returns:
FazCoin amount
setFazCoin
public void setFazCoin(int fazCoin)
Sets FazCoin in your wallet
Parameters:
fazCoin - Amount of FazCoin to put in your wallet
getUSDollars
public double getUSDollars()
Gets the amount of USD you have
Returns:
USD amount
setUSDollars
public void setUSDollars(double USDollars)
Sets USD in your wallet
Parameters:
USDollars - Amount of USD to put in your wallet
     */
    public Wallet() {
        fazCoin = 500;
        USDollars = 5;
    }

    public Wallet(int fazCoin, double usDollars) {
        this.fazCoin = fazCoin;
        USDollars = usDollars;
    }

    //getfazcoin
    public int getFazCoin() {
        return fazCoin;
    }

    //getusdollars
    public double getUSDollars() {
        return USDollars;
    }

    //getUsd
    public double getUsd() {
        return USDollars;
    }
    

    //setfazcoin
    public void setFazCoin(int fazCoin) {
        this.fazCoin = fazCoin;
    }

    //setusdollars
    public void setUSDollars(double usDollars) {
        USDollars = usDollars;
    }

    //setUsd
    public void setUsd(double usd) {
        USDollars = usd;
    }
}
