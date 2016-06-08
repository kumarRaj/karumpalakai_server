package karumpalakai.domain;

import com.fasterxml.jackson.annotation.JsonView;
import karumpalakai.http.views.SentenceView;

public class Sentence {
    @JsonView(SentenceView.class)
    private Long id;

    @JsonView(SentenceView.class)
    private String text;

    public Sentence() {
    }

    public Sentence(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Long getId() {
        return id;
    }
}
