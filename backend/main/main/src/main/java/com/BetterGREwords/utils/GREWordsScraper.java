package com.BetterGREwords.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.BetterGREwords.model.Words;
import com.BetterGREwords.repository.WordsDAO;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@Service
public class GREWordsScraper {

    public List<Words> words;

    private static final String URL = "https://dict.youdao.com/w/eng/";

    @Autowired
    private WordsDAO wordsDAO;

    public void excelReader(){
        String filepath = "D:\\DesktopFiles\\projects\\ProjectGREwords\\backend\\main\\main\\src\\main\\resources\\gre3000.xlsx";
        words = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(new File(filepath));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            for(Row row : sheet){
                Cell cell0 = row.getCell(0);
                Cell cell1 = row.getCell(1);
                Cell cell2 = row.getCell(2);
                Cell cell3 = row.getCell(3);
                Cell cell4 = row.getCell(4);
                Cell cell5 = row.getCell(5);
                if(cell0 != null){
                    Words word = new Words();
                    word.setWordName(cell0.getStringCellValue());
                    word.setChineseName(cell1.getStringCellValue());
                    words.add(word);
                }
                if(cell2 != null){
                    Words word = new Words();
                    word.setWordName(cell2.getStringCellValue());
                    word.setChineseName(cell3.getStringCellValue());
                    words.add(word);
                }
                if(cell4 != null) {
                    Words word = new Words();
                    word.setWordName(cell4.getStringCellValue());
                    word.setChineseName(cell5.getStringCellValue());
                    words.add(word);
                }
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSentences(){
        for(Words word : this.words) {
            String url = URL + word.getWordName() + "/";
            word.setUrl(url);
            int count = 0;

            try {
                Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();

                Elements exampleBlocks = doc.select("div.exampleLists");

                count++;
                System.out.println("Get example sentences for " + word.getWordName() + "word_count " + count);

                Element example1 = null;
                Element example2 = null;

                if(exampleBlocks.size() >= 1) {
                    example1 = exampleBlocks.get(0).selectFirst("div.examples");
                }

                if(exampleBlocks.size() >= 2) {
                    example2 = exampleBlocks.get(1).selectFirst("div.examples");
                }

                if (example1 != null) {
                    // 获取第一个例句
                    Elements example1Text = example1.select("p");
                    if (example1Text.size() >= 2) {
                        word.setExampleSentence1(example1Text.get(0).text());
                        word.setExampleSentence1Chinese(example1Text.get(1).text());
                    }
                }

                if (example2 != null) {
                    // 获取第二个例句
                    Elements example2Text = example2.select("p");
                    if (example2Text.size() >= 2) {
                        word.setExampleSentence2(example2Text.get(0).text());
                        word.setExampleSentence2Chinese(example2Text.get(1).text());
                    }
                }

                wordsDAO.save(word);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        this.excelReader();
        this.getSentences();
    }
}
