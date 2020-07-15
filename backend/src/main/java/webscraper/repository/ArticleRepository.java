package webscraper.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import webscraper.model.ArticleDO;

public interface ArticleRepository extends MongoRepository<ArticleDO, String> {

    public ArticleDO findByTitle(String title);

    public List<ArticleDO> findByDeleted(Boolean deleted);

    public List<ArticleDO> findByUrl(String url);
    
}