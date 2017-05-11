package db;

public class DbException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DbException(){
		super();
	}
	
	public DbException(String msg){
		super(msg);
	}
	
}
