package pl.kosmala.tfi;

import org.jsoup.nodes.Document;

public interface IHtmlProvider
{
    public Document provideHtmlFromPage(String url);
}
