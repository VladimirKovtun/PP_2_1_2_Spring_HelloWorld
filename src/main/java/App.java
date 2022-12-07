import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloworld");
        HelloWorld bean2 = (HelloWorld) applicationContext.getBean("helloworld");
        bean2.setMessage("Oops");
        System.out.println("bean - " + bean.getMessage());
        System.out.println("bean 2 - " + bean2.getMessage());
        System.out.print(bean == bean2);
        System.out.println("   <-  Singleton scope.");

        System.out.println("------------------------");

        Cat murzik = applicationContext.getBean("cat", Cat.class);
        System.out.println("murzik says - " + murzik.getVoice());
        Cat barsik = applicationContext.getBean("cat", Cat.class);
        barsik.setVoice("Murrrrr");
        System.out.println("barsik says - " + barsik.getVoice());
        System.out.print(murzik == barsik);
        System.out.print("   <-  Prototype scope.");
    }
}