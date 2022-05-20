package concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

//@Aspect
public class AudienceWithoutNote {

//    @Before("execution(* concert.Performance.perform(..)))")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

//    @Before("execution(* concert.Performance.perform(..)))")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

//    @AfterReturning("execution(* concert.Performance.perform(..)))")
    public void c() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

//    @AfterThrowing("execution(* concert.Performance.perform(..)))")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }

//    @Pointcut("execution(* concert.Performance.perform(..)))")
//    public void performance() {
//
//    }
//
//    public void watchPerformance(ProceedingJoinPoint proceedingJoinPoint) {
//        try{
//            System.out.println("Silencing cell phones");
//            System.out.println("Taking seats");
//            proceedingJoinPoint.proceed();
//            System.out.println("CLAP CLAP CLAP!!!");
//        }catch (Throwable e){
//            System.out.println("Demanding a refund");
//        }
//    }
}
