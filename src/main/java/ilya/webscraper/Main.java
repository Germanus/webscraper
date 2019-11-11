package ilya.webscraper;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;

import java.io.IOException;

public class Main {

    public static void main(String[] args){

        String baseUrl = "https://habr.com/ru/flows/develop/";

        WebClient client = new WebClient();

        client.getOptions().setJavaScriptEnabled(false);
        client.getOptions().setCssEnabled(false);
        client.getOptions().setUseInsecureSSL(true);
        ProxyConfig proxyConfig = new ProxyConfig();
        proxyConfig.setProxyHost("192.168.55.2");
        proxyConfig.setProxyPort(80);
        client.getOptions().setProxyConfig(proxyConfig);
        client.getCredentialsProvider().setCredentials(AuthScope.ANY, new NTCredentials("name", "password", "", ""));

        try {
            System.out.println("TEST");
            HtmlPage page = client.getPage(baseUrl);
            System.out.println(page.asXml());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
