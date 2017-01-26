package evg.testt.util.fullcalendar;

import lombok.Data;

public
@Data
class UrlWrapper {
    private String after;

    private String before;

    private String content;

    private String fullUrl;

    public UrlWrapper() {
    }

    public UrlWrapper before(String before) {
        this.setBefore(before);
        return this;
    }

    public UrlWrapper after(String after) {
        this.setAfter(after);
        return this;
    }

    public UrlWrapper content(String after) {
        this.setAfter(after);
        return this;
    }

    public String wrap(){
        setFullUrl(getBefore() + getContent() + getAfter());
        return  getFullUrl();
    }


}
