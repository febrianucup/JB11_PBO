import backend.dbHelper;

public class App {
    public static void main(String[] args) throws Exception {
        dbHelper conn = new dbHelper();

        conn.bukaKoneksi();
    }
}
