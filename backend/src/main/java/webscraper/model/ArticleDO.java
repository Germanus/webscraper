package webscraper.model;

import java.util.Objects;
import org.springframework.data.annotation.Id;

public class ArticleDO {
    
    @Id
    public String id;
    private String title;    
    private String url;
    private boolean deleted;


    public ArticleDO(String title, String url, boolean deleted) {
        this.title = title;
        this.url = url;
        this.deleted = deleted;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArticleDO() {
    }

    public boolean getDeleted() {
        return this.deleted;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ArticleDO)) {
            return false;
        }
        ArticleDO linkDO = (ArticleDO) o;
        return Objects.equals(id, linkDO.id) && Objects.equals(title, linkDO.title) && Objects.equals(url, linkDO.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, url);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", url='" + getUrl() + "'" +
            ", deleted='" + isDeleted() + "'" +
            "}";
    }
   
}