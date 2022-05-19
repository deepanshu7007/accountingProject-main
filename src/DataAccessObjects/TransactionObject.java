package DataAccessObjects;

import java.util.Date;

public class TransactionObject {
String TransactionType;
String TransactionDoc;
Date TransactionDate;
int TransactionCode;
String TransactionName;
String TransactionNarration;
char TransactionDebitCredit;
float TransactionAmount;
public String getTransactionType() {
	return TransactionType;
}
public void setTransactionType(String transactionType) {
	TransactionType = transactionType;
}
public TransactionObject(String transactionType, String transactionDoc, Date transactionDate, int transactionCode,
		String transactionName, String transactionNarration, char transactionDebitCredit, float transactionAmount) {
	super();
	TransactionType = transactionType;
	TransactionDoc = transactionDoc;
	TransactionDate = transactionDate;
	TransactionCode = transactionCode;
	TransactionName = transactionName;
	TransactionNarration = transactionNarration;
	TransactionDebitCredit = transactionDebitCredit;
	TransactionAmount = transactionAmount;
}
public String getTransactionDoc() {
	return TransactionDoc;
}
public void setTransactionDoc(String transactionDoc) {
	TransactionDoc = transactionDoc;
}
public Date getTransactionDate() {
	return TransactionDate;
}
public void setTransactionDate(Date transactionDate) {
	TransactionDate = transactionDate;
}
public int getTransactionCode() {
	return TransactionCode;
}
public void setTransactionCode(int transactionCode) {
	TransactionCode = transactionCode;
}
public String getTransactionName() {
	return TransactionName;
}
public void setTransactionName(String transactionName) {
	TransactionName = transactionName;
}
public String getTransactionNarration() {
	return TransactionNarration;
}
public void setTransactionNarration(String transactionNarration) {
	TransactionNarration = transactionNarration;
}
public char getTransactionDebitCredit() {
	return TransactionDebitCredit;
}
public void setTransactionDebitCredit(char transactionDebitCredit) {
	TransactionDebitCredit = transactionDebitCredit;
}
public float getTransactionAmount() {
	return TransactionAmount;
}
public void setTransactionAmount(float transactionAmount) {
	TransactionAmount = transactionAmount;
}

}
