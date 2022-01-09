//package io.ace.nordclient.command.commands;
//
//import io.ace.nordclient.command.Command;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class sign extends Command {
//
//
//    @Override
//    public String[] getClientAlias() {
//        return new String[]{"sign"};
//    }
//
//    @Override
//    public String getClientSyntax() {
//        return "sign (sign text sperated by +)";
//    }
//
//    @Override
//    public void onClientCommand(String command, String[] args) throws Exception {
//        if (args[0] != "") {
//            sign fileSearch = new sign();
//            fileSearch.parseFile("src/main/java/io/ace/nordclient/utilz/signs.txt", args[0]);
//        }
//    }
//
//
//
//    public void parseFile(String fileName, String searchStr) throws FileNotFoundException {
//        Scanner scan = new Scanner(new File(fileName));
//        while (scan.hasNext()) {
//            String line = scan.nextLine().toLowerCase().toString();
//            if (line.contains(searchStr)) {
//                Command.sendClientSideMessage(line);
//            }
//        }
//    }
//
//}
