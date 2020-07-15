package ru.converter.valuteapiserver.services;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import ru.converter.oauthdb.domains.Valute;
import ru.converter.oauthdb.repositories.ValuteRepo;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;


@Service
public class ValuteDownloaderServiceImpl implements ValuteDownloaderService {

    private final ValuteRepo valuteRepo;

    public ValuteDownloaderServiceImpl(ValuteRepo valuteRepo) {
        this.valuteRepo = valuteRepo;
    }


    @Override
    public boolean downLoadValuteCourse() throws ParserConfigurationException, IOException, SAXException {

        //Created XML document parser
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new InputSource(new StringReader(getValutesFromCFRB())));
        int lengthOfValuteFile = document.getElementsByTagName("Valute").getLength();


        if (lengthOfValuteFile == 0 ) {
            return false;
        }

        //Loop to save all valutes from parser
        for (int i=0; lengthOfValuteFile > i; i++) {
            Valute valute = new Valute();
            valute.setId(Integer.parseInt(document.getElementsByTagName("NumCode").item(i).getTextContent()));
            valute.setCharCode(document.getElementsByTagName("CharCode").item(i).getTextContent());
            valute.setName(document.getElementsByTagName("Name").item(i).getTextContent());
            valute.setValue(Double.parseDouble(document.getElementsByTagName("Value").item(i).getTextContent().replace(",", "."))
                    / Double.parseDouble(document.getElementsByTagName("Nominal").item(i).getTextContent()));
            valuteRepo.save(valute);
        }
        return true;
    }

    private String getValutesFromCFRB() throws IOException {
        String adr= "http://www.cbr.ru/scripts/XML_daily.asp";
        URL url = null;
        HttpURLConnection connection = null;
        BufferedReader bufferedReader = null;
        String str;


        StringBuilder stringBuilder = new StringBuilder();
        url = new URL(adr); //создаем URL
        connection = (HttpURLConnection)url.openConnection(); //Open connection to valute site
        bufferedReader = new BufferedReader(new InputStreamReader(
                connection.getInputStream(), "Cp1251")); // Using BufferedReader for strings

        while((str = bufferedReader.readLine()) != null){ // while end of file read strings and adding to Final string
            stringBuilder.append(str);
        }
        bufferedReader.close(); //close buffer thread
        connection.disconnect();
        return stringBuilder.toString();
    }

}
