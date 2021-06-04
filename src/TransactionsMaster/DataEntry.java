package TransactionsMaster;

/**
 * TODO Put here a description of what this class does.
 *
 * @author deepa.
 *         Created May 26, 2021.
 */
public class DataEntry
{
    private String AccountName;
    private double DebitValue,CreditValue;
	private double TotalValue;
	private char side;
    private String AliasName;
    /**
	 * Returns the value of the field called 'totalValue'.
	 * @return Returns the totalValue.
	 */
	public double getTotalValue() {
		return this.TotalValue;
	}

	/**
	 * Returns the value of the field called 'debitValue'.
	 * @return Returns the debitValue.
	 */
	public double getDebitValue() {
		return this.DebitValue;
	}

	/**
	 * Sets the field called 'debitValue' to the given value.
	 * @param debitValue The debitValue to set.
	 */
	public void setDebitValue(double debitValue) {
		this.DebitValue = debitValue;
		this.TotalValue = debitValue;
	}

	/**
	 * Returns the value of the field called 'creditValue'.
	 * @return Returns the creditValue.
	 */
	public double getCreditValue() {
		return this.CreditValue;
	}

	/**
	 * Sets the field called 'creditValue' to the given value.
	 * @param creditValue The creditValue to set.
	 */
	public void setCreditValue(double creditValue) {
		this.CreditValue = creditValue;
		this.TotalValue = creditValue;
	}


    
    /**
	 * Returns the value of the field called 'accountName'.
	 * @return Returns the accountName.
	 */
	public String getAccountName() {
		return this.AccountName;
	}

	/**
	 * Sets the field called 'accountName' to the given value.
	 * @param accountName The accountName to set.
	 */
	public void setAccountName(String accountName) {
		this.AccountName = accountName;
	}

	/**
	 * Returns the value of the field called 'side'.
	 * @return Returns the side.
	 */
	public char getSide() {
		return this.side;
	}

	/**
	 * Sets the field called 'side' to the given value.
	 * @param side The side to set.
	 */
	public void setSide(char side) {
		this.side = side;
	}

	/**
	 * Returns the value of the field called 'aliasName'.
	 * @return Returns the aliasName.
	 */
	public String getAliasName() {
		return this.AliasName;
	}

	/**
	 * Sets the field called 'aliasName' to the given value.
	 * @param aliasName The aliasName to set.
	 */
	public void setAliasName(String aliasName) {
		this.AliasName = aliasName;
	}

	public DataEntry(String AccountName, double debit,double credit)
    {
       this.AccountName = AccountName;
       this.DebitValue= debit;
       this.CreditValue=credit;
    }
}
