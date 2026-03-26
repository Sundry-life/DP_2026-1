package practice.ch04.framework;
public abstract class Factory {
    //제품 생산 방식을 정의하는 메소드 
    public final Product create(String owner) {
        //
        Product p = createProduct(owner);  //<-추상메소드 들어감 = 즉 템플릿 메소드 //제품 생산
        registerProduct(p); //제품 등록 
        return p;
    }
    //팩토리 메소드
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);
}
