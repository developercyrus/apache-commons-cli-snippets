package foo.bar.cli;

import org.apache.log4j.Logger;

import foo.bar.client.Main;

import java.time.LocalDate;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class Cli {
	private static final Logger log = Logger.getLogger(Cli.class.getName());
	private String[] args = null;
	private Options options = new Options();

	public static void main(String[] args) {
		new Cli(args).parse();
		System.exit(0);
	}
	
	
	public Cli(String[] args) {
		this.args = args;

		Option help = Option.builder("h")
				            .longOpt("help")
				            .required(false)
				            .desc("show help.")
				            .build();
		

		Option day = Option.builder("d")
				            .longOpt("day")
				            .required(false)
				            .desc("the day value that you want to extract figures, e.g. today, this is -d=0; yesterday, this is -d=-1.")
				            .type(Number.class)
				            .hasArg()
				            .build();
		
		Option month = Option.builder("m")
				            .longOpt("month")
				            .required(false)
				            .desc("the month value that you want to extract figures, e.g. current month, this is -m=0; last month, this is -m=-1.")
				            .type(Number.class)
				            .hasArg()
				            .build();
		

		
		options.addOption(help);
		options.addOption(day);
		options.addOption(month);

	}

	public void parse() {
		//if using this, it will throw Unrecognized option error, when the value is a negative value e.g, -m -1
		//CommandLineParser parser = new DefaultParser();
		//CommandLineParser parser = new PosixParser();
		GnuParser parser = new GnuParser();

		CommandLine cmd = null;
		try {
			cmd = parser.parse(options, args);

			if (cmd.hasOption("h")) {
				this.help();
			}
			
			if (cmd.hasOption("d")) {
				Main.daily(LocalDate.now(), ((Number)cmd.getParsedOptionValue("d")).intValue());
			}
			
			if (cmd.hasOption("m")) {
				Main.monthly(LocalDate.now(), ((Number)cmd.getParsedOptionValue("m")).intValue());
			}
			
		} catch (ParseException e) {
			log.error("Failed to parse comand line properties", e);
			this.help();
		}
	}

	private void help() {
		HelpFormatter formater = new HelpFormatter();

		formater.printHelp(foo.bar.cli.Cli.class.getName(), options);
		System.exit(0);
	}
}