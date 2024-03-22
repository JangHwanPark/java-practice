package JavaConstructors;

// (Student) 생성자 오버로딩
public class ConstructorsEx_02 {
    private String name;
    private String studentNumber;
    private String department;
    private int admissionYear;
    private String email;

    // 이름, 학번만 받는 생성자
    public ConstructorsEx_02(String name, String studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

    // 이름, 학번, 학과를 받는 생성자
    public ConstructorsEx_02(String name, String studentNumber, String department) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.department = department;
    }

    // 이름, 학번, 학과, 입학년도를 받는 생성자
    public ConstructorsEx_02(String name, String studentNumber, String department, int admissionYear) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.department = department;
        this.admissionYear = admissionYear;
    }

    // 이름, 학번, 학과, 입학년도, 이메일을 받는 생성자
    public ConstructorsEx_02(String name, String studentNumber, String department, int admissionYear, String email) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.department = department;
        this.email = email;
    }

    // 이름에 대한 게터와 세터
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 학번에 대한 게터와 세터
    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    // 학과에 대한 게터와 세터
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // 입학년도에 대한 게터와 세터
    public int getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
    }

    // 이메일에 대한 게터와 세터
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void main(String[] args) {
        ConstructorsEx_02 student = new ConstructorsEx_02("Name", "i240101", "컴퓨터공학", 2024, "name@ansan.ac.kr");

        // 게터를 사용해 학생 정보 출력
        System.out.println("학생 정보");
        System.out.println("이름: " + student.getName());
        System.out.println("학번: " + student.getStudentNumber());
        System.out.println("학과: " + student.getDepartment());
        System.out.println("입학년도: " + student.getAdmissionYear());
        System.out.println("이메일: " + student.getEmail());

        // 세터를 사용해 일부 정보 수정
        student.setName("i240101");
        student.setEmail("i240101@ansan.ac.kr");

        // 수정된 학생 정보 출력
        System.out.println("\n수정된 학생 정보");
        System.out.println("이름: " + student.getName());
        System.out.println("이메일: " + student.getEmail());
    }
}