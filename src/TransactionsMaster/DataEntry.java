package TransactionsMaster;

import java.sql.Date;

/**
 * TODO Put here a description of what this class does.
 *
 * @author deepa. Created May 26, 2021.
 */
public class DataEntry {
	private String Narration;

	/**
	 * Returns the value of the field called 'narration'.
	 * 
	 * @return Returns the narration.
	 */
	public String getNarration() {
		return this.Narration;
	}

	/**
	 * Sets the field called 'narration' to the given value.
	 * 
	 * @param narration The narration to set.
	 */
	public void setNarration(String narration) {
		this.Narration = narration;
	}

	private double totalBalance;

	/**
	 * Returns the value of the field called 'totalBalance'.
	 * 
	 * @return Returns the totalBalance.
	 */
	public  double getTotalBalance() {
		return totalBalance;
	}
	private int transID;
	/**
	 * Returns the value of the field called 'transID'.
	 * @return Returns the transID.
	 */
	public int getTransID() {
		return this.transID;
	}

	/**
	 * Sets the field called 'transID' to the given value.
	 * @param transID The transID to set.
	 */
	public void setTransID(int transID) {
		this.transID = transID;
	}

	private Date TransactionDate;
	private String AccountName;
	private double DebitValue, CreditValue;
	private double TotalValue;
	private char Side;
	private String Type;
	private String sideDBCR;
	/**
	 * Returns the value of the field called 'sideDBCR'.
	 * @return Returns the sideDBCR.
	 */
	public String getSideDBCR() {
		return this.sideDBCR;
	}

	/**
	 * Sets the field called 'sideDBCR' to the given value.
	 * @param sideDBCR The sideDBCR to set.
	 */
	private void setSideDBCR(String sideDBCR) {
		this.sideDBCR = sideDBCR;
	}

	private String AliasName;

	/**
	 * Returns the value of the field called 'totalValue'.
	 * 
	 * @return Returns the totalValue.
	 */
	public DataEntry() {

	}

	/**
	 * Returns the value of the field called 'type'.
	 * 
	 * @return Returns the type.
	 */
	public String getType() {
		return this.Type;
	}

	/**
	 * Sets the field called 'type' to the given value.
	 * 
	 * @param type The type to set.
	 */
	public void setType(String type) {
		this.Type = type;
	}

	public double getTotalValue() {
		return this.TotalValue;
	}

	public void setTotalValue(String side, double TotalValue) {
		this.Side = side.charAt(0);
		this.TotalValue = TotalValue;
		if (this.Side == 'C') {
			CreditValue = TotalValue;
		}
		if (this.Side == 'D') {
			DebitValue = TotalValue;
		}
	}

	/**
	 * Sets the field called 'transactionDate' to the given value.
	 * 
	 * @param transactionDate The transactionDate to set.
	 */
	public void setTransactionDate(Date transactionDate) {
		this.TransactionDate = transactionDate;
	}

	/**
	 * Returns the value of the field called 'transactionDate'.
	 * 
	 * @return Returns the transactionDate.
	 */
	public Date getTransactionDate() {
		return this.TransactionDate;
	}

	/**
	 * Returns the value of the field called 'debitValue'.
	 * 
	 * @return Returns the debitValue.
	 */
	public double getDebitValue() {
		return this.DebitValue;
	}

	/**
	 * Sets the field called 'debitValue' to the given value.
	 * 
	 * @param debitValue The debitValue to set.
	 */
	public void setDebitValue(double debitValue) {
		this.DebitValue = debitValue;
		this.TotalValue = debitValue;
	}

	/**
	 * Returns the value of the field called 'creditValue'.
	 * 
	 * @return Returns the creditValue.
	 */
	public double getCreditValue() {
		return this.CreditValue;
	}

	/**
	 * Sets the field called 'creditValue' to the given value.
	 * 
	 * @param creditValue The creditValue to set.
	 */
	public void setCreditValue(double creditValue) {
		this.CreditValue = creditValue;
		this.TotalValue = creditValue;
	}

	/**
	 * Returns the value of the field called 'accountName'.
	 * 
	 * @return Returns the accountName.
	 */
	public String getAccountName() {
		return this.AccountName;
	}

	/**
	 * Sets the field called 'accountName' to the given value.
	 * 
	 * @param accountName The accountName to set.
	 */
	public void setAccountName(String accountName) {
		this.AccountName = accountName;
	}

	/**
	 * Returns the value of the field called 'side'.
	 * 
	 * @return Returns the side.
	 */
	public char getSide() {
		return this.Side;
	}

	/**
	 * Sets the field called 'side' to the given value.
	 * 
	 * @param side The side to set.
	 */
	public void setSide(char Side) {
		this.Side = Side;
	}

	/**
	 * Returns the value of the field called 'aliasName'.
	 * 
	 * @return Returns the aliasName.
	 */
	public String getAliasName() {
		return this.AliasName;
	}

	/**
	 * Sets the field called 'aliasName' to the given value.
	 * 
	 * @param aliasName The aliasName to set.
	 */
	public void setAliasName(String aliasName) {
		this.AliasName = aliasName;
	}

	public DataEntry(String AccountName, double debit, double credit) {
		this.AccountName = AccountName;
		this.DebitValue = debit;
		this.CreditValue = credit;
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param side
	 * @param amount
	 */
	public void setBalance(double amount) {
		totalBalance = amount;
		if(totalBalance>0)
		{
			setSideDBCR("DR");
		}
		if(totalBalance<0)
		{
			setSideDBCR("CR");
		}
	}

}
