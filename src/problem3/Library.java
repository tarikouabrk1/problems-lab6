package problem3;

import java.util.ArrayList;

public class Library {
    private int capacity;
    private ArrayList<Document> documents;

    public Library(int capacity) {
        this.capacity = capacity;
        this.documents = new ArrayList<>();
    }

    public boolean add(Document doc) {
        if (documents.size() < capacity) {
            documents.add(doc);
            return true;
        }
        return false;
    }

    public boolean delete(Document doc) {
        return documents.remove(doc);
    }

    public void displayDocuments() {
        for (Document d : documents) {
            System.out.println(d);
        }
    }

    public Document document(int numRec) {
        for (Document d : documents) {
            if (d.getNumRec() == numRec)
                return d;
        }
        return null;
    }

    public void displayAuthors() {
        for (Document d : documents) {
            if (d instanceof Book) {
                System.out.println(((Book) d).getAuthor());
            }
        }
    }
}
