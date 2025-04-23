import java.util.ArrayList;
import java.util.List;

class Document {
    private final int id;
    private final String name;
    private final List<Document> relatedDocs = new ArrayList<>();

    public Document(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void addRelatedDocument(Document doc) {
        relatedDocs.add(doc);
    }

    public void edit(Document related) {
        List<Document> sortedDocs = new ArrayList<>(relatedDocs);

        Document first = this.getId() < related.getId() ? this : related;
        Document second = this.getId() < related.getId() ? related : this;

        synchronized (first) {
            System.out.println(Thread.currentThread().getName() + " редактирует " + name);
            synchronized (second) {
                for (Document doc : sortedDocs) {
                    System.out.println(Thread.currentThread().getName() + " редактирует связанный документ " + doc.name);
                    // имитация редактирования
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public List<Document> getRelatedDocs() {
        return relatedDocs;
    }
}


