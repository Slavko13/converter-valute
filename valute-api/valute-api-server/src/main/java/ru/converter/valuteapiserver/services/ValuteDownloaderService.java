package ru.converter.valuteapiserver.services;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface ValuteDownloaderService {

    boolean downLoadValuteCourse() throws SAXException, ParserConfigurationException, IOException;

}
