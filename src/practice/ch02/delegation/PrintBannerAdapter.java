package practice.ch02.delegation;

public class PrintBannerAdapter extends Print{
   private Banner banner;
   public PrintBannerAdapter(String text){
    this.banner = new Banner(text);
   } 
   @Override
   public void printWeak(){
    banner.showWithParen();
   }
   @Override
   public void printStrong(){
    banner.showWithAster();
   }
    
}
