package pl.kosmala.tfi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JsoupHtmlProvider implements IHtmlProvider
{
    @Override
    public Document provideHtmlFromPage(String url)
    {
        try
        {
            Document document = Jsoup.connect(url).get();
            Attributes attributes = document.body().attributes();
            Element elementById = document.body().getElementById("div-gpt-ad-listing-sponsored-ad-first");
            return document;
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
