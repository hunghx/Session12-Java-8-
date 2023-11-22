package ra.inf;

@FunctionalInterface
public interface Animals {
    int a =10;
    String move(String s); // 2 thành phần : kiểu trả về với tham số
    default void makeSound(){
  };
}
