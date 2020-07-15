package webscraper.model;

import java.util.Objects;

public class Article {

    private String id;
    private String title;
    private String href;
    private boolean deleted;

    public Article() {
    }

    public Article(String id, String title, String href, boolean deleted) {
        this.id = id;
        this.title = title;
        this.deleted = deleted;
        this.href = href;
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

    public boolean isDeleted() {
        return this.deleted;
    }

    public boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Article)) {
            return false;
        }
        Article article = (Article) o;
        return Objects.equals(id, article.id) && Objects.equals(title, article.title) && deleted == article.deleted && Objects.equals(href, article.href);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, deleted, href);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", deleted='" + isDeleted() + "'" +
            ", href='" + getHref() + "'" +
            "}";
    }
    
}
