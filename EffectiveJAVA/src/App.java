import InterfacePrac.MysqlConn;
import InterfacePrac.OracleConn;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int servingSize = 240;
//		int servings = 8;
//		BuilderPattern cola = new BuilderPattern.Builder(servingSize, servings).build();
		
		MysqlConn mysql = new MysqlConn();
		mysql.connect();
		mysql.open();
		mysql.close();
		
		OracleConn oracle = new OracleConn();
		oracle.connect();
		oracle.open();
		oracle.close();
	}

}
