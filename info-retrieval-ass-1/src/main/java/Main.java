import javax.print.Doc;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main {
    public static final String ID = ".I";
    public static final String TITLE = ".T";
    public static final String AUTHOR = ".A";
    public static final String BIBLIOGRAPHY = ".B";
    public static final String TEXT = ".W";

    public static ArrayList<Document> ReadDocuments(String path){
        ArrayList<Document> documents = new ArrayList<>();
        InputStream inputStream = Main.class.getResourceAsStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

        try {
            String line = "";
            int idIndex = 0;
            String documentLines = "";

            //go through all the lines find Document lines from .I to .I send each document lines into a Document parser
            while((line = bufferedReader.readLine()) != null){
                if(line.startsWith(ID) && idIndex != 0){
                    documents.add(ParseDocument(documentLines));
                    documentLines = "";
                    documentLines = documentLines + " " + line;
                }
                documentLines = documentLines + " " + line;
                idIndex += 1;
            }
            documents.add(ParseDocument(documentLines));
        }
        catch (IOException e){
            System.out.println(e);
        }

        return documents;
    }

    public static ArrayList<Query> ReadQueries(String path){
        ArrayList<Query> queries = new ArrayList<>();
        InputStream inputStream = Main.class.getResourceAsStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

        try {
            String line = "";
            int idIndex = 0;
            String queryLines = "";

            while((line = bufferedReader.readLine()) != null){
                if(line.startsWith(ID) && idIndex != 0){
                    queries.add(ParseQuery(queryLines));
                    queryLines = "";
                    queryLines = queryLines + " " + line;
                }
                queryLines = queryLines + " " + line;
                idIndex += 1;
            }
            queries.add(ParseQuery(queryLines));
        }
        catch (IOException e){
            System.out.println(e);
        }

        return queries;
    }

    public static Document ParseDocument(String documentLines){
        int id = Integer.parseInt(getSubstring(documentLines, ID, TITLE).split(" ")[1]);
        String title = getSubstring(documentLines, TITLE, AUTHOR);
        String author = getSubstring(documentLines, AUTHOR, BIBLIOGRAPHY);
        String bibliography = getSubstring(documentLines, BIBLIOGRAPHY, TEXT);
        String text = getSubstring(documentLines, TEXT);

        return new Document(id, title, author, bibliography, text);
    }

    public static Query ParseQuery(String queryLines){
        int id = Integer.parseInt(getSubstring(queryLines, ID, TEXT).split(" ")[1]);
        String text = getSubstring(queryLines, TEXT);

        return new Query(id, text);
    }

    public static String getSubstring(String documentLines, String sectionStart, String sectionEnd){
        int startingIndexOfString = documentLines.indexOf(sectionStart);
        int endingIndexOfString = documentLines.indexOf(sectionEnd);

        return documentLines.substring(startingIndexOfString, endingIndexOfString);
    }

    public static String getSubstring(String documentLines, String sectionStart){
        int startingIndexOfString = documentLines.indexOf(sectionStart);

        return documentLines.substring(startingIndexOfString);
    }

    public static void main(String[] args){
        ArrayList<Document> documents = ReadDocuments("/cran.all.1400");
        ArrayList<Query> queries = ReadQueries("/cran.qry");
        //documents.forEach(document -> System.out.println(document.Id + " " + document.Author));
        //System.out.println(documents.size());
        //queries.forEach(query -> System.out.println(query.Id + " " + query.Text));
        //System.out.println(queries.size());
    }
}
