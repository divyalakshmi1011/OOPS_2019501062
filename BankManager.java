import java.util.Date;

class bankAccount {
    String accountNumber;
    double balance;
    bankAccount (String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    bankAccount() {

    }

}

class checking extends bankAccount {
    double limit;
    checking (double limit){
        this.limit = limit;
    }
}

class savings extends bankAccount {
    int transfers;
    savings (int transfers) {
        this.transfers = transfers;
    }
}

class certificateOfDeposite extends bankAccount {
    Date expiry;
    certificateOfDeposite () {
        this.expiry = expiry;
    }
}

public class BankManager {
    public static void main(String args[])  
    { 
       certificateOfDeposite COD = new certificateOfDeposite();
       savings s = new savings(5);
       bankAccount b = new bankAccount("123456",789065);
       checking c = new checking(45623);
       System.out.println(COD.balance); 
       System.out.println(s.transfers);
       System.out.println(b.balance);
       System.out.println(c.limit);      
    } 
}