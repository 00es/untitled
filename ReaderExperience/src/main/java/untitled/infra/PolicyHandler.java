package untitled.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import untitled.config.kafka.KafkaProcessor;
import untitled.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    PointRepository pointRepository;

    @Autowired
    CommentRepository commentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='WorkEdited'"
    )
    public void wheneverWorkEdited_SyncWorkEditToReaderExperiencePolicy(
        @Payload WorkEdited workEdited
    ) {
        WorkEdited event = workEdited;
        System.out.println(
            "\n\n##### listener SyncWorkEditToReaderExperiencePolicy : " +
            workEdited +
            "\n\n"
        );
        // Comments //
        //작품이 수정될 때 리더-작품 소비 컨텍스트에 변경사항을 반영하여 최신 상태를 유지합니다.

        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='WorkCreated'"
    )
    public void wheneverWorkCreated_SyncWorkToReaderExperiencePolicy(
        @Payload WorkCreated workCreated
    ) {
        WorkCreated event = workCreated;
        System.out.println(
            "\n\n##### listener SyncWorkToReaderExperiencePolicy : " +
            workCreated +
            "\n\n"
        );
        // Comments //
        //작품이 생성 또는 수정될 때 리더-작품 소비 컨텍스트에 최신 데이터를 제공하기 위해 Pub/Sub 이벤트를 발행합니다.

        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
