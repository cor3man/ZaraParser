import org.apache.commons.cli.*;

public class CLParser extends DefaultParser {

    private Options options;
    private CommandLine cmd;

    public CLParser(String[] args)
    {
        super();

        setOptions();
        validate(args);
    }

    public CommandLine getCmd()
    {
        return cmd;
    }

    private void validate(String[] args)
    {
        HelpFormatter formatter = new HelpFormatter();

        try {
            cmd = this.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("Zara Parser", options);

            System.exit(1);
        }
    }

    private void setOptions()
    {
        options = new Options();

        Option uri = new Option("u", "uri", true, "URI of Page to parse");
        uri.setRequired(true);
        options.addOption(uri);
    }
}
