package karumpalakai.domain;

import com.fasterxml.jackson.annotation.JsonView;
import karumpalakai.http.views.SentenceView;

public class Sentence {
    @JsonView(SentenceView.class)
    private String text;

    public Sentence() {
    }

    public Sentence(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
