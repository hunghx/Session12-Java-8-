package ra.inf;

public interface IOFile {
    void inputData(); // nhập vào dữ liệu
    void displayData(); // in ra dữ liệu
    // phương thức tĩnh
    static void printf(){
        System.out.println("hello world");
    };

    // phương thức mặc định
    default int sum(int a, int b){
        return a+b;
    }
}
