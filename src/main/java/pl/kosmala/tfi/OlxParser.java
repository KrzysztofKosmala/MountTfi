package pl.kosmala.tfi;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.cglib.core.HashCodeCustomizer;

import java.util.List;

public class OlxParser implements IParser
{
Object

    @Override
    public List<String> extractOffertsUrlsFromDocument(Document document)
    {

        return document.body().getElementsByClass("css-1bbgabe").stream().map(e -> e.attr("href")).filter(e -> e.startsWith("/d")).toList();
    }

    @Override
    public int extractNumOfPages(Document document)
    {
        Elements elementsByClass = document.body().getElementsByClass("css-1mi714g");
        int size = elementsByClass.size();
        Element element = elementsByClass.get(size-1);
        String href = element.attr("href");
        int i = href.indexOf("=");
        String substring = href.substring(i+1);
        int lastPage = Integer.parseInt(substring);
        return lastPage;
    }
}
