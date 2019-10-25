import java.util.Date;
/**Implementing inheritance on BankManager class as parent class
 * Child classes are
 * Savings
 * checking
 * certificate of deposite
 */

class bankAccount {
    /**creates bankaccount class
     * @param accountNumber
     * @param balance
     */
    String accountNumber;
    double balance;
    bankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    bankAccount() {

    }

}

class checking extends bankAccount {
    /**creates child class of bankaccount class as checking class
     * The parameter limit specifies the amount of money to be withdrawn or transferred
     * @param limit
     */
    double limit;
    checking(final double limit) {
        this.limit = limit;
    }
}

class savings extends bankAccount {
    /**creates another child class of bankaccount as savings
     * the parameter transfers specifies the number of transactions or transfers happend
     * @param transfers
     */
    int transfers;
    savings(final int transfers) {
        this.transfers = transfers;
    }
}

class certificateOfDeposite extends bankAccount {
    /**creates another child class of bankaccount as certificate of deposite
     * the parameter expiry specifies the expiry date of deposites
     * @param expiry
     */
    Date expiry;
    certificateOfDeposite() {
        this.expiry = expiry;
    }
    public double interest(double time, double rate) {
        double interest = (balance * time * rate)/100;
        return interest;
    }
}

public class bankManager {
    //creates instances of child classes and parent class
    public static void main(final String args[]) {
       bankAccount b = new bankAccount("123456",789065);
       certificateOfDeposite COD = new certificateOfDeposite();
       //COD.balance = 567890;
       savings s = new savings(5);
       checking c = new checking(45623);
       System.out.println(COD.balance);
       System.out.println(s.transfers);
       System.out.println(b.balance);
       System.out.println(c.limit);
       System.out.println(COD.interest(2.5,4.5));
       //System.out.println(COD.interest(2.5,4.5));
    }
}
