package TransactionsMaster;

import java.sql.Date;
class ObjectForData
{
	String TTYPE;
	protected String getTTYPE() {
		return this.TTYPE;
	}
	/**
	 * Sets the field called 'tTYPE' to the given value.
	 * @param tTYPE The tTYPE to set.
	 */
	protected void setTTYPE(String tTYPE) {
		this.TTYPE = tTYPE;
	}
	/**
	 * Returns the value of the field called 'tDATE'.
	 * @return Returns the tDATE.
	 */
	protected Date getTDATE() {
		return this.TDATE;
	}
	/**
	 * Sets the field called 'tDATE' to the given value.
	 * @param tDATE The tDATE to set.
	 */
	protected void setTDATE(Date tDATE) {
		this.TDATE = tDATE;
	}
	/**
	 * Returns the value of the field called 'tDOC'.
	 * @return Returns the tDOC.
	 */
	protected Integer getTDOC() {
		return this.TDOC;
	}
	/**
	 * Sets the field called 'tDOC' to the given value.
	 * @param tDOC The tDOC to set.
	 */
	protected void setTDOC(Integer tDOC) {
		this.TDOC = tDOC;
	}
	/**
	 * Returns the value of the field called 'tCODE'.
	 * @return Returns the tCODE.
	 */
	protected String getTCODE() {
		return this.TCODE;
	}
	/**
	 * Sets the field called 'tCODE' to the given value.
	 * @param tCODE The tCODE to set.
	 */
	protected void setTCODE(String tCODE) {
		this.TCODE = tCODE;
	}
	/**
	 * Returns the value of the field called 'nAME'.
	 * @return Returns the nAME.
	 */
	protected String getNAME() {
		return this.NAME;
	}
	/**
	 * Sets the field called 'nAME' to the given value.
	 * @param nAME The nAME to set.
	 */
	protected void setNAME(String nAME) {
		this.NAME = nAME;
	}
	/**
	 * Returns the value of the field called 'tDBCR'.
	 * @return Returns the tDBCR.
	 */
	protected Character getTDBCR() {
		return this.TDBCR;
	}
	/**
	 * Sets the field called 'tDBCR' to the given value.
	 * @param tDBCR The tDBCR to set.
	 */
	protected void setTDBCR(Character tDBCR) {
		this.TDBCR = tDBCR;
	}
	/**
	 * Returns the value of the field called 'tNAR1'.
	 * @return Returns the tNAR1.
	 */
	protected String getTNAR1() {
		return this.TNAR1;
	}
	/**
	 * Sets the field called 'tNAR1' to the given value.
	 * @param tNAR1 The tNAR1 to set.
	 */
	protected void setTNAR1(String tNAR1) {
		this.TNAR1 = tNAR1;
	}
	/**
	 * Returns the value of the field called 'tAMT'.
	 * @return Returns the tAMT.
	 */
	protected Double getTAMT() {
		return this.TAMT;
	}
	/**
	 * Sets the field called 'tAMT' to the given value.
	 * @param tAMT The tAMT to set.
	 */
	protected void setTAMT(Double tAMT) {
		this.TAMT = tAMT;
	}
	/**
	 * Returns the value of the field called 'c_DATE'.
	 * @return Returns the c_DATE.
	 */
	protected Date getC_DATE() {
		return this.C_DATE;
	}
	/**
	 * Sets the field called 'c_DATE' to the given value.
	 * @param c_DATE The c_DATE to set.
	 */
	protected void setC_DATE(Date c_DATE) {
		this.C_DATE = c_DATE;
	}
	Date TDATE;
	Integer TDOC;
	String TCODE;
	String NAME;
	Character TDBCR;
	String TNAR1;
	Double TAMT;
	Date C_DATE;
	public ObjectForData()
	{
		
	}
}
