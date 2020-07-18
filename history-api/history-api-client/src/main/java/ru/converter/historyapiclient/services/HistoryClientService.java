package ru.converter.historyapiclient.services;

import ru.converter.oauthdb.dto.ResultDTO;


public interface HistoryClientService {

    void sendToSaveHistory(ResultDTO resultDTO);

}
