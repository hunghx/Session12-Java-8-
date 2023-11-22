package ra;

import ra.inf.Animals;
import ra.inf.IOFile;
import ra.model.Calculator;
import ra.model.Person;
import ra.model.Student;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // phương thức mặc định
        // khởi tạo đối tượng student
        Student student = new Student();
        System.out.println(student.sum(2,3));
//        student.printf();

        IOFile.printf();

        Animals animals = (s)->null; // biểu thức lamda phải có
        // dạng tương tự phương thức trừu tượng duy nhất của functional interface

        List<Student> studentList  = Arrays.asList(new Student(1,"Nguyễn Văn A",19),
                new Student(2,"Nguyễn Văn B",18),
                new Student(3,"Nguyễn Văn C",21));

        //sắp xếp theo tuổi tăng dần
        // cách 1 : compareable
        // cách 2 : comparator
        Comparator<Student> comparator = (o1,o2)->o1.getAge()-o2.getAge();
        Collections.sort(studentList,comparator);

        System.out.println(studentList);
        // khởi tạo đối tượng Calculator

        Calculator cal = new Calculator();

///   4 loại functional interface
        // Consumer : void accept(T t)
        Consumer<Integer> consumer = (t)-> System.out.println(t);
        // Function  : R apply(T t)
        Function<Student, Person> function = (s)->new Person(s.getStudentName());
        // Predicate :  boolean test(T t);
        Predicate<Student> predicate = cal::isEnoughThan18;
        // Supplier :    T get();
        Supplier<Integer> supplier= ()->new Random().nextInt(100);


        // Stream
       // bài toán 1
//        hãy tính tổng của mảng sau
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        // ứng dụng stream
        IntStream intStream = Arrays.stream(arr); // 1,2,3,4,5,6,7,8,9,10
        int total= intStream.sum();
        System.out.println("Sum : "+total);
        // tính tích
        int mul = Arrays.stream(arr)
                .reduce(1,(multi,currentValue)->multi*currentValue); // tích lũy giá trị theo phép toán trả về
        System.out.println("Tích :"+mul);

        // ứng dụng  :
        // lọc dữ liệu
        List<String> names=Arrays.asList("Hùng","Hà","Nam","Mạnh","Khánh","Đức","Huy","Long","Nhã");
        // hãy lọc và đếm xem có bao nhiêu học sinh có chữ H đầu tiên
//        List<String> listSearch = names.stream().filter(str->str.startsWith("H")).collect(Collectors.toList());
        long count = names.stream()
                .filter(str->str.startsWith("H")) // lọc các phần tử có kí tự H đầu tiên
                .count(); // đếm số lượng phần tử trong stream hiện tại
        System.out.println(count);
        // hãy in ra các tên có kí tự 'h' trong tên dưỡi dạng in hoa
        names.forEach(s ->{ // duyệt qua lần lượt các phần tử của list
            if(s.toLowerCase().contains("h")){
                System.out.println(s.toUpperCase());
            }
        } );
        // hãy chuyển đổi danh sách học sinh thành 1 danh sách người

        List<Person> personList = studentList.stream() // chuyển danh sách thành 1 stream mới
                .map(s->new Person(s.getStudentName())) // tạo ra 1 stream mới gồm nhưngx đối tượng Person có tên là tên của học sinh
                .collect(Collectors.toList()); // chuyển stream thânhf danh sách
        System.out.println(personList);

        // hãy tạo 1000 số ngẫu nhiên từ 1-9999 không trùng lặp;
//        Random ran = new Random();
//        List<Integer> randomInt= Stream.generate(()->ran.nextInt(9998)+1) // tạo ngẫu nhiên
//                .distinct()   // loại bỏ các phần tử trùng lặp
//                .limit(1000) // lấy giới hạn số lượng phần tử
//                .sorted(Calculator::minus) // sắp sếp theo chièu giảm dần
//                .collect(Collectors.toList()); // chuyển stream thành 1  danh sách
//        System.out.println(randomInt);
//        System.out.println(randomInt.size());

        // tạo ra danh sách người từ danh sách tên (method references)
        List<Person> people = names.stream().map(Person::new)
                .collect(Collectors.toList());
        System.out.println(people);
        // date time - ngày tháng, giờ
        LocalDate localDate = LocalDate.now(); // thời gian hiện tại
        LocalDate localDate1 = LocalDate.of(1945,9,2);
        System.out.println("ngày hôm nay là "+localDate);
        System.out.println("ngày tuyên ngôn độc lập là "+localDate1);

        // ngày quốc khánh 100 năm sau
        LocalDate localDate2 = localDate1.plus(100, ChronoUnit.YEARS);
        System.out.println("ngày quốc khánh 100 năm sau "+localDate2);

        // lấy thời gian
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(localTime.format(dft));
        // lấy ngày tháng năm và giờ phút giây
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

        // ép từ 1 chuỗi về ngày tháng năm (LocalDate)
//        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
//        final LocalDate dt = dtf.parseLocalDate("1996-06-18");
//        System.out.println(localDate);
        // Zoned đại diện cho múi giờ trên thế giới
        ZonedDateTime zonedDateTimeJapan = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Ngày giờ của tokyo là "+ zonedDateTimeJapan);


        // cho danh sách các số nguyên
        int[] intArr ={1,3,6,7,9};
        // hãy tính tổng các số chẵn trong danh sách, nếu không có số chẵn nào thì trả về 0
        OptionalInt optionalInt = Arrays.stream(intArr).filter(a->a%2==0).reduce((total1, current)->total+current);
//        int sumEven = optionalInt.orElse(0); // sẽ trả về tổng nếu tồn tại phần tử chẵn , nếu không sẽ trả về 0;
//        System.out.println(sumEven);
        optionalInt.ifPresent(tol->{ // nếu tồn tại thì xử lí
            System.out.println(tol);
        });

    }


}
