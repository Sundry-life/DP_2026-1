package hw.ch04.idcard;
import hw.ch04.framework.Factory;
import hw.ch04.framework.Product;
public class IDCardFactory extends Factory{
    private int serialCounter; 
    private String baseDate; 
    public IDCardFactory(String baseDate){
        this.baseDate = baseDate; 
    }
    @Override //override한게 protected 생성자는 public
    protected Product createProduct(String owner) { 
        return new IDCard(owner,serialCounter++,baseDate);
    }

    @Override
    protected void registerProduct(Product product) { 
        System.out.println(product + "을 등록했습니다.");
    }
}
