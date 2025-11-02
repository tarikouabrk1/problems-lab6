package problem3;

public abstract class Document {
    private static int counter = 1; // auto-incremental
    protected int numRec;
    protected String title;

    public Document(String title) {
        this.title = title;
        this.numRec = counter++;
    }

    public int getNumRec() {
        return numRec;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Document [numRec=" + numRec + ", title=" + title + "]";
    }
}

