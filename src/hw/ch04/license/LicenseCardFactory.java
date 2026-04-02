package hw.ch04.license;
import hw.ch04.framework.Factory;
import hw.ch04.framework.Product; 
public class LicenseCardFactory extends Factory {
    private int licenseCounter; 
    private String baseDate;
    public LicenseCardFactory(String baseDate){
        //생성자
        this.baseDate = baseDate;
        licenseCounter = 100; 

    }
    @Override
    public Product createProduct(String owner){
        return new LicenseCard(owner,licenseCounter++,baseDate,"2031-03-19");
    }
    @Override
    public void registerProduct(Product product){
        System.out.println(product+"을 등록했습니다.");
    }
}
