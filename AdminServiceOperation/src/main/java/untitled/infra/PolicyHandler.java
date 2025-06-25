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
    AnnouncementRepository announcementRepository;

    @Autowired
    BestsellerWithHistoryRepository bestsellerWithHistoryRepository;

    @Autowired
    SanctionWithUserRepository sanctionWithUserRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PublicationRequested'"
    )
    public void wheneverPublicationRequested_PublicationRequestToAdminReviewPolicy(
        @Payload PublicationRequested publicationRequested
    ) {
        PublicationRequested event = publicationRequested;
        System.out.println(
            "\n\n##### listener PublicationRequestToAdminReviewPolicy : " +
            publicationRequested +
            "\n\n"
        );
        // Comments //
        //작품 출간 요청 시 운영 컨텍스트로 이벤트를 발행하여 관리자의 심사 및 승인/반려 처리를 유도합니다.

        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
