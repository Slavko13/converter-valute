package ru.converter.historyapiserver.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.converter.oauthdb.domains.History;
import ru.converter.oauthdb.dto.ResultDTO;
import ru.converter.oauthdb.repositories.HistoryRepo;

@Service
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepo historyRepo;


    @Autowired
    public HistoryServiceImpl(HistoryRepo historyRepo) {
        this.historyRepo = historyRepo;
    }


    @Override
    public boolean saveHistory(ResultDTO resultDTO) {
        History history = new History();
        history.setSourceValute(resultDTO.getValuteNameFrom());
        history.setSourceValuteValue(resultDTO.getValuteFromValue());
        history.setTargetValuteValue(resultDTO.getResult());
        history.setTargetValute(resultDTO.getValuteNameTo());
        history.setLocalDate(resultDTO.getLocalDate());
        historyRepo.save(history);
        System.out.println(history);
        return true;
    }
}
