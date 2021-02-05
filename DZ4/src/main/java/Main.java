public class Main {
    public static void main(String[] args) {
        String salaryRecords = "Petrov,Salary\nJohn Smith,9999";
        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource("OutputTest.txt")));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("OutputTest.txt");

        System.out.println(salaryRecords);
        System.out.println(plain.readData());
        System.out.println(encoded.readData());
    }
}
