>> DB멘토링 : 김광진(pilot6@naver.com)

● 객체지향프로그래밍(OOP, Object-Oriented Programming) : JAVA

> 객체란?
  세상에 존재하는 유무형의 모든 것.
  사람/동물/사물/장소/상품/주문/배송/느낌/감정 등 개념적인 정의.

  (1) 고유한 속성
  (2) 타인도 알 수 있는 것 
  (3) 사전에 등록된 단어 

  A : "우리 오늘 점심 때 라면 먹을래?"
  B : "응, 그래 좋아"

        라면    --> 객체(o)
  "오뚜기진라면" --> 객체가 구현된 실체(인스턴스:instance)        
------------------------------------------------------------------------------------
> 객체의 '고유한 속성' --> Java에서 어떻게 나타내지?

  - Primitive Type(원시타입/초기타입/기초타입)
    
    정수형(4)

    . byte    ... 8 bit(작은수), 2^8=256 (-128~-1, 0~127)
    . short   ...16 bit(큰수)
    . int     ...32 bit(더큰수)
    . long    ...64 bit(더더큰수)
    
    실수형(2)
    . float   ...32 bit
    . double  ...64 bit
    
    문자형(1)
    . char    ...16 bit 유니코드
   
    불린형(1)
    . boolean ... 1 bit(true, false)

    *비트(bit, binary digit) : 컴퓨터에서 정보를 표시하기 위한 최소 단위(0, 1)
------------------------------------------------------------------------------------
> '속성 + 기능'까지 포함된 객체는 Java에서 어떻게 다루지? ... 클래스(class)

  (1) 사용자 정의 클래스(user-defined class) : Student.java 

  (2) 내장 클래스(built-in class)           : ArrayList / String / Integer / Double / Random / Date / Calendar etc


  학생 : 이름/나이/학과  +  출석하다()/공부하다()/시험보다()
        --------------     ------------------------------
            (속성)                   (기능)

  public class Student {                       // 클래스 이름

    private String name;                       // 클래스 속성:멤버필드:Property
    private int age;

    public Student()                           // 생성자 1
    {
    
    }
    
    public Student(String name, int age)      // 생성자 2
    {
       this.name = name;
       this.age  = age;
    }

    public void setName(String name) {        // 기능:멤버함수:메서드:Operation
       this.name = name;
    }
    
    public void getName() {
       return this.name;
    }

    public void setAge(int age) {
       this.age = age;
    }
    
    public int getAge() {
       return this.age;
    }
  }          
------------------------------------------------------------------------------------
(0) 객체──┐
(1) 고유 속성 --> Primitive Type (초기타입 8가지)
(2) 속성+기능 --> Reference Type (클래스/추상클래스/인터페이스)  

> 추상클래스(Abstract Class)

    (type)          (subtype)
  . 구기종목 : 축구/야구/농구/배구/탁구
  . 가전제품 : TV/냉장고/세탁기/전자렌지
  . 모양     : 세모/네모/동그라미/마름모/별모양
  . 색깔     : 빨강/노랑/파랑/초록/보라
  . 병       : 술병/물병/약병/꽃병

  class C extends A  (o)
  class C extends A,B(x)  -- 자바에서 중복상속 금지. 

------------------------------------------------------------------------------------
> 인터페이스(interface) : 객체들 사이에서 자주 발생하는 동작이나 상태를 정의해 놓은 것.

  😃 <--> 😃
     .talk
     .fight 
------------------------------------------------------------------------------------
  public interface Human {

    public void talk(); //구현부가 없는 함수:추상 메서드(불완전체)
    public void fight();

  }     


  public class Boy implements Human {

    @Override // 재정의, 메서드 오버라이딩
    public void talk()
    {
        System.out.println("Boy is talking.");
    }

    @Override
    public void fight()
    {
        System.out.println("Boy is fighting.");
    }
  }

  public void talk() // 함수 선언부(head)
  {                  // 함수 구현부(body)
    ....
  }
------------------------------------------------------------------------------------
  public interface ITV {

    public void on();
    public void off();
    public void switchChannel(int channel);
  }  
------------------------------------------------------------------------------------
  Tom Crusso : "There is no new thing under the sun." (1923)  
------------------------------------------------------------------------------------
* 인스턴스 : 객체를 토대로 만들어진 실체

  Student s1 = new Student();   (o)
  Human   h1 = new Human();     (x)
  Boy     h1 = new Boy();       (o)
  Human   h2 = new Boy();       (o)

  ex) List list = new ArrayList(); // List는 원래 인터페이스였다.

------------------------------------------------------------------------------------
> 참조타입(Reference Type)이란? ...클래스/추상클래스/인터페이스


  Student.java --> Student.class --> JVM(Java Virtual Machine) --> Java Runtime Data Area

       [1]            [2]            [3]            [4]             [5]
  (Method Area)...(Stack Area)...(Heap Area)...(PC Register)...(Native Method Stack)



  int a = 10;
  Student s1 = new Student();
  
  (Stack Area)............................(Heap Area)
  int a = 10;                             new Student() [0x00012904891023def]
  Student s1 = [0x00012904891023def]

  "참조변수는 힙 영역의 인스턴스 메모리 주소다."
------------------------------------------------------------------------------------
  Student s1 = new Student("Mike",   28);
  Student s2 = new Student("Jack",   25);
  Student s3 = new Student("Bill",   24);
  Student s4 = new Student("John",   26);
  Student s5 = new Student("Steve",  28);

  ArrayList<Student> list = new ArrayList<Student>();
  
  list.add(s1);
  list.add(s2);
  list.add(s3);
  list.add(s4);
  list.add(s5);

  list = {s1, s2, s3, s4, s5}

  for (int i = 0; i < list.size(); i++) {
    
    Student s = list.get(i);
    System.out.println(s.getName());
  }

  for (Student s : list)
  {
    System.out.println(s.getName());
  }
------------------------------------------------------------------------------------
> ArrayList 사용시 주의사항 3가지 

(1) 타입<T>가 생략되면, 기본타입으로 <Object>가 세팅됨. 

  ArrayList list = new ArrayList();
  list.add("a");                          // "a"가 문자열로 저장되는게 아니라, Object로 저장됨.
  String s = (Object) list.get(0); (x)
  String s = (String) list.get(0); (x)    // 형변환이 필요함. 왜죠? 타입을 지정하지 않았기에...

(2) ArrayList<String> list = new ArrayList<>(); // 이게 인정됨? 네!. 타입추론이 인정됨.

(3) int같은 primitive type은 타입<T>으로 사용할 수 없음.

    (x) ArrayList<int> list = new ArrayList<int>();
    (o) ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(new Integer(a));       // boxing 
        list.add(a);                    // autoboxing 
        
        int ... Integer 

        int a = 10;

        Integer num1 = new Integer(a);   // boxing 
        int     num2 = num1.intValue();  // unboxing 
        Integer num3 = a;                // autoboxing 
        int     num4 = num3;             // autounboxing 
------------------------------------------------------------------------------------
[Wrapper Class] : Primitive Type --> Reference Type으로 바꿔주는 클래스
------------------------------------------------------------------------------------
         초기타입(8) ... 참조형 클래스(8)
            byte    ...  Byte
            short   ...  Short
            int     ...  Integer *
            long    ...  Long
            float   ...  Float
            double  ...  Double
            char    ...  Character
            boolean ...  Boolean 
------------------------------------------------------------------------------------
> 자바의 5대 핵심 개념

 (1) 캡슐화(encapsulation) : 속성이나 기능을 넣어서 클래스/추상클래스/인터페이스를 만드는 것.
      
      en(=make) + capsule(?) + tion(명사형 어미)



 (2) 상속(inheritance) : 부모 클래스의 속성을 자식 클래스가 물려 받음
 
 (3) 다형성(polymorphism) : 라틴어(multi)=그리이스어(poly)=영어(many) + morph(형태, form)
     (3.1) 서브타입 다형성(subtype polymorphism)
     (3.2) 매개변수 다형성(parametric polymorphism) : 생성자 오버로딩, 메서드 오버라딩 

 (4) 구현(implementation) : 인터페이스 기능을 자식 클래서 구현함. 

 (5) 직렬화(Serialization) : 네트워크 상에서 전송 효율성을 높이기 위해서 데이터를 byte코드로 바꾸어서 한줄로 세우는 것. 

 
      (1)                                    (2)
       ▩                                     ▩
       ▩        '   '    '   '               ▩
       ▩     '  '   '   '   '  '  '  '       ▩
       ▩    '  '  '  '  '  '  '  '  '  '     ▩
       ▩   '  '  '  '  '  '  '  '   '  '     ▩
     <--- '  '   '   '  '  '  '  '  '  '   <---  ' ' ' ' ' ' ' ' ' ' ' ' ' ' ' ' ' ' ' 
       ▩     '  '  '  '  '  '  '  '  '       ▩          (Serialization 직렬화)
       ▩   '  '  '  '  '  '  '  '  '         ▩
       ▩     '   '   '  '  '  '  '  ''       ▩
       ▩   '   '   '   '   '  '   '  '       ▩
       ▩     '  '  ' '   '  '  '   '         ▩
       ▩         '  '  '  '  '  '            ▩
      (1)                                    (2)

------------------------------------------------------------------------------------
      * 근데, 인스턴스 개수가 엄청나게 많아지면 어떡할래? 정답 : 데이터베이스.

      Student s000001 = new Student("Tomson", 28);
      Student s000002 = new Student("Jack",   25);
      Student s000003 = new Student("Bill",   24);
              .......
      Student s469999 = new Student("Robert", 32);
      Student s470000 = new Student("John",   35);


      회원관리 = {회원1, 회원2, 회원3, 회원4, 회원5, ... } <-- 인스턴스 집합 : Entity 

      회원관리    |  MEMBER_INFO / MEMBERS / T_MEMBER / TB_MEMBER / TBL_MEMBER
      ------------------------------------------------------------------------------------
      회원 아이디    MB_ID VARCHAR2(20) NOT NULL
      회원 비밀번호  MB_PW VARCHAR2(20) NOT NULL
      회원 이름     MB_NAME VARCHAR2(40) NOT NULL 
      회원 이메일   MB_EMAIL VARCHAR(50) NOT NULL
      ------------------------------------------------------------------------------------

      CREATE TABLE MEMBERS (
        MB_ID VARCHAR2(20) NOT NULL,
        MB_PW VARCHAR2(20) NOT NULL,
        MB_NAME VARCHAR2(40) NOT NULL, 
        MB_EMAIL VARCHAR(50) NOT NULL,
        CONSTRAINT PK_MEMBER PRIMARY KEY(MB_ID)
     );

     CREATE TABLE T2 (

        ....
     );

     * 쌤!, 제가 타이핑을 하면서 테이블을 만들고 있습니다.
       손가락이 열라~ 아프구요, 너무 힘듭니다.
       좀 더 편리한 방법이 업떠요? 이떠요! 그게 모죠? 정답 : DB설계툴 !?!? :)

       (1) https://www.erwin.com      (전세계 1위) <--'네카라쿠배당토직야'
       (2) https://www.erdcloud.com   (웹기반)
       (3) https://www.aquerytool.com (국산허접, but~)  
  

    

    