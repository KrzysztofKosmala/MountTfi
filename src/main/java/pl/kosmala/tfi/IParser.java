package pl.kosmala.tfi;

import org.jsoup.nodes.Document;

import java.util.List;

public interface IParser
{
    List<String> extractOffertsUrlsFromDocument(Document document);
    int extractNumOfPages(Document document);
}
