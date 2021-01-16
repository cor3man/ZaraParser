import org.apache.commons.cli.CommandLine;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import us.codecraft.xsoup.Xsoup;

import java.io.*;

public class Main {

    public static void main(String[] args)
    {

        CLParser clParser = new CLParser(args);
        CommandLine cmd = clParser.getCmd();

        String[] sizes = cmd.getOptionValues("size");
        String page = cmd.getOptionValue("uri");


        Connection conn = Jsoup.connect(page);
        Document document;
        try {
            document = conn.get();
        } catch (IOException e) {
            System.out.println("Page " + page + " not found");
            return;
        }

        Elements elements;
        for (String size: sizes)
        {
            elements = Xsoup.compile("//input[@value='" + size + "' and @name='size']").evaluate(document).getElements();

            if (elements.toString().isEmpty())
                System.out.println("Size " + size + " not present on Page");
            else
            {
                //System.out.println(elements.toString());

                if (elements.hasAttr("disabled")) System.out.println("The size " + size + " is Disabled");
                else System.out.println("The size " + size + " is Enabled");
            }
        }

    }
}
