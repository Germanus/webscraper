package webscraper.rest;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import webscraper.model.Article;
import webscraper.model.ArticleDO;
import webscraper.repository.ArticleRepository;

@RestController
public class HabrController {

    @Autowired 
    private ArticleRepository articleRepository;

    @GetMapping("/habr/articles")
    public List<Article> getDevelopTopics() throws GeneralSecurityException, IOException {
        return this.articleRepository.findByDeleted(false).stream()
        .map(articleDO -> new Article(articleDO.getId(), articleDO.getTitle(), articleDO.getUrl(), articleDO.isDeleted())).collect(Collectors.toList());
    }

    @DeleteMapping("/habr/articles/{articleId}")
    public void markAsDeleted(@PathVariable("articleId") String articleId) {
        System.out.println("Delete"+articleId);
        Optional<ArticleDO> article = this.articleRepository.findById(articleId);
        if(article.isPresent()){
            ArticleDO articleDO = article.get();
            articleDO.setDeleted(true);
            this.articleRepository.save(articleDO);
        }        
    }
}
