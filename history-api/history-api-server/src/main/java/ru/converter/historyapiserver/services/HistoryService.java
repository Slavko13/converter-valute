package ru.converter.historyapiserver.services;

import ru.converter.oauthdb.dto.ResultDTO;

public interface HistoryService {

    boolean saveHistory(ResultDTO resultDTO);

}
