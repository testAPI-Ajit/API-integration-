package in.kpmg.iocl;

import in.kpmg.iocl.controller.TestController;
import in.kpmg.iocl.dto.ApiResponse2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@SpringBootApplication
//@EnableScheduling
public class IoclApplication {

//    @Scheduled(cron = "0 0 0 * * *",zone = "Indian/Maldives")
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(IoclApplication.class, args);

        TestController fetchController = context.getBean(TestController.class);

        List<ApiResponse2> fetchResult = null;

        try {
            fetchResult = fetchController.fetchdetails();
            System.out.println("execution response:: \n " + fetchResult);
        } catch (Exception e) {
            System.out.println("Exception in Main of iocl.. " + e.getMessage());
        }

        if (fetchResult != null) {
            stopApplication(context);
        } else {
            System.out.println("response is null from APIs execution...!!");
        }
    }

    private static void stopApplication(ApplicationContext context) {

        SpringApplication.exit(context);
        System.out.println("Application closed..!!");
    }

}



