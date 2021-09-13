package classnew;

import classnew.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired ClassRepository classRepository;

    /* 원래 없엇어 아래주석은
     @StreamListener(KafkaProcessor.INPUT)
    public void wheneverClassCanceled_UpdateStatus(@Payload ClassCanceled classCanceled){

        if(!classCanceled.validate()) return;

        System.out.println("\n\n##### listener UpdateStatus : " + classCanceled.toJson() + "\n\n");

        // Sample Logic //
        // Reservation reservation = new Reservation();
        // reservationRepository.save(reservation);

        Class tmp = classRepository.findById(classCanceled.getClassId()).get();
        tmp.setApplyStatus("===cancel class --- Reservation Complete===");
        classRepository.save(tmp);

    }*/

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCourseDeleted_ClassDelete(@Payload CourseDeleted courseDeleted){

        if(!courseDeleted.validate()) return;

        System.out.println("\n\n##### listener ClassDelete : " + courseDeleted.toJson() + "\n\n");

        // Sample Logic //
        // Class class = new Class();
        // classRepository.save(class);

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}