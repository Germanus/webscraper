package webscraper;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequestSettings;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import webscraper.model.ArticleDO;
import webscraper.repository.ArticleRepository;

@SpringBootApplication
public class Main implements CommandLineRunner{

    @Autowired
    private ArticleRepository articleRepository;

    public static void main(final String[] args) {
        SpringApplication.run(Main.class);
    }

    @Override
    public void run(final String... args) throws Exception {
        
        System.out.println("Print All...");
        this.articleRepository.findAll().stream().forEach(System.out::println);

        for(int i=1; i<51; i++){
            String baseUrl = "https://habr.com/ru/flows/develop/page"+i;
            WebClient client = new WebClient();
            client.setJavaScriptEnabled(false);
            WebRequestSettings webRequestSettings = new WebRequestSettings(new URL(baseUrl));
            webRequestSettings.setCharset("UTF-8");
            HtmlPage page = client.getPage(webRequestSettings);
            List<HtmlAnchor> titles = (List<HtmlAnchor>) page.getByXPath("//a[@class='post__title_link']");
            List<ArticleDO> articles = titles.stream().map(htmlAnchor -> new ArticleDO(htmlAnchor.getTextContent(), htmlAnchor.getHrefAttribute(), false)).collect(Collectors.toList());
            for(ArticleDO article : articles){
                if(this.articleRepository.findByUrl(article.getUrl()).isEmpty()){
                    this.articleRepository.save(article);
                    System.out.println("Not Exist:" + article.getUrl());
                } else {
                    System.out.println("Exist:" + article.getUrl());
                }
            }
        }        

    }
}
