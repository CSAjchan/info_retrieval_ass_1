public class Query {
    public int Id;
    public String Text;

    public Query(int id, String text){
        Id = id;
        Text = text.replaceFirst(".W", "");
    }
}
