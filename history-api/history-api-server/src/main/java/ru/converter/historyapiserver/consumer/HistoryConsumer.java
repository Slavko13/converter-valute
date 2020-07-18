package ru.converter.historyapiserver.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;
import ru.converter.historyapiserver.services.HistoryService;
import ru.converter.oauthdb.dto.ResultDTO;

@Component
public class HistoryConsumer {

    private final HistoryService historyService;

    public HistoryConsumer(HistoryService historyService) {
        this.historyService = historyService;
    }

    @RabbitListener(queues = "#{getResultFromConverter.name}")
    public void send(ResultDTO resultDTO) throws MessagingException {
        historyService.saveHistory(resultDTO);
    }


}
