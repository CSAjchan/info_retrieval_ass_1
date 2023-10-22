public class Document {
    public int Id;
    public String Title;
    public String Author;
    public String Bibliography;
    public String Text;

    public Document(int id, String title, String author, String bibliography, String text){
        Id = id;
        Title = title.replaceFirst(".T", "");
        Author = author.replaceFirst(".A", "");
        Bibliography = bibliography.replaceFirst(".B", "");
        Text = text.replaceFirst(".W", "");
    }
}

