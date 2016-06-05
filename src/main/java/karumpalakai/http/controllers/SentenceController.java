package karumpalakai.http.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import karumpalakai.dao.SentenceDao;
import karumpalakai.domain.Sentence;
import karumpalakai.http.views.SentenceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SentenceController {

    @Autowired
    private SentenceDao sentenceDao;

    @RequestMapping(value = "/sentence", method = RequestMethod.POST)
    public void add(@RequestBody Sentence sentence){
        sentenceDao.add(sentence.getText());
    }

    @RequestMapping(value = "/sentence", method = RequestMethod.GET)
    @JsonView(SentenceView.class)
    public List<Sentence> all(){
        return sentenceDao.all();
    }
}
