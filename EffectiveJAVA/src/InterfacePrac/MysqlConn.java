package InterfacePrac;

public class MysqlConn implements IDBConnect {

	@Override
	public void connect() {
		System.out.println("MySQL Interface Connect");
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.println("MySQL Interface Open");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("MySQL Interface Close");
	}

}
