package learn.memories.models;

public class Memory {
    // 1. An id gives us a way to uniquely identify a memory, even if the other fields are identical.
    private int id;
    // The person who shared the memory.
    private String from;
    // The memory.
    private String content;
    // If shareable is false, it is a private memory. Otherwise, it's public.
    private boolean shareable;

    // 2. Constructor for creating a brand-new memory.
    public Memory() {
    }

    // 3. Constructor for representing an existing memory stored in a file.
    public Memory(int id, String from, String content, boolean shareable) {
        this.id = id;
        this.from = from;
        this.content = content;
        this.shareable = shareable;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setShareable(boolean shareable) {
        this.shareable = shareable;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getContent() {
        return content;
    }

    public boolean isShareable() {
        return shareable;
    }
}
