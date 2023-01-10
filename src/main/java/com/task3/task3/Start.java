package com.task3.task3;

import com.task3.task3.model.TextDoc;
import com.task3.task3.service.TextServiceImp;
import org.apache.commons.cli.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Start {

    private TextServiceImp service;

    @Autowired
    Start(TextServiceImp service) {
        this.service = service;
    }

    public void execute(String[] args) {
        List<String> commands = new ArrayList<>();
        commands.add("add");
        commands.add("search");

        Options options = new Options();
        options.addOption("s", true, "text");
        options.addOption("e", true, "command add/search");

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("s") && cmd.hasOption("e") && commands.contains(cmd.getOptionValue("e"))) {
                TextDoc textDoc = new TextDoc(cmd.getOptionValue("s"));
                switch (cmd.getOptionValue("e")) {
                    case "add":
                        service.save(textDoc);
                        System.out.println("Document added");
                        break;
                    case "search":
                        Iterable<TextDoc> textDocs = service.findByText(textDoc.getText());
                        System.out.println("Documents:");
                        for (TextDoc text:textDocs) {
                            System.out.println(text);
                        }
                        break;
                }
            } else {
                System.out.println("No arguments");
            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
