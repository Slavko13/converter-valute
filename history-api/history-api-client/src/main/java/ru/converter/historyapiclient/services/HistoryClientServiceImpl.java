package ru.converter.historyapiclient.services;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.converter.oauthdb.dto.ResultDTO;


@Service
public class HistoryClientServiceImpl implements HistoryClientService {

    private final AmqpTemplate amqpTemplate;

    @Value("#{getResultFromConverter.name}")
    private String GET_INFO_FROM_CONVERTER_ABOUT_RESULT;

    public HistoryClientServiceImpl(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Override
    public void sendToSaveHistory(ResultDTO resultDTO) {
        amqpTemplate.convertAndSend(GET_INFO_FROM_CONVERTER_ABOUT_RESULT, resultDTO);
    }
}
