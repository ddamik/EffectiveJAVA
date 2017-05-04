package InterfacePrac;

public class OracleConn implements IDBConnect {
	
	@Override
	public void connect() {
		// TODO Auto-generated method stub
		System.out.println("Oracle Interface Connect");
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.println("Oracle Interface Open");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("Oracle Interface Close");
	}
}
