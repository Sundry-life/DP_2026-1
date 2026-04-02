package practice.ch06.framework;
public interface Product extends Cloneable { //Cloneable을 상속함 

//public interface Product{ // 상속 안할 경우 //catch문 실행되어서 원인 설명글 출력됨. 그리고 복사도 안됨. 
    public abstract void use(String s);
    public abstract Product createCopy(); //복제 메소드  -> 프로토 타입 핵심 


    //shift +alt+ 화살표 : 그 줄 복제 <- ? 암튼 찾아봐야겠다. 
}
