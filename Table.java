public class Table {
	
	char row, col;
	String prod;
	
	public Table(char row, char col, String prod)
	{
		this.row = row;
		this.col = col;
		this.prod = prod;
	}
	
	public char getRow()
	{
		return row;
	}
	
	public char getCol()
	{
		return col;
	}
	
	public String getProd()
	{
		return prod;
	}
	
}
