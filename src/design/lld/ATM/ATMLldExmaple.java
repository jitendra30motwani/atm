/**
 * 
 */
package design.lld.ATM;

import java.util.Date;

/**
 * @author 91978
 *
 *
 *Requirements:
 *
 *User should be able to insert card into ATM
 *User should be able to enter pin and ATM should authenticate pin
 *User should be able to select a particular txn option - withdraw/deposit/checkbalance/chnagepin
 *User can cancel the txn and then ATM should return the card
 *ATM should return the card after txn completed
 *Use both State and Chain of responsibility design pattern
 *
 */
public class ATMLldExmaple {

	/**
	 * 
	 */
	public ATMLldExmaple() {
		// TODO Auto-generated constructor stub
	}

}


class ATMRoom{
	
	private ATM atm;
	private User user;
	public ATM getAtm() {
		return atm;
	}
	public void setAtm(ATM atm) {
		this.atm = atm;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}

class User{
	
	private UserBankAccount account;
	private Card card;
	public UserBankAccount getAccount() {
		return account;
	}
	public void setAccount(UserBankAccount account) {
		this.account = account;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	
	
	
}
class ATM{
	
	private ATMState atmState;
	
	private int balance;
	
	private int twoThousandNotes;
	private int fiveHundredNotes;
	private int hundredNotes;
	
	public ATMState getAtmState() {
		return atmState;
	}
	
	public void setAtmState(ATMState atmState) {
		this.atmState = atmState;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getTwoThousandNotes() {
		return twoThousandNotes;
	}
	public void setTwoThousandNotes(int twoThousandNotes) {
		this.twoThousandNotes = twoThousandNotes;
	}
	public int getFiveHundredNotes() {
		return fiveHundredNotes;
	}
	public void setFiveHundredNotes(int fiveHundredNotes) {
		this.fiveHundredNotes = fiveHundredNotes;
	}
	public int getHundredNotes() {
		return hundredNotes;
	}
	public void setHundredNotes(int hundredNotes) {
		this.hundredNotes = hundredNotes;
	}
	
	
}

class Card{
	
	private int cardNumber;
	private int cvv;
	private Date expiryDate;
	private String holderName;
	private static int pin = 123456;
	private UserBankAccount account;
	
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public static int getPin() {
		return pin;
	}
	public static void setPin(int pin) {
		Card.pin = pin;
	}
	public UserBankAccount getAccount() {
		return account;
	}
	public void setAccount(UserBankAccount account) {
		this.account = account;
	}
	
	
	
}

class UserBankAccount{
	
	private int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void updateBalance(int amount) {
		balance = balance+amount;
	}
	
}

enum TransactionType{
	
	WITHDRAW_CASH, DEPOSIT_CASH, CHECK_BALANCE, CHANGE_PIN;
	
}

interface ATMState{
	
	
	void insertCard(ATM atm, Card card);
	
	void authenticatePIN(ATM atm, Card card, int pin);
	
	void exit(ATM atm);
	
	void returnCard();
	
	void selectOperation(ATM atm, Card card, TransactionType transactionType);
	
	void withdrawCash(ATM atm, Card card, int amount);
	
	void depositCash(ATM atm, Card card, int amount);
	
	void checkBalance(ATM atm, Card card, int amount);
	
	void changePIN(ATM atm, Card card, int pin);
	
}

class Idle implements ATMState{

	@Override
	public void insertCard(ATM atm, Card card) {
		
		atm.setAtmState(new HasCard());
		
	}

	@Override
	public void authenticatePIN(ATM atm, Card card, int pin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exit(ATM atm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returnCard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectOperation(ATM atm, Card card, TransactionType transactionType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdrawCash(ATM atm, Card card, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositCash(ATM atm, Card card, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkBalance(ATM atm, Card card, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePIN(ATM atm, Card card, int pin) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

class HasCard implements ATMState{

	@Override
	public void insertCard(ATM atm, Card card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void authenticatePIN(ATM atm, Card card, int pin) {
		
		if(pin==Card.getPin()){
			atm.setAtmState(new Selection());
		}else {
			System.out.println("Invalid PIN");
			exit(atm);
		}
		
	}

	@Override
	public void exit(ATM atm) {
		
		returnCard();
		
		atm.setAtmState(new Idle());
	}

	@Override
	public void returnCard() {
		
		System.out.println("Card is returned");
		
	}

	@Override
	public void selectOperation(ATM atm, Card card, TransactionType transactionType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdrawCash(ATM atm, Card card, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositCash(ATM atm, Card card, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkBalance(ATM atm, Card card, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePIN(ATM atm, Card card, int pin) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

class Selection implements ATMState{

	@Override
	public void insertCard(ATM atm, Card card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void authenticatePIN(ATM atm, Card card, int pin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exit(ATM atm) {
		
		returnCard();
		
		atm.setAtmState(new Idle());
	}

	@Override
	public void returnCard() {
		
		System.out.println("Card is returned");
		
	}

	@Override
	public void selectOperation(ATM atm, Card card, TransactionType transactionType) {
		
		if(TransactionType.WITHDRAW_CASH.equals(transactionType)) {
			atm.setAtmState(new Withdraw());
		}else if(TransactionType.CHECK_BALANCE.equals(transactionType)) {
			atm.setAtmState(new checkBalanceAmount());
		}else {
			System.out.println("Invalid Selection");
			exit(atm);
		}
		
	}

	@Override
	public void withdrawCash(ATM atm, Card card, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositCash(ATM atm, Card card, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkBalance(ATM atm, Card card, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePIN(ATM atm, Card card, int pin) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

class Withdraw implements ATMState{

	@Override
	public void insertCard(ATM atm, Card card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void authenticatePIN(ATM atm, Card card, int pin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exit(ATM atm) {
		
		returnCard();
		
		atm.setAtmState(new Idle());
	}

	@Override
	public void returnCard() {
		
		System.out.println("Card is returned");
		
	}

	@Override
	public void selectOperation(ATM atm, Card card, TransactionType transactionType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdrawCash(ATM atm, Card card, int amount) {
		
		if(amount > atm.getBalance()) {
			System.out.println("ATM has insufficient balance");
			exit(atm);
		}else if(amount > card.getAccount().getBalance()) {
			System.out.println("User Account has insuff balance");
			exit(atm);
		}else {
			
			
			//Chain of responsibility logic
			
			atm.setBalance(atm.getBalance()-amount);
			card.getAccount().updateBalance(-amount);
			
			WithdrawHandler withdrawHandler = new TwoThousandWithdrawHandler(new FiveHundredWithdrawHandler(new HundredWithdrawHandler(null)));
			withdrawHandler.withdraw(atm, amount);
			
			exit(atm);
			
		}
		
	}

	@Override
	public void depositCash(ATM atm, Card card, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkBalance(ATM atm, Card card, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePIN(ATM atm, Card card, int pin) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

class checkBalanceAmount implements ATMState{

	@Override
	public void insertCard(ATM atm, Card card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void authenticatePIN(ATM atm, Card card, int pin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exit(ATM atm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returnCard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectOperation(ATM atm, Card card, TransactionType transactionType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdrawCash(ATM atm, Card card, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositCash(ATM atm, Card card, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkBalance(ATM atm, Card card, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePIN(ATM atm, Card card, int pin) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

abstract class WithdrawHandler{
	
	private WithdrawHandler nextWithDrawHandler;
	
	public WithdrawHandler(WithdrawHandler withdrawHandler) {
		this.nextWithDrawHandler = withdrawHandler;
	}
	
	public void withdraw(ATM atm, int amount) {
		
		if(nextWithDrawHandler!=null) {
			nextWithDrawHandler.withdraw(atm,amount);
		}else {
			System.out.println("Cannot handle");
		}
		
	}
	
	
}

class TwoThousandWithdrawHandler extends WithdrawHandler{

	public TwoThousandWithdrawHandler(WithdrawHandler withdrawHandler) {
		super(withdrawHandler);
	}
	
	public void withdraw(ATM atm, int amount) {
		
		int required = amount / 2000;
 		int balance = amount % 2000;
 		
 		if(required<=atm.getTwoThousandNotes()) {
 			atm.setTwoThousandNotes(atm.getTwoThousandNotes()-required);
 		}else {
 			balance+= (required-atm.getTwoThousandNotes())*2000;
 			atm.setTwoThousandNotes(0);
 		}
 		
 		if(balance>0) {
 			
 			super.withdraw(atm, balance);
 			
 		}
		
	}
	
	
}

class FiveHundredWithdrawHandler extends WithdrawHandler{

	public FiveHundredWithdrawHandler(WithdrawHandler withdrawHandler) {
		super(withdrawHandler);
	}
	
	public void withdraw(ATM atm, int amount) {
		
		int required = amount / 500;
 		int balance = amount % 500;
 		
 		if(required<=atm.getFiveHundredNotes()) {
 			atm.setFiveHundredNotes(atm.getFiveHundredNotes()-required);
 		}else {
 			balance+= (required-atm.getFiveHundredNotes())*500;
 			atm.setFiveHundredNotes(0);
 		}
 		
 		if(balance>0) {
 			
 			super.withdraw(atm, balance);
 			
 		}
		
	}
	
	
}

class HundredWithdrawHandler extends WithdrawHandler{

	public HundredWithdrawHandler(WithdrawHandler withdrawHandler) {
		super(withdrawHandler);
	}
	
	public void withdraw(ATM atm, int amount) {
		
		int required = amount / 100;
 		int balance = amount % 100;
 		
 		if(required<=atm.getHundredNotes()) {
 			atm.setHundredNotes(atm.getHundredNotes()-required);
 		}else {
 			balance+= (required-atm.getHundredNotes())*100;
 			atm.setHundredNotes(0);
 		}
 		
 		if(balance>0) {
 			
 			super.withdraw(atm, balance);
 			
 		}
		
	}
	
	
}

