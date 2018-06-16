package message;

import java.io.Serializable;

/**
 * This is a class for sending message of failure after error taking place, including two constructor and one setting function
 * 
 */

public class Fail_Message implements Serializable{

	private static final long serialVersionUID = 1L;
	private String statement;
	
	/**
	 *Constructor Success_Message()
	 *@param nothing
	 *statement = "Status Not Defined"; 
	 *@return nothing
	 */
	public Fail_Message() {
		statement = "Status Not Defined";
	}

	
	/**
	 * Constructor Success_Message(input_statement);
	 * @param input_statement
	 * the statement = input_statement
	 * 	 *@return nothing
	 */
	public Fail_Message(String input_statement) {
		this.statement = input_statement;
	}
	
	/**
	 * Function setStatement(input_statement);
	 * @param input_statement
	 * the statement = input_statement
	 * @return nothing
	 */
	public void setStatement(String input_statement) {
		this.statement = input_statement;
	}
}