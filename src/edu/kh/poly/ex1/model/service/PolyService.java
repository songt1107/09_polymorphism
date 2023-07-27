package edu.kh.poly.ex1.model.service;

import edu.kh.poly.ex1.model.vo.Car;
import edu.kh.poly.ex1.model.vo.Spark;
import edu.kh.poly.ex1.model.vo.Tesla;

public class PolyService {

	public void ex1() {
		// 다형성 확인 예제
		
		// Car 객체 생성
		Car car = new Car();
		// 부모타입 참조변수 = 부모객체
		
		// Tesla 객체 생성
		Tesla tesla = new Tesla();
		// 자식타입 참조변수 = 자식객체
		
		// ************다형성************
		Car car2 = new Tesla(); // 오류 발생 안함
		// Tesla 객체를 참조하는 변수의 타입이 Car(부모)이기 때문에
		// Tesla 객체가 Car(부모) 객체로 변화함.
		
		Car car3 = new Spark();
		
		// 부모타입 참조변수 = 자식객체
		
		// ****** 다형성(업캐스팅) 작성방법 ******
		// 1) 자식 객체가 부모 객체로 변하였기 때문에
		//    자식만의 고유한 필드, 메소드를 사용할 수 없다.
		
		// 1-1) car (부모 = 부모)
		car.setEngine("v6 6기통 엔진");
		car.setFuel("휘발유");
		car.setWheel(4);
		// Car 메소드 모두 사용 가능
		
		// 1-2) tesla (자식 = 자식)
		tesla.setEngine("전기모터");
		tesla.setFuel("전기");
		tesla.setWheel(4);
		tesla.setBatteryCapacity(1000000);
		// Tesla 메소드 모두 사용 가능
		
		// 1-3 ) car2 (부모 = 자식(Tesla))
		car2.setEngine("전기모터");
		car2.setFuel("전기");
		car2.setWheel(4);
		//car2.setBatteryCapacity(1000000);
		//The method setBatteryCapacity(int) is undefined for the type Car
		//자식이 부모 흉내낼땐 부모 것만 사용 가능
		
		car3.setEngine("경차 엔진");
		car3.setFuel("휘발유");
		car3.setWheel(4);
		//car3.setDiscountoffer(0.5);
		//The method setDiscountoffer(double) is undefined for the type Car
		
		
		// ------------------------------------------------------
		
		// 2) 다형성을 이용한 객체 배열
		
		// 객체 배열 : 같은 객체 참조 자료형의 변수를 하나의 묶음으로 다루는 것
		 		  // 부모타입 참조 자료형의 변수를 하나의 묶음으로 다루는 것
		
		Car[] arr = new Car[3]; // 부모타입 참조변수 배열 선언 및 할당
		// 각 배열 요소가 Car 타입 참조변수
		
		arr[0] = car; // Car 주소
		
		arr[1] = car2; // Tesla 주소
		
		arr[2] = car3; // Spark 주소
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(i + "번째 인덱스의 엔진 " + arr[i].getEngine());
		}
		
		// 상속 + 다형성
		// 상속 특징 : Car 상속클래스는 모두 getEngine()을 가지고있다를 정의
		// 다형성 (업캐스팅) : 부모타입 참조변수 arr[i]로 자식 객체를 참조할 수 있다.
		
		
	}
	
	
	public void ex2() {
		
		// 3) 다형성(업캐스팅)을 이용한 매개변수 사용법
		Tesla t = new Tesla("전기모터", "전기", 4, 1000000);
		
		Spark s = new Spark("경차 엔진", "휘발유", 4, 0.5);
		
		Car c = new Car("경유엔진", "경유", 12);
		
		printCar(t);
		printCar(s);
		printCar(c);
		
		System.out.println("------------------------------------");
		
		// 4) 다형성을 이용한 반환형 사용법
		//Car[] arr = { new Car(), new Tesla(), new Spark() };
		
		Car[] arr = { createCar(1), createCar(2), createCar(3) };
					//	  Car		 // Car			// Car
									 // (Tesla)		// (Spark)
		
		// arr[0]; //Car
		// arr[1]; //Tesla
		// arr[2]; //Spark
		
		// instanceof 연산자 : 객체의 자료형을 검사하는 연산자
		// -> 참조하는 객체가 특정 자료형이거나 부모쪽 상속관계인지 확인
		
		System.out.println( arr[1] instanceof Tesla ); // true
		System.out.println( arr[1] instanceof Spark ); // false
		System.out.println( arr[1] instanceof Car ); // true
		
	}
	
	// 전달받은 Car 또는 자식 객체의 엔진, 연료, 바퀴 개수를 출력하는 메서드
	// 매개변수에 부모타입 참조변수를 작성하면 모든 자식 객체를 전달받을 수 있다.
	public void printCar(Car temp) {
		// 부모타입 참조변수 = 자식타입객체
		// 다형성의 업캐스팅 모양과 똑같다.
		// temp에는 Tesla, Spark, Car 의 주소가 넘어와도 된다 (업캐스팅)
		System.out.println("엔진 : " + temp.getEngine());
		System.out.println("연료 : " + temp.getFuel());
		System.out.println("바퀴 개수 : " + temp.getWheel());
		
		
	}
	
	public Car createCar(int num) {
		
		Car result = null;
		
		switch(num) {
			case 1 : result = new Car(); break;
			case 2 : result = new Tesla(); break;
			case 3 : result = new Spark(); break;
		}
		
		return result;
	}
	
	
}
